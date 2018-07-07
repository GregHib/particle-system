package gregs.world.sys.node.attachments

import gregs.world.sys.ParticleSystem
import gregs.world.sys.node.Node
import javafx.animation.FillTransition
import javafx.scene.paint.Color
import javafx.util.Duration


interface NodeColour {
    val startColour: Color
    var endColour: Color

    fun initColour() {
        if(this is NodeLife && this is Node) {
            FillTransition(Duration.millis(lifeSpanMax / ParticleSystem.frameRate.getAverageFPS() * 1000.0), this, startColour, endColour).play()
        }
    }
}