package pmerson.hello.application

import org.springframework.stereotype.Service
import pmerson.hello.infra.emailer.Emailer
import pmerson.hello.infra.restclient.RecommendationClient
import pmerson.hello.infra.restclient.RecommendationDto

@Service
class BookRecommendationsService(val recommendationClient: RecommendationClient, val emailer: Emailer) {

    fun getRelatedBooks(isbn: String): List<RelatedBookDto> {
        println("*** WILL CALL THE RECOMMENDATIONS SERVICE ***")
        val recommendations = recommendationClient.getRecommendedTitlesByIsbn(isbn)
        println("*** SUCCESS ***")
        val relatedBooks = arrayListOf<RelatedBookDto>()
        recommendations.forEach { it: RecommendationDto ->
            relatedBooks.add(RelatedBookDto(it.isbn, it.title, it.authors))
        }
//        emailer.send(
//                "pmerson@andrew.cmu.deu",
//                arrayOf("pmerson@acm.org"),
//                "Activate your book store account",
//                """
//                    Dear reader of $isbn,
//                    Welcome to the Book store created by pmerson.
//                    Exceptionally this time we won’t ask you to click a link to activate your account.
//                    """.trimIndent(),
//                false,
//        )
        return relatedBooks
    }

}