package pmerson.hello.infra.restclient

import feign.Param
import feign.RequestLine
import pmerson.hello.application.BookDto

interface IBookClient {

    @RequestLine("GET /api/books/{isbn}")
    fun getBookByIsbn(
            @Param("isbn") isbn: String
    ): BookDto

}