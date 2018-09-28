package de.fholzstein.helloservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class HelloController {

    val minWait = 1000
    val maxWait = 5000

    @GetMapping("hello")
    fun hello (): String {
        Thread.sleep((Random().nextInt(maxWait - minWait) + minWait).toLong())
        return "Hello"
    }
}