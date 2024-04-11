package com.example

import com.example.plugins.*
import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.util.*
import kotlin.concurrent.schedule

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureMonitoring()
    configureRouting()
    val timer = Timer()
    val lorem: Lorem = LoremIpsum.getInstance()

    timer.schedule(0L, 1000L) {
        log.trace(lorem.getWords(5, 10))
        log.debug(lorem.getWords(5, 10))
        log.info(lorem.getWords(5, 10))
        log.warn(lorem.getWords(5, 10))
    }

    timer.schedule(0L, 60000L) {
        log.error(lorem.getWords(3), Exception("Random Exception"))
    }
}
