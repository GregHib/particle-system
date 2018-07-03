package gregs.world.sys.node

import javafx.scene.shape.Rectangle

open class Node(x: Double, y: Double, width: Double, height: Double) : Rectangle(x, y, width, height) {

    fun setLocation(x: Double, y: Double) {
        this.x = x
        this.y = y
    }

    fun setLocationOffset(x: Double, y: Double) {
        this.x += x
        this.y += y
    }
}