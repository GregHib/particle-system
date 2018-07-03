package gregs.world.sys.node.nodes.emit.emitters

import gregs.world.Point
import gregs.world.sys.node.attachments.NodeMovement
import gregs.world.sys.node.nodes.emit.Emitter

open class MovementEmitter(x: Double, y: Double, override var velocity: Point, override var acceleration: Point = Point(0.0, 0.0)) : Emitter(x, y), NodeMovement {
    override val maxSpeed = 8.0
}