package gregs.world.sys.node.nodes.particle

import gregs.world.Point
import gregs.world.sys.node.nodes.particle.particles.MovementParticle
import gregs.world.sys.node.nodes.particle.particles.RotateParticle
import gregs.world.sys.node.nodes.particle.particles.TemporaryParticle

object ParticleFactory {

    fun makeParticle(type: ParticleType, x: Double, y: Double, velocity: Point, acceleration: Point = Point(0.0, 0.0)): Particle {
        return when(type) {
            ParticleType.MOVEMENT -> MovementParticle(x, y, velocity, acceleration)
            ParticleType.ROTATE -> RotateParticle(x, y, velocity, acceleration)
            ParticleType.TEMPORARY -> TemporaryParticle(x, y, velocity, acceleration)
        }
    }
}