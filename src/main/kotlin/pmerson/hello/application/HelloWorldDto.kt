package br.gov.tcu.sofia.aplicacao

import java.time.LocalDateTime

class ResultadoValidacaoDto(var primeiraLinhaDocumento: String) {
    var dataHoraValidacao = LocalDateTime.now()
    var acordaos: List<AcordaoDto>? = null
    var processos: List<ProcessoDto>? = null
    var documentos: List<DocumentoDto>? = null
    var datasInvalidas: List<String>? = null
    var cnpjs: List<CnpjDto>? = null
    var convenios: List<ConvenioDto>? = null
    // TODO: adicionar faltantes
}

