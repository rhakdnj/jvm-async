package sample.cost

import io.github.oshai.kotlinlogging.KotlinLogging
import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

private val logger = KotlinLogging.logger {}

fun main() {
    val latch = CountDownLatch(10_000)
    val count = AtomicLong()
    measureTimeMillis {
        repeat(10_000) {
            thread {
                repeat(100_000) {
                    count.addAndGet(1)
                }
                latch.countDown()
            }
        }
        latch.await()
    }.let { logger.debug { ">> count: $count elapsed: $it ms" } }
}
