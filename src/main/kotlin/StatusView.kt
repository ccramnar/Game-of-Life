import javafx.geometry.Insets
import javafx.scene.control.Label
import javafx.scene.layout.HBox

class StatusView(gmodel: Model) : IView, HBox() {
    val model: Model = gmodel;
    val actionLabel = Label();
    val counterLabel = Label();
    init {
        actionLabel.text = "No action has been completed"
        counterLabel.text = "Frame: 0";
        setSpacing(100.0);
        setMargin(actionLabel, Insets(5.0, 20.0, 5.0, 20.0))
        setMargin(counterLabel, Insets(5.0, 5.0, 5.0, 20.0))
        getChildren().addAll(actionLabel, counterLabel);
    }

    override fun update() {
        counterLabel.text = "Frame: " + model.counter.toString()
        if (model.newAction == layout.NO_ACTION) {
            actionLabel.text = "Game has begun, No action has been performed"
        } else if (model.newAction == layout.CLEAR) {
            actionLabel.text = "Clear Action was performed"
        } else {
            actionLabel.text = (model.newAction).toString() + " pattern was added to the grid"
        }

    }
}