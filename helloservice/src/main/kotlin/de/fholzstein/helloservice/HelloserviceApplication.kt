package de.fholzstein.helloservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloserviceApplication

fun main(args: Array<String>) {
    runApplication<HelloserviceApplication>(*args)
}
