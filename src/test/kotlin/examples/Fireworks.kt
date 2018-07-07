package examples

import gregs.world.Point
import gregs.world.sys.ParticleSystem
import gregs.world.sys.node.nodes.emit.emitters.FireworkDisplay
import javafx.application.Application
import javafx.scene.paint.Color
import tornadofx.App
import tornadofx.View
import tornadofx.pane
import tornadofx.rectangle

fun main(args: Array<String>) {
    Application.launch(Fireworks.Launcher::class.java, *args)
}

class Fireworks : View() {
    class Launcher : App(Fireworks::class)

    private val horizontal = true

    override val root = pane {
        rectangle(0.0, 0.0, 600.0, 600.0) {
            fill = Color.BLACK
            widthProperty().bind(this@pane.widthProperty())
            heightProperty().bind(this@pane.heightProperty())
        }

        if (horizontal)
            setPrefSize(600.0, 400.0)
        else
            setPrefSize(400.0, 600.0)
    }

    private val system = ParticleSystem(root)

    init {
        system.addNode(
                if (horizontal)
                    FireworkDisplay(50.0, root.prefHeight/2, Point(3.0, 5.0), Point(-1.0, 0.0))
                else
                    FireworkDisplay(root.prefWidth / 2, root.prefHeight - 50)
        )
    }
}