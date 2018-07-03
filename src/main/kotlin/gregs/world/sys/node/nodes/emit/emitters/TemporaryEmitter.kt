package gregs.world.sys.node.nodes.emit.emitters

import gregs.world.Point
import gregs.world.sys.node.attachments.NodeLife

open class TemporaryEmitter(x: Double, y: Double, velocity: Point, acceleration: Point = Point(0.0, 0.0)) : RotateEmitter(x, y, velocity, acceleration), NodeLife {
    override var lifeSpan = 40
    override val lifeSpanMax = 255
}