package br.gov.tcu.sofia.aplicacao

import org.springframework.stereotype.Service

@Service
class ValidacaoTextoServico(val validacaoDocumento: ValidacaoDocumento, val validacaoAcordao: ValidacaoAcordao,
                            val validacaoProcesso: ValidacaoProcesso, val validacaoData: ValidacaoData,
                            val validacaoCnpj: ValidacaoCnpj) {

    fun validaTexto(texto: String): ResultadoValidacaoDto? {
        var resultadoValidacaoDto = ResultadoValidacaoDto(texto.substringBefore('\r'))
        resultadoValidacaoDto.acordaos = validacaoAcordao.validaAcordao(texto)
        resultadoValidacaoDto.processos = validacaoProcesso.validaProcessos(texto)
        resultadoValidacaoDto.documentos = validacaoDocumento.validaDocumentos(texto)
        resultadoValidacaoDto.datasInvalidas = validacaoData.identificaDatasInvalidas(texto)
        resultadoValidacaoDto.cnpjs = validacaoCnpj.validaCnpjs(texto)
        return resultadoValidacaoDto
    }

}