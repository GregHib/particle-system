package gregs.world.sys.node.nodes.particle.particles

import gregs.world.Point
import gregs.world.sys.node.attachments.NodeMovement
import gregs.world.sys.node.nodes.particle.Particle

open class MovementParticle(x: Double, y: Double, override var velocity: Point, override var acceleration: Point, width: Double = 1.0, height: Double = 1.0) : Particle(x, y, width, height), NodeMovement {
    override val maxSpeed = 8.0
}