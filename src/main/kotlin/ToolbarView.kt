import javafx.scene.control.Button
import javafx.scene.control.ToolBar

class ToolbarView : IView, ToolBar() {
    init {
        // add buttons to toolbar
        this.items.add(Button("Block"))
    }

    override fun update() {
        // update my button state
    }
}