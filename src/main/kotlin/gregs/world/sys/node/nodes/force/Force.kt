package gregs.world.sys.node.nodes.force

import gregs.world.Point
import gregs.world.sys.node.Node
import gregs.world.sys.node.attachments.NodeForce
import org.controlsfx.tools.Utils

abstract class Force(x: Double, y: Double, width: Double, height: Double) : Node(x, y, width, height), NodeForce {

    override val min = 5.0
    override val max = 1000.0

    override fun getForce(node: Node): Point {
        val dir = Point.subtract(x, y, node.x, node.y)

        var distance = dir.magnitude()

        dir.normalise()
        distance = Utils.clamp(min, distance, max)


        val force = factor * force / (distance * distance)
        dir.multiply(force)

        return dir
    }
}