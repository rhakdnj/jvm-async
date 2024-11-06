package sample.coffee

import io.github.oshai.kotlinlogging.KotlinLogging
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

private val logger = KotlinLogging.logger {}

fun main() {
    measureTimeMillis {
        repeat(2) {
            makeCoffee()
        }

        employees.shutdown()
        employees.awaitTermination(100, TimeUnit.SECONDS)
    }.let { logger.debug { ">> elapsed: $it ms" } }
}

private val employees = Executors.newFixedThreadPool(3)

private fun makeCoffee() {
    val taskA =
        employees.submit {
            grindCoffee()
            brewCoffee()
        }

    val taskB =
        employees.submit {
            boilMilk()
            formMilk()
        }

    employees.submit {
        taskA.get()
        taskB.get()

        mixCoffeeAndMilk()
    }
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
