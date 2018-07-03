package gregs.world.sys.node.nodes.particle

import gregs.world.sys.node.Node
import javafx.scene.paint.Color

abstract class Particle(x: Double, y: Double, width: Double = 1.0, height: Double = 1.0) : Node(x, y, width, height) {
    init {
        fill = Color.RED
    }
}