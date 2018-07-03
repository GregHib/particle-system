package gregs.world.sys.node.attachments

import gregs.world.Point
import gregs.world.sys.node.Node

interface NodeMovement {
    var velocity: Point
    var acceleration: Point
    val maxSpeed: Double

    fun tick() {
        velocity.add(acceleration)

        velocity.limit(maxSpeed)

        if(this is Node)
            setLocationOffset(velocity.x, velocity.y)

        if(this is NodeRotation)
            angle = velocity.angle()

        acceleration.multiply(0.0)
    }

    fun applyForce(force: Point) {
        acceleration.add(force)
    }
}