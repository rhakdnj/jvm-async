package sample.cost

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicLong
import kotlin.system.measureTimeMillis

private val logger = KotlinLogging.logger {}

fun main() {
    val count = AtomicLong()

    measureTimeMillis {
        runBlocking {
            repeat(10_000) {
                launch {
                    repeat(100_000) {
                        count.addAndGet(1)
                    }
                }
            }
        }
    }.let { logger.debug { ">> count: $count elapsed: $it ms" } }
}
