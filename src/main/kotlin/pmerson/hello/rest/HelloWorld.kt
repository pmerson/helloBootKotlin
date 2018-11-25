package br.gov.tcu.sofia.rest


import br.gov.tcu.sofia.aplicacao.ResultadoValidacaoDto
import br.gov.tcu.sofia.aplicacao.ValidacaoTextoServico
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("api")
@Api(value = "sofia-ms validação de documento")
class ValidacaoTexto(val servicoAplicacao: ValidacaoTextoServico) {

    @PostMapping("/validacao-documento")
    @RequestMapping(value = ["/validacao-documento"], method = [RequestMethod.POST],
            headers = ["content-type=text/plain"])
    @ApiOperation(value = "Executa a validação de um texto, procurando por acórdãos, processos, entidades, etc.")
    fun validaTexto(@RequestBody @ApiParam(value = "Texto sem formatação") texto: String, response: HttpServletResponse): ResponseEntity<ResultadoValidacaoDto?> {
        val resultadoValidacaoDto = servicoAplicacao.validaTexto(texto)
        return ResponseEntity(resultadoValidacaoDto, HttpStatus.OK)
    }

}




