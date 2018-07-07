package tests

import gregs.world.sys.ParticleSystem
import javafx.application.Application
import javafx.scene.effect.GaussianBlur
import javafx.scene.paint.Color
import tornadofx.*

class TestSuite : View() {

    class Launcher : App(TestSuite::class)

    override val root = pane {
        rectangle(0.0, 0.0) {
            fill = Color.BLACK
            widthProperty().bind(this@pane.widthProperty())
            heightProperty().bind(this@pane.heightProperty())
        }

        circle(175.0, 175.0, 10.0) {
            fill = Color.WHITE
            /*val shadow = DropShadow()
            shadow.color = Color.WHITE
            shadow.radius = radius * 5
            effect = shadow*/

            effect = GaussianBlur(5.0)
        }
        setPrefSize(400.0, 400.0)
    }

    private val system = ParticleSystem(root)

    init {
//        system.addNode(FireworkDisplay(root.prefWidth/2, root.prefHeight - 50))

    }
}

fun main(args: Array<String>) {
    Application.launch(TestSuite.Launcher::class.java, *args)
}
