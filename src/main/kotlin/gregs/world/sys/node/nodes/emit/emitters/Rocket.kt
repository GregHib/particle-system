package gregs.world.sys.node.nodes.emit.emitters

import gregs.world.Point
import gregs.world.sys.node.Node
import gregs.world.sys.node.nodes.particle.particles.ColourParticle
import javafx.scene.paint.Color

class Rocket(x: Double, y: Double, xVelocity: Double, speed: Double) : TemporaryEmitter(x, y, Point(xVelocity, -speed)) {
    override var lifeSpan = 120

    override fun emit(): ArrayList<Node> {
        val list = arrayListOf<Node>()
        if(lifeSpan > 2) {
            list.add(ColourParticle(x, y, getStartVelocity(), acceleration, 40, Color.ORANGE, Color.RED))//Trail of 1 particle a frame
        } else if(lifeSpan == 1) {
            for(i in 0..1000)
                list.add(ColourParticle(x, y, getStartVelocity(), acceleration, 70, Color.BLUE, Color.PURPLE))//Explosion
        }
        return list
    }

    override fun getStartVelocity(): Point {
        val vx = random.nextGaussian()
        val vy = random.nextGaussian()
        return if(lifeSpan == 1)
            Point(vx, vy)//Explosion
        else
            Point((-velocity.x + vx) * 0.3, (-velocity.y + vy) * 0.3 + 1.0)//Trail 30% velocity
    }
}