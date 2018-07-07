package gregs.world.ui

import gregs.world.Point
import gregs.world.sys.ParticleSystem
import gregs.world.sys.ParticleSystem.Companion.frameRate
import gregs.world.sys.node.nodes.emit.emitters.MovementEmitter
import javafx.animation.AnimationTimer
import javafx.animation.PathTransition
import javafx.animation.Timeline
import javafx.scene.control.Label
import javafx.scene.paint.Color
import javafx.scene.shape.CubicCurveTo
import javafx.scene.shape.MoveTo
import javafx.scene.shape.Path
import javafx.util.Duration
import tornadofx.View
import tornadofx.label
import tornadofx.pane
import tornadofx.rectangle


class MainView : View() {
    private lateinit var label: Label

    override val root = pane {
        rectangle (0.0, 0.0, 600.0, 600.0){
            fill = Color.WHEAT
        }
        setPrefSize(600.0, 600.0)

        label = label {
            textFill = Color.WHITE
        }
    }

    private val system = ParticleSystem(root)

    init {
        val pulse = MovementEmitter(20.0, 20.0, Point(0.0, 1.0))
        system.addNode(pulse)

        val path = Path()
        path.elements.add(MoveTo(20.0, 20.0))
        path.elements.add(CubicCurveTo(30.0, 10.0, 380.0, 120.0, 200.0, 120.0))
        path.elements.add(CubicCurveTo(200.0, 1120.0, 110.0, 240.0, 380.0, 240.0))
        path.opacity = 0.5

        root.add(path)
        val pathTransition = PathTransition()

        pathTransition.duration = Duration.seconds(8.0)
        pathTransition.delay = Duration.seconds(.5)
        pathTransition.path = path
        pathTransition.node = pulse
        pathTransition.orientation = PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT
        pathTransition.cycleCount = Timeline.INDEFINITE
        pathTransition.isAutoReverse = true
        pathTransition.play()



//        system.addInteractiveNode(EmitterFactory.makeEmitter(EmitterType.PULSE, 200.0, 150.0))
//        system.addInteractiveNode(EmitterFactory.makeEmitter(EmitterType.EMITTER, 400.0, 150.0))
//        system.addNode(ColourParticle(300.0, 500.0, Point(0.0, 0.0), Point(0.0, -1.0), 80, Color.BLUE, Color.RED))
//        system.addInteractiveNode(EmitterFactory.makeEmitter(EmitterType.ROCKET, 400.0, 600.0))

        val timer = object : AnimationTimer() {
            override fun handle(now: Long) {
                label.text = "Particles: ${system.particles.size} Fps: ${Math.round(frameRate.getAverageFPS())}"
            }
        }
        timer.start()
    }





}