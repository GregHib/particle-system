package gregs.world.sys

import gregs.world.Point
import gregs.world.sys.node.Node
import gregs.world.sys.node.attachments.NodeMovement
import gregs.world.sys.node.nodes.emit.Emitter
import gregs.world.sys.node.nodes.force.forces.Attract
import gregs.world.sys.node.nodes.force.forces.Repel
import gregs.world.sys.node.nodes.particle.Particle
import gregs.world.ui.FrameRate
import gregs.world.ui.MouseGestures
import javafx.animation.AnimationTimer
import javafx.scene.layout.Pane

class ParticleSystem(private val root: Pane) {

    companion object {
        val frameRate = FrameRate()
    }

    private val gravity = Point(0.0, 0.0)

    var particles = SystemList<Particle>(root)
    var attractors = SystemList<Attract>(root)
    var repellers = SystemList<Repel>(root)
    var emitters = SystemList<Emitter>(root)

    private var mouseGestures = MouseGestures()

    init {
        val timer = object : AnimationTimer() {
            override fun handle(now: Long) {
                tick()

                frameRate.update(now)
            }
        }
        timer.start()
    }

    fun addInteractiveNode(node: Node) {
        addNode(node)
        mouseGestures.makeDraggable(node)
    }

    fun addNode(node: Node) {
        listNode(node)
        root.children.add(node)
    }

    fun addNodes(nodes: List<Node>) {
        nodes.forEach { node -> listNode(node) }
        root.children.addAll(nodes)
    }

    private fun listNode(node: Node) {
        when(node) {
            is Particle -> particles.add(node)
            is Emitter -> emitters.add(node)
            is Attract -> attractors.add(node)
            is Repel -> repellers.add(node)
        }
    }

    fun tick() {
        //Emitting new particles
        emitters.filter { it.emitting() }.forEach { addNodes(it.emit()) }

        //Forces
        particles.forEach { particle ->

            //If particle can be moved
            if (particle is NodeMovement) {

                //Apply gravity
                particle.applyForce(gravity)

                //Apply attraction
                attractors.forEach { attractor ->
                    particle.applyForce(attractor.getForce(particle))
                }

                //Apply repelling
                repellers.forEach { repeller ->
                    particle.applyForce(repeller.getForce(particle))
                }
            }
        }

        particles.tick()
        emitters.tick()
        attractors.tick()
        repellers.tick()
    }
}