package gregs.world.sys.node.nodes.emit.emitters

import gregs.world.sys.RandUtils
import gregs.world.sys.node.Node

class FireworkDisplay(x: Double, y: Double) : Pulse(x, y, 40) {
    override fun emit(): ArrayList<Node> {
        return arrayListOf(Rocket(x, y, RandUtils.inclusive(-1.0, 0.0), RandUtils.inclusive(1.5, 4.0)))
    }
}
