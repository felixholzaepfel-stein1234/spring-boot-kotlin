package de.fholzstein.worldservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WorldController {

    @GetMapping("/world")
    fun world() = "World"
}