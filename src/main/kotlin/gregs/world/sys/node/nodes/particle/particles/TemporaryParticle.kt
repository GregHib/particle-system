package gregs.world.sys.node.nodes.particle.particles

import gregs.world.Point
import gregs.world.sys.node.attachments.NodeLife

open class TemporaryParticle(x: Double, y: Double, velocity: Point, acceleration: Point, override var lifeSpan: Int = 80, width: Double = 1.0, height: Double = 1.0) : RotateParticle(x, y, velocity, acceleration, width, height), NodeLife {
    override val lifeSpanMax = lifeSpan
}