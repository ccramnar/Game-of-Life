import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.scene.layout.VBox
import javafx.stage.Stage

class Main : Application() {
    override fun start(stage: Stage?) {
        val model = Model()

        // our layout is the root of the scene graph
        val root = VBox()

        // views are the children of the vbox
        val toolbar = ToolbarView(model)
        val grid = GridView(model)
        val status = StatusView(model)

        // register views with the model
        model.addView(toolbar)
        model.addView(status)
        model.addView(grid)


        // setup and display
        root.children.addAll(toolbar, grid, status)
        stage?.scene = Scene(root)
        stage?.scene?.onKeyPressed = EventHandler { keyEvent ->
           grid.handleKeyEvents(keyEvent)
        }
        stage?.isResizable = false
        stage?.width = 800.0
        stage?.height = 650.0
        stage?.title = "Conway's Game of Life (ccramnar)"
        stage?.show()

    }
}