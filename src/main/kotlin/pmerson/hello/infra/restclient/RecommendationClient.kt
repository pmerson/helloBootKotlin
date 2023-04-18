package pmerson.hello.infra.restclient

import com.fasterxml.jackson.databind.ObjectMapper
import feign.Feign
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import feign.jackson.JacksonEncoder
import feign.jackson.JacksonDecoder
import org.springframework.stereotype.Component


@Component
class RecommendationClient {

    @Value("\${URL_BASE_RECOMMENDATION:http://44.214.218.139}")    // http://localhost}")
    lateinit var urlBase: String

    @Autowired
    private lateinit var mapper: ObjectMapper

    fun getRecommendedTitlesByIsbn(isbn: String): List<RecommendationDto> {
        return service().getRecommendedTitlesByIsbn(isbn)
    }

    private fun service(): IRecommendationClient {
        return Feign.builder()
                .encoder(JacksonEncoder(mapper))
                .decoder(JacksonDecoder(mapper))
                .target(IRecommendationClient::class.java, urlBase)
    }

}