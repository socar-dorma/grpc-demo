package kr.socar.grpc.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
class Controller {
    @Resource(name = "helloWorldClient")
    private lateinit var helloWorldClient: HelloWorldClient

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): String {
        return helloWorldClient.greet(name)
    }
}
