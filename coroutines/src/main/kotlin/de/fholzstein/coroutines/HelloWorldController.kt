package de.fholzstein.coroutines

import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import kotlin.system.measureTimeMillis

@RestController
class HelloWorldController(@Autowired val restTemplateBuilder: RestTemplateBuilder) {
    val restTemplate: RestTemplate

    init {
        restTemplate = restTemplateBuilder.build()
    }

    @GetMapping("/helloWorld")
    suspend fun hello(): String {
        var helloDeferred : Deferred<String?>? = null
        var worldDeferred : Deferred<String?>? = null

        val timeMillis = measureTimeMillis {
             launch {
                helloDeferred = async {
                    restTemplate.getForEntity("http://helloservice:8080/hello", String::class.java).body
                }

                worldDeferred = async {
                    restTemplate.getForEntity("http://worldservice:8080/world", String::class.java).body
                }
            }.join()
        }

        return "${helloDeferred!!.await()} ${worldDeferred!!.await()}, called in $timeMillis ms"
    }
}