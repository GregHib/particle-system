package gregs.world.ui

import javafx.application.Application
import tornadofx.App

class Launcher: App(MainView::class)

fun main(args: Array<String>) {
    Application.launch(Launcher::class.java, *args)
}