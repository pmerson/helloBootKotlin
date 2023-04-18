package pmerson.hello.infra.restclient

import feign.Param
import feign.RequestLine

interface IRecommendationClient {

    @RequestLine("GET /recommended-titles/isbn/{isbn}")
    fun getRecommendedTitlesByIsbn(
            @Param("isbn") isbn: String
    ): List<RecommendationDto>

}