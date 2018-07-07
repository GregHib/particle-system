package gregs.world.sys.node.nodes.particle.particles

import gregs.world.Point
import gregs.world.sys.node.attachments.NodeColour
import javafx.scene.paint.Color

open class ColourParticle(x: Double, y: Double, velocity: Point, acceleration: Point, lifeSpan: Int, override val startColour: Color, override var endColour: Color) : TemporaryParticle(x, y, velocity, acceleration, lifeSpan), NodeColour {

    init {
        fill = startColour
        initColour()
    }

}