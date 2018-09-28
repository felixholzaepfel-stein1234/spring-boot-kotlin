package de.fholzstein.worldservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class WorldController {

    val minWait = 1000
    val maxWait = 5000

    @GetMapping("/world")
    fun world(): String {
        Thread.sleep((Random().nextInt(maxWait - minWait) + minWait).toLong())
        return "World"
    }
}