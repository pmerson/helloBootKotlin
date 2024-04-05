package pmerson.hello.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pmerson.hello.application.BookRecommendationsService
import pmerson.hello.application.GreetingDto
import pmerson.hello.application.GreetingService
import pmerson.hello.application.RelatedBookDto
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("api")
class HelloWorldController(val greetingService: GreetingService) {


    @RequestMapping(value = ["/greeting"], method = [RequestMethod.POST],
            headers = ["content-type=text/plain"])
    fun sayHello(@RequestBody name: String?,
                 @RequestHeader("X-Client-Type") clientType: String?,
                 response: HttpServletResponse): ResponseEntity<GreetingDto> {
        val greetingDto = greetingService.createGreeting(name, clientType)
        return ResponseEntity(greetingDto, HttpStatus.OK)
    }

}

