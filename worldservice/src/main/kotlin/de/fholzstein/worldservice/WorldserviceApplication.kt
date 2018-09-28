package de.fholzstein.worldservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WorldserviceApplication

fun main(args: Array<String>) {
    runApplication<WorldserviceApplication>(*args)
}
