package de.fholzstein.coroutines

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.kotlin.experimental.coroutine.EnableCoroutine

@Configuration
@EnableCoroutine
class Configuration

@SpringBootApplication
class CoroutinesApplication

fun main(args: Array<String>) {
    runApplication<CoroutinesApplication>(*args)
}
