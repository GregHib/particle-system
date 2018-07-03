package gregs.world.sys.node.attachments

import gregs.world.Point
import gregs.world.sys.node.Node

interface NodeForce {
    val factor: Double
    val force: Double
    val min: Double
    val max: Double

    fun getForce(node: Node): Point
}