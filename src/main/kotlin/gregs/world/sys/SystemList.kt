package gregs.world.sys

import gregs.world.sys.node.Node
import gregs.world.sys.node.attachments.NodeLife
import gregs.world.sys.node.attachments.NodeMovement
import gregs.world.sys.node.attachments.NodeRotation
import javafx.scene.layout.Pane

class SystemList<T: Node>(private val root: Pane) : ArrayList<T>() {

    fun tick() {
        val iterator = iterator()
        while (iterator.hasNext()) {
            val node = iterator.next()

            //Apply velocity, acceleration & movement
            if(node is NodeMovement)
                node.tick()

            //Apply rotation
            if(node is NodeRotation)
                node.display()

            //Handle removal
            if(node is NodeLife) {

                //Decrease lifespan
                node.decreaseLifeSpan()

                //Remove if dead
                if (node.isDead()) {
                    //Remove particle from view and list
                    root.children.remove(node)
                    iterator.remove()
                    node.end()
                }
            } else if(node is NodeMovement) {
                //Remove if outside view
                val x = node.translateX + node.x
                val y = node.translateY + node.y
                if(x < 0.0 || y < 0.0 || x > root.width || y > root.height) {
                    //Remove particle from view and list
                    root.children.remove(node)
                    iterator.remove()
                }
            }
        }
    }
}