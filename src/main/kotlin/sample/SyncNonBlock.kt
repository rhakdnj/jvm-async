package sample

import io.github.oshai.kotlinlogging.KotlinLogging
import java.util.concurrent.CompletableFuture
import kotlin.system.measureTimeMillis

fun main() {
    measureTimeMillis {
        val futureA = subA()
        val futureB = subB()
        CompletableFuture.allOf(futureA, futureB).join() // futureA, futureB 대기
    }.let { logger.debug { ">> elapsed: $it ms" } }
}

private val logger = KotlinLogging.logger {}

private fun subA() =
    CompletableFuture.supplyAsync {
        logger.debug { "start A" }
        Thread.sleep(3_000)
        logger.debug { "end A" }
    }

private fun subB() =
    CompletableFuture.supplyAsync {
        logger.debug { "start B" }
        Thread.sleep(1_000)
        logger.debug { "end B" }
    }
