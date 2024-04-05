package pmerson.hello.infra.restclient

import feign.Param
import feign.RequestLine
import pmerson.hello.application.BookDto
import pmerson.hello.application.CustomerDto

interface ICustomerClient {

    @RequestLine("GET /api/customers/{id}")
    fun getCustomerById(
            @Param("id") id: Long
    ): CustomerDto

}