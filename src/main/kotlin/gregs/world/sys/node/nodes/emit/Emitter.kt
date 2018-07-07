package gregs.world.sys.node.nodes.emit

import gregs.world.Point
import gregs.world.sys.node.Node
import gregs.world.sys.node.nodes.particle.ParticleFactory
import gregs.world.sys.node.nodes.particle.ParticleType
import javafx.scene.paint.Color
import java.util.*

open class Emitter(x: Double, y: Double) : Node(x, y, 2.0, 2.0) {

    init {
        fill = Color.GREEN
    }

    open fun emit(): ArrayList<Node> {
        return arrayListOf(ParticleFactory.makeParticle(ParticleType.MOVEMENT, translateX + x, translateY + y, getStartVelocity()))
    }

    open fun emitting(): Boolean {
        return true
    }

    companion object {
        val random = Random()
    }

    open fun getStartVelocity(): Point {
        val vx = random.nextGaussian() * 0.3
        val vy = random.nextGaussian() * 0.3 - 1.0
        return Point(vx, vy)
    }
}