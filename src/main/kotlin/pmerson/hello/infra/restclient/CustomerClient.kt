package pmerson.hello.infra.restclient

import com.fasterxml.jackson.databind.ObjectMapper
import feign.Feign
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import feign.jackson.JacksonEncoder
import feign.jackson.JacksonDecoder
import org.springframework.stereotype.Component
import pmerson.hello.application.BookDto
import pmerson.hello.application.CustomerDto


@Component
class CustomerClient {

    @Value("\${URL_BASE_BACKEND_SERVICES:http://localhost:3000}")
    lateinit var urlBase: String

    @Autowired
    private lateinit var mapper: ObjectMapper

    fun getCustomerById(id: Long): CustomerDto {
        return service().getCustomerById(id)
    }

    private fun service(): ICustomerClient {
        return Feign.builder()
                .encoder(JacksonEncoder(mapper))
                .decoder(JacksonDecoder(mapper))
                .target(ICustomerClient::class.java, urlBase)
    }

}