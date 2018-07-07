package gregs.world.sys

import gregs.world.Point
import java.util.concurrent.ThreadLocalRandom

object RandUtils {
    //TODO not what Point's are designed for.
    fun inclusive(point: Point)  = ThreadLocalRandom.current().nextDouble((point.y + 1.0) - point.x) + point.x

    fun inclusive(start: Double, end: Double)  = ThreadLocalRandom.current().nextDouble((end + 1.0) - start) + start

    fun inclusive(start: Int, end: Int)  = ThreadLocalRandom.current().nextInt((end + 1) - start) + start
}
