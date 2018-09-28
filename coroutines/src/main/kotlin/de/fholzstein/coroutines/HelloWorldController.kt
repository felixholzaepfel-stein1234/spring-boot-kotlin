package de.fholzstein.coroutines

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class HelloWorldController(@Autowired val restTemplateBuilder: RestTemplateBuilder) {
    val restTemplate : RestTemplate

    init {
        restTemplate = restTemplateBuilder.build()
    }

    @GetMapping("/helloWorld")
    fun hello () : String {
        val helloString = restTemplate.getForEntity("http://helloservice:8080/hello", String::class.java).body
        val worldString = restTemplate.getForEntity("http://worldservice:8080/world", String::class.java).body
        return "$helloString $worldString"
    }
}