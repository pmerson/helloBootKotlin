package pmerson.hello.application

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import pmerson.hello.infra.restclient.RecommendationClient
import java.io.File
import java.time.LocalDateTime

@Service
class GreetingService(val recommendationClient: RecommendationClient) {   // val bookClient: BookClient, val customerClient: CustomerClient) {

    @Value("\${spring.profiles.active:dev}")
    private lateinit var ec2Instance: String

    fun createGreeting(name: String?, clientType: String?): GreetingDto {
        val quote = File("/data/quotes.txt").readText(Charsets.UTF_8)
        val dateTime = LocalDateTime.now()
        if (name.isNullOrBlank()) {
            return GreetingDto("Hello mysterious user. What's your name?", dateTime, quote, clientType)
        } else if (name == "Voldemort") {
            throw IllegalAccessError("There's no talking to $name!")
        }

        var greeting = "Hello $name!"   //  from $ec2Instance!"

        // Call to a backend service

        println("*** WILL CALL THE RECOMMENDATIONS SERVICE BASED OF X-Client-Type HEADER ($clientType) ***")
//        var recommendationDtos: List<RecommendationDto>? = null
//        if (clientType == "Web")
//            recommendationDtos = recommendationClient.getRecommendedTitlesByIsbn("9780321815736")  // DSA, EAI
//        else if (clientType == "iOS" || clientType == "Android")
//            recommendationDtos = recommendationClient.getRecommendedTitlesByIsbn("978-0395489321")  // The Hobbit

        val recommendationDtos =
                if (clientType == "Web")
                    recommendationClient.getRecommendedTitlesByIsbn("9780321815736")  // DSA, EAI
                else if (clientType == "iOS" || clientType == "Android")
                    recommendationClient.getRecommendedTitlesByIsbn("978-0395489321")  // The Hobbit
                else
                    null
        recommendationDtos?.let { greeting = greeting + " We recomment this book: ${recommendationDtos[0].title}" }

        println("*** greeting is: '$greeting' ***")

        return GreetingDto(greeting, dateTime, quote, clientType)
    }

}


//        if (name.startsWith("book", true)) {
//            println("*** WILL CALL THE BOOK SERVICE ***")
//            val bookDto = bookClient.getBookByIsbn(name.substring(4))
//            greeting = greeting + " We (${bookDto.ec2Instance}) got your BOOK isbn ${bookDto.ISBN} title ${bookDto.title}. YAY!"
//            println("*** SUCCESSFUL BOOK SERVICE CALL ***")
//        } else         if (name.startsWith("customer", true)) {
//            println("=== WILL CALL THE CUSTOMER SERVICE ===")
//            val customerDto = customerClient.getCustomerById(name.substring(8).toLong())
//            greeting = greeting + " We (${customerDto.ec2Instance}) got your CUSTOMER id ${customerDto.id} name ${customerDto.name}. COOL!"
//            println("=== SUCCESSFUL CUSTOMER SERVICE CALL ===")
//        }
