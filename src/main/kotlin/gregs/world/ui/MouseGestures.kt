package gregs.world.ui

import gregs.world.sys.node.Node
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent

class MouseGestures {
    internal val dragContext = DragContext()

    fun makeDraggable(sprite: Node) {

        sprite.onMousePressed = onMousePressedEventHandler
        sprite.onMouseDragged = onMouseDraggedEventHandler
        sprite.onMouseReleased = onMouseReleasedEventHandler

    }

    internal var onMousePressedEventHandler: EventHandler<MouseEvent> = EventHandler { event ->
        dragContext.x = event.sceneX
        dragContext.y = event.sceneY
    }

    internal var onMouseDraggedEventHandler: EventHandler<MouseEvent> = EventHandler { event ->
        val sprite = event.source as Node

        val offsetX = event.sceneX - dragContext.x
        val offsetY = event.sceneY - dragContext.y

        sprite.setLocationOffset(offsetX, offsetY)

        dragContext.x = event.sceneX
        dragContext.y = event.sceneY
    }

    internal var onMouseReleasedEventHandler: EventHandler<MouseEvent> = EventHandler { }

    internal inner class DragContext {

        var x: Double = 0.toDouble()
        var y: Double = 0.toDouble()

    }
}