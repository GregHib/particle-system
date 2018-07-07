package gregs.world.sys.node.nodes.emit.emitters

import gregs.world.Point
import gregs.world.sys.RandUtils
import gregs.world.sys.node.Node

class FireworkDisplay(x: Double, y: Double, private val xVelocity: Point = Point(-1.0, 0.0), private val yVelocity: Point = Point(3.0, 5.0), private val lifeSpan: Point = Point(60.0, 80.0), delay: Int = 40) : Pulse(x, y, delay) {
    override fun emit(): ArrayList<Node> {
        return arrayListOf(Rocket(x, y, RandUtils.inclusive(xVelocity), RandUtils.inclusive(yVelocity), RandUtils.inclusive(lifeSpan).toInt()))
    }
}
