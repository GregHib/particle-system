package gregs.world.sys.node.attachments

import gregs.world.sys.node.Node

interface NodeRotation {

    var angle: Double

    fun display() {
        if(this is Node)
            rotate = Math.toDegrees(angle)
    }
}