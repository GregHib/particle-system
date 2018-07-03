package gregs.world

class Point(var x: Double, var y: Double) {
    fun magnitude(): Double {
        return Math.sqrt(x * x + y * y)
    }

    fun set(x: Double, y: Double) {
        this.x = x
        this.y = y
    }

    fun add(point: Point) {
        add(point.x, point.y)
    }

    fun add(x: Double, y: Double) {
        this.x += x
        this.y += y
    }

    fun multiply(multiplier: Double) {
        this.x *= multiplier
        this.y *= multiplier
    }

    fun divide(divider: Double) {
        this.x /= divider
        this.y /= divider
    }

    fun normalise() {
        val m = magnitude()
        if(m != 0.0 && m != 1.0)
            divide(m)
    }

    fun limit(max: Double) {
        if(magnitude() > max) {
            normalise()
            multiply(max)
        }
    }

    fun angle(): Double {
        return -1 * Math.atan2(-y, x)
    }

    override fun toString(): String {
        return "Point $x, $y"
    }

    companion object {
        fun subtract(x1: Double, y1: Double, x2: Double, y2: Double): Point {
            return Point(x1 - x2, y1 - y2)
        }
    }
}