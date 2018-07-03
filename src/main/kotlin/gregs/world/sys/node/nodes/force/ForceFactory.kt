package gregs.world.sys.node.nodes.force

import gregs.world.sys.node.nodes.force.forces.Attract
import gregs.world.sys.node.nodes.force.forces.Repel

object ForceFactory {
    fun createForce(type: ForceType, x: Double, y: Double): Force {
        return when(type) {
            ForceType.ATTRACT -> Attract(x, y)
            ForceType.REPEL -> Repel(x, y)
        }
    }
}