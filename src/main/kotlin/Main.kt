import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.VBox
import javafx.stage.Stage

class Main : Application() {
    override fun start(stage: Stage?) {
        val model = Model()

        // our layout is the root of the scene graph
        val root = VBox()

        // views are the children of the vbox
        val toolbar = ToolbarView()
        // missing the grid here
        val status = StatusView()

        // register views with the model
        model.addView(toolbar)
        model.addView(status)

        // setup and display
        root.children.addAll(toolbar, status)
        stage?.scene = Scene(root)
        stage?.isResizable = false
        stage?.width = 800.0
        stage?.height = 600.0
        stage?.title = "Conway's Game of Life"
        stage?.show()
    }
}