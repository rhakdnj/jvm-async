package sample.coffee

import io.github.oshai.kotlinlogging.KotlinLogging
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import kotlin.system.measureTimeMillis

private val logger = KotlinLogging.logger {}

fun main() {
    measureTimeMillis {
        Flux
            .range(1, 10)
            .flatMap {
                makeCoffee()
            }.blockLast()
    }.let { logger.debug { ">> elapsed: $it ms" } }
}

private fun makeCoffee() =
    Mono
        .zip(
            grindCoffee().then(brewCoffee()),
            boilMilk().then(formMilk()),
        ).then(mixCoffeeAndMilk())

private fun grindCoffee() =
    Mono
        .fromCallable { logger.debug { "start grind coffee" } }
        .delayElement(Duration.ofSeconds(1))
        .doOnNext { logger.debug { "end grind coffee" } }

private fun brewCoffee() =
    Mono
        .fromCallable { logger.debug { "start brew coffee" } }
        .delayElement(Duration.ofSeconds(1))
        .doOnNext { logger.debug { "end brew coffee" } }

private fun boilMilk() =
    Mono
        .fromCallable { logger.debug { "start boil mik" } }
        .delayElement(Duration.ofSeconds(1))
        .doOnNext { logger.debug { "end boil mik" } }

private fun formMilk() =
    Mono
        .fromCallable { logger.debug { "start form milk" } }
        .delayElement(Duration.ofSeconds(1))
        .doOnNext { logger.debug { "end form milk" } }

private fun mixCoffeeAndMilk() =
    Mono
        .fromCallable { logger.debug { "start mix coffee and milk" } }
        .delayElement(Duration.ofSeconds(1))
        .doOnNext { logger.debug { "end mix coffee and milk" } }
