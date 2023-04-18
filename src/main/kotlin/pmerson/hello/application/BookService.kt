package pmerson.hello.application

import org.springframework.stereotype.Service
import pmerson.hello.infra.restclient.RecommendationClient
import pmerson.hello.infra.restclient.RecommendationDto

@Service
class BookService(val recommendationClient: RecommendationClient) {

    fun getRelatedBooks(isbn: String): List<RelatedBookDto> {
        val recommendations = recommendationClient.getRecommendedTitlesByIsbn(isbn)
        val relatedBooks = arrayListOf<RelatedBookDto>()
        recommendations.forEach { it: RecommendationDto ->
            relatedBooks.add(RelatedBookDto(it.isbn, it.title, it.authors))
        }
        return relatedBooks
    }

}