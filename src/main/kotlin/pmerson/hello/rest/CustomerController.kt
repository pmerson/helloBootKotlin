package pmerson.hello.rest

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pmerson.hello.application.CustomerDto
import pmerson.hello.infra.emailer.Emailer
import javax.servlet.http.HttpServletResponse
import kotlin.random.Random

@RestController
@RequestMapping("api")
class CustomerController(val emailer: Emailer) {

    @Value("\${spring.profiles.active:dev}")
    private lateinit var ec2Instance: String

    @Value("\${spring.mail.username}")
    private lateinit var fromAddress: String

    @Value("\${spring.mail.password}")
    private lateinit var pwd: String

    @GetMapping("/customers/{id}")
    fun getCustomerById(@PathVariable id: Long): ResponseEntity<CustomerDto> {
        println("--- Customer service on $ec2Instance got your GET customer ID $id ---")
        val customerDto = CustomerDto(id, "starlord2002@gmail.com", "Star Lord", "+14122144122",
                "48 Galaxy Rd", "suite 4", "Fargo", "ND", "58102", ec2Instance)
        return ResponseEntity(customerDto, HttpStatus.OK)
    }

    @RequestMapping(value = ["/customers"], method = [RequestMethod.POST])
    fun createCustomer(@RequestBody customerDto: CustomerDto,
                       response: HttpServletResponse): ResponseEntity<CustomerDto> {
        customerDto.id = Random.nextLong(1, 1001)
        sendEmail(customerDto);
        return ResponseEntity(customerDto, HttpStatus.OK)
    }

    private fun sendEmail(customerDto: CustomerDto) {
        println("---> will send email from $fromAddress ($pwd) to pmerson@acm.org --->")
        emailer.send(
                "pmerson@acm.org",
                "Activate your book store account",
                """
                    Dear ${customerDto.name},
                    Welcome to the Book store created by pmerson.
                    Exceptionally this time we won’t ask you to click a link to activate your account.
                    """.trimIndent()
        )
    }


}

