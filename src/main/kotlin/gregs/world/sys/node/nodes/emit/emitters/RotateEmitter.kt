package gregs.world.sys.node.nodes.emit.emitters

import gregs.world.Point
import gregs.world.sys.node.attachments.NodeRotation

open class RotateEmitter(x: Double, y: Double, velocity: Point, acceleration: Point = Point(0.0, 0.0)) : MovementEmitter(x, y, velocity, acceleration), NodeRotation {
    override var angle = 0.0
}