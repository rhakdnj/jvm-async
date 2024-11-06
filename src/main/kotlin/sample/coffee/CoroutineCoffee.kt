@file:Suppress("ktlint:standard:no-wildcard-imports")

package sample.coffee

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

private val logger = KotlinLogging.logger {}

private val worker = newSingleThreadContext("employee")

fun main() {
    measureTimeMillis {
        runBlocking {
            launch(worker) { makeCoffee() }
        }
    }.let { logger.debug { ">> elapsed: $it ms" } }
}

private suspend fun makeCoffee() {
    coroutineScope {
        launch {
            grindCoffee()
            brewCoffee()
        }
        launch {
            boilMilk()
            formMilk()
        }
    }
    mixCoffeeAndMilk()
}

private suspend fun grindCoffee() {
    logger.debug { "start grind coffee" }
    delay(1_000)
    logger.debug { "end grind coffee" }
}

private suspend fun brewCoffee() {
    logger.debug { "start brew coffee" }
    delay(1_000)
    logger.debug { "end brew coffee" }
}

private suspend fun boilMilk() {
    logger.debug { "start boil mik" }
    delay(1_000)
    logger.debug { "end boil mik" }
}

private suspend fun formMilk() {
    logger.debug { "start form milk" }
    delay(1_000)
    logger.debug { "end form milk" }
}

private suspend fun mixCoffeeAndMilk() {
    logger.debug { "start mix coffee and milk" }
    delay(1_000)
    logger.debug { "end mix coffee and milk" }
}
