package pmerson.hello.infra.restclient

import com.fasterxml.jackson.databind.ObjectMapper
import feign.Feign
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import feign.jackson.JacksonEncoder
import feign.jackson.JacksonDecoder
import org.springframework.stereotype.Component
import pmerson.hello.application.BookDto


@Component
class BookClient {

    @Value("\${URL_BASE_BACKEND_SERVICES:http://localhost:3000}")
    lateinit var urlBase: String

    @Autowired
    private lateinit var mapper: ObjectMapper

    fun getBookByIsbn(isbn: String): BookDto {
        return service().getBookByIsbn(isbn)
    }

    private fun service(): IBookClient {
        return Feign.builder()
                .encoder(JacksonEncoder(mapper))
                .decoder(JacksonDecoder(mapper))
                .target(IBookClient::class.java, urlBase)
    }

}