package br.gov.tcu.infra.sofia

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["br.gov.tcu"])
@EnableFeignClients
class Aplicacao

    fun main(args: Array<String>) {
        runApplication<Aplicacao>(*args)
    }
