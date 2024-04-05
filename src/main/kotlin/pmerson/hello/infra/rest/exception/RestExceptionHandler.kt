package pmerson.hello.infra.rest.exception

import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
@ResponseBody
@Order(Ordered.HIGHEST_PRECEDENCE)
class RestExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleUnexpectedException(req: HttpServletRequest, resp: HttpServletResponse, ex: Exception): ErrorInfo {
        resp.status = HttpStatus.INTERNAL_SERVER_ERROR.value()
        ex.printStackTrace()
        return ErrorInfo(LocalDateTime.now(), 500, ex.message)
    }

}

data class ErrorInfo(
        val timestamp: LocalDateTime?,
        val statusCode : Int?,
        val errorMessage : String?
)
