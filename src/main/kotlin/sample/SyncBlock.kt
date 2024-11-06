package sample

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlin.system.measureTimeMillis

private val logger = KotlinLogging.logger {}

fun main() {
    measureTimeMillis {
        subA()
        subB()
    }.let { logger.debug { ">> elapsed: $it ms" } }
}

private fun subA() {
    logger.debug { "start A" }
    Thread.sleep(1_000)
    logger.debug { "end A" }
}

private fun subB() {
    logger.debug { "start B" }
    Thread.sleep(1_000)
    logger.debug { "end B" }
}
