package org.rookedsysc.nplusoneexample.infrastructure.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/tests")
class TestController {

    @GetMapping
    fun getTests(): String {
        return "Hello, World!"
    }
}