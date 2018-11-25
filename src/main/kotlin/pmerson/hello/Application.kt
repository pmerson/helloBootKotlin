package pmerson.hello

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["pmerson"])
class Aplicacao

    fun main(args: Array<String>) {
        runApplication<Aplicacao>(*args)
    }
