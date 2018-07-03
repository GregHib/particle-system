package gregs.world.sys.node.nodes.force.forces

import gregs.world.sys.node.nodes.force.Force
import javafx.scene.paint.Color

class Attract(x: Double, y: Double, width: Double = 4.0, height: Double = 4.0) : Force(x, y, width, height) {
    override var factor = 1.0
    override var force = 500.0

    init {
        fill = Color.ORANGE
    }
}