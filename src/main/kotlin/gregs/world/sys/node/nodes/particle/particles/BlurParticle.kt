package gregs.world.sys.node.nodes.particle.particles

import gregs.world.Point
import javafx.scene.effect.GaussianBlur
import javafx.scene.paint.Color

class BlurParticle(x: Double, y: Double, velocity: Point, acceleration: Point, lifeSpan: Int, startColour: Color, endColour: Color, blur: Double = 10.0) : ColourParticle(x, y, velocity, acceleration, lifeSpan, startColour, endColour) {

    init {
        effect = GaussianBlur(blur)
    }

}