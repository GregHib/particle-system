package gregs.world.sys

import java.util.concurrent.ThreadLocalRandom

object RandUtils {

    fun inclusive(start: Double, end: Double)  = ThreadLocalRandom.current().nextDouble((end + 1.0) - start) + start
}
