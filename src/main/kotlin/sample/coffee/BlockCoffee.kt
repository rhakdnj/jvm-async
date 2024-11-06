package sample.coffee

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlin.system.measureTimeMillis

private val logger = KotlinLogging.logger {}

fun main() {
    measureTimeMillis {
        repeat(2) {
            makeCoffee()
        }
    }.let { logger.debug { ">> elapsed: $it ms" } }
}

private fun makeCoffee() {
    grindCoffee()
    brewCoffee()
    boilMilk()
    formMilk()
    mixCoffeeAndMilk()
}

private fun grindCoffee() {
    logger.debug { "start grind coffee" }
    Thread.sleep(1_000)
    logger.debug { "end grind coffee" }
}

private fun brewCoffee() {
    logger.debug { "start brew coffee" }
    Thread.sleep(1_000)
    logger.debug { "end brew coffee" }
}

private fun boilMilk() {
    logger.debug { "start boil mik" }
    Thread.sleep(1_000)
    logger.debug { "end boil mik" }
}

private fun formMilk() {
    logger.debug { "start form milk" }
    Thread.sleep(1_000)
    logger.debug { "end form milk" }
}

private fun mixCoffeeAndMilk() {
    logger.debug { "start mix coffee and milk" }
    Thread.sleep(1_000)
    logger.debug { "end mix coffee and milk" }
}
