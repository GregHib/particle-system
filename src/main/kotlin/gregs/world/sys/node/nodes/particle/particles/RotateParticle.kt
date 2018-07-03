package gregs.world.sys.node.nodes.particle.particles

import gregs.world.Point
import gregs.world.sys.node.attachments.NodeMovement
import gregs.world.sys.node.attachments.NodeRotation

open class RotateParticle(x: Double, y: Double, velocity: Point, acceleration: Point, width: Double = 1.0, height: Double = 1.0) : MovementParticle(x, y, velocity, acceleration, width, height), NodeMovement, NodeRotation {
    override var angle = 0.0
}