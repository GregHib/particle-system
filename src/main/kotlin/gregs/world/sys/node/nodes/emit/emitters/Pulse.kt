package gregs.world.sys.node.nodes.emit.emitters

import gregs.world.sys.node.Node
import gregs.world.sys.node.nodes.emit.Emitter
import gregs.world.sys.node.nodes.particle.ParticleFactory
import gregs.world.sys.node.nodes.particle.ParticleType

open class Pulse(x: Double, y: Double, private val delay: Int) : Emitter(x, y) {
    private var tick = 0

    override fun emit(): ArrayList<Node> {
        val list = arrayListOf<Node>()
        for(i in 0..100)
            list.add(ParticleFactory.makeParticle(ParticleType.MOVEMENT, translateX + x, translateY + y, getStartVelocity()))
        return list
    }

    override fun emitting(): Boolean {
        return if(++tick == delay) {
            tick = 0
            true
        } else
            false
    }
}