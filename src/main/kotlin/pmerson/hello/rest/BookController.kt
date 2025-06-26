package pmerson.hello.rest

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pmerson.hello.application.BookDto
import pmerson.hello.application.BookRecommendationsService
import pmerson.hello.application.RelatedBookDto

@RestController
@RequestMapping("api")
class BookController(val bookRecommendationsService: BookRecommendationsService) {

    @Value("\${spring.profiles.active:dev}")
    private lateinit var ec2Instance: String

    @GetMapping("/books/{isbn}")
    fun getBookByIsbn(@PathVariable isbn: String): ResponseEntity<BookDto> {
        println("*** Book service on $ec2Instance got your GET book ISBN $isbn ***")
        val bookDto = BookDto(isbn, "Software Architecture in Practice", "Bass, L.",
                "seminal book on software architecture", "non-fiction", 59.95, 99, ec2Instance)
        return ResponseEntity(bookDto, HttpStatus.OK)
    }

    @GetMapping("/books/{isbn}/related-books")
    fun getBookRecommendations(@PathVariable isbn: String): ResponseEntity<List<RelatedBookDto>> {
        return ResponseEntity(bookRecommendationsService.getRelatedBooks(isbn), HttpStatus.OK)
    }


}

