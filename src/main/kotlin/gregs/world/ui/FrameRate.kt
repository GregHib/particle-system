package gregs.world.ui

class FrameRate {

    private var lastUpdate: Long = 0
    private var index = 0
    private var frameRates = DoubleArray(100)

    fun update(now: Long) {
        if (lastUpdate > 0) {
            val elapsed = now - lastUpdate
            val frameRate = 1000000000.0 / elapsed
            index %= frameRates.size
            frameRates[index++] = frameRate
        }

        lastUpdate = now
    }

    fun getAverageFPS(): Double {
        var total = 0.0

        for (i in 0 until frameRates.size)
            total += frameRates[i]

        return total / frameRates.size
    }
}