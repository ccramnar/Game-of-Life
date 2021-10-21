import javafx.scene.control.Button
import javafx.scene.control.ToolBar
import javafx.scene.image.Image
import javax.swing.text.html.ImageView

class ToolbarView : IView, ToolBar() {
    init {
        // add buttons to toolbar

        val blockButton = Button("Block")
        val blockImageView = javafx.scene.image.ImageView((Image("block.gif")))
        blockButton.graphic = (blockImageView)
        blockImageView.fitWidthProperty().bind(blockButton.widthProperty().divide(5))
        blockImageView.isPreserveRatio = true
        blockButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(blockButton)

        val beehiveButton = Button("Beehive")
        val beehiveImageView = javafx.scene.image.ImageView((Image("beehive.gif")))
        beehiveButton.graphic = (beehiveImageView)
        beehiveImageView.fitWidthProperty().bind(beehiveButton.widthProperty().divide(5))
        beehiveImageView.isPreserveRatio = true
        beehiveButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(beehiveButton)

        val blinkerButton = Button("Blinker")
        val blinkerImageView = javafx.scene.image.ImageView((Image("blinker.gif")))
        blinkerButton.graphic = (blinkerImageView)
        blinkerImageView.fitWidthProperty().bind(blinkerButton.widthProperty().divide(5))
        blinkerImageView.isPreserveRatio = true
        blinkerButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(blinkerButton)

        val toadButton = Button("Toad")
        val toadImageView = javafx.scene.image.ImageView((Image("toad.gif")))
        toadButton.graphic = (toadImageView)
        toadImageView.fitWidthProperty().bind(toadButton.widthProperty().divide(5))
        toadImageView.isPreserveRatio = true
        toadButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(toadButton)

        val gliderButton = Button("Glider")
        val gliderImageView = javafx.scene.image.ImageView((Image("glider.jpg")))
        gliderButton.graphic = (gliderImageView)
        gliderImageView.fitWidthProperty().bind(gliderButton.widthProperty().divide(5))
        gliderImageView.isPreserveRatio = true
        gliderButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(gliderButton)

        val clearButton = Button("Clear")
        val clearImageView = javafx.scene.image.ImageView((Image("clear.PNG")))
        clearButton.graphic = (clearImageView)
        clearImageView.fitWidthProperty().bind(clearButton.widthProperty().divide(5))
        clearImageView.isPreserveRatio = true
        clearButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(clearButton)


    }

    override fun update() {
        // update my button state
    }
}