package gregs.world.ui

import gregs.world.sys.ParticleSystem
import gregs.world.sys.node.nodes.emit.emitters.FireworkDisplay
import javafx.animation.AnimationTimer
import javafx.scene.control.Label
import tornadofx.View
import tornadofx.label
import tornadofx.pane


class MainView : View() {
    private lateinit var label: Label

    private val frameRate = FrameRate()

    override val root = pane {
        setPrefSize(600.0, 600.0)

        label = label()
    }

    private val system = ParticleSystem(root)

    init {

        /*
        TODO emitter of emitters? (Needs a different name)
        For fireworks.
        One emitter creates an emitter (rocket) which has a trail, moves up, then disappears

        Either

        Upon disappearing the emitter spawns a new emitter (temp) which handles explosions

        Or

        The emitter changes it's type (from rocket trail to explosion), so one emitter handles a type class which changed after a set time?

        */
        /*val path = Path()
        path.elements.add(MoveTo(20.0, 20.0))
        path.elements.add(CubicCurveTo(30.0, 10.0, 380.0, 120.0, 200.0, 120.0))
        path.elements.add(CubicCurveTo(200.0, 1120.0, 110.0, 240.0, 380.0, 240.0))
        path.opacity = 0.5

        root.add(path)
        root.add(attractor)
        val pathTransition = PathTransition()

        pathTransition.duration = Duration.seconds(8.0)
        pathTransition.delay = Duration.seconds(.5)
        pathTransition.path = path
        pathTransition.node = attractor
        pathTransition.orientation = PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT
        pathTransition.cycleCount = Timeline.INDEFINITE
        pathTransition.isAutoReverse = true*/
//        pathTransition.play()



//        system.addInteractiveNode(EmitterFactory.makeEmitter(EmitterType.PULSE, 200.0, 150.0))
//        system.addInteractiveNode(EmitterFactory.makeEmitter(EmitterType.EMITTER, 400.0, 150.0))
        system.addNode(FireworkDisplay(300.0, 500.0))
//        system.addInteractiveNode(EmitterFactory.makeEmitter(EmitterType.ROCKET, 400.0, 600.0))

        val timer = object : AnimationTimer() {
            override fun handle(now: Long) {
                system.tick()

                frameRate.update(now)

                label.text = "Particles: ${system.particles.size} Fps: ${Math.round(frameRate.getAverageFPS())}"
            }
        }
        timer.start()
    }





}