import javafx.scene.control.Button
import javafx.scene.control.ToolBar
import javafx.scene.image.Image
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyCodeCombination
import javafx.scene.input.KeyCombination
import javax.swing.text.html.ImageView

class ToolbarView(gmodel: Model) : IView, ToolBar() {
    val model:Model = gmodel;
    val stepButton = Button("Step")
    init {
        // add buttons to toolbar
        val blockButton = Button("Block")
        blockButton.setOnMouseClicked { model.changePattern(layout.BLOCK) }
        val blockImageView = javafx.scene.image.ImageView((Image("block.gif")))
        blockButton.graphic = (blockImageView)
        blockImageView.fitWidthProperty().bind(blockButton.widthProperty().divide(5))
        blockImageView.isPreserveRatio = true
        blockButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(blockButton)

        val beehiveButton = Button("Beehive")
            beehiveButton.setOnMouseClicked { model.changePattern(layout.BEEHIVE) }
        val beehiveImageView = javafx.scene.image.ImageView((Image("beehive.gif")))
        beehiveButton.graphic = (beehiveImageView)
        beehiveImageView.fitWidthProperty().bind(beehiveButton.widthProperty().divide(5))
        beehiveImageView.isPreserveRatio = true
        beehiveButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(beehiveButton)

        val blinkerButton = Button("Blinker")
        blinkerButton.setOnMouseClicked { model.changePattern(layout.BLINKER) }
        val blinkerImageView = javafx.scene.image.ImageView((Image("blinker.gif")))
        blinkerButton.graphic = (blinkerImageView)
        blinkerImageView.fitWidthProperty().bind(blinkerButton.widthProperty().divide(5))
        blinkerImageView.isPreserveRatio = true
        blinkerButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(blinkerButton)

        val toadButton = Button("Toad")
        toadButton.setOnMouseClicked { model.changePattern(layout.TOAD) }
        val toadImageView = javafx.scene.image.ImageView((Image("toad.PNG")))
        toadButton.graphic = (toadImageView)
        toadImageView.fitWidthProperty().bind(toadButton.widthProperty().divide(5))
        toadImageView.isPreserveRatio = true
        toadButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(toadButton)

        val gliderButton = Button("Glider")
        gliderButton.setOnMouseClicked { model.changePattern(layout.GLIDER) }
        val gliderImageView = javafx.scene.image.ImageView((Image("glider.jpg")))
        gliderButton.graphic = (gliderImageView)
        gliderImageView.fitWidthProperty().bind(gliderButton.widthProperty().divide(5))
        gliderImageView.isPreserveRatio = true
        gliderButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(gliderButton)

        val clearButton = Button("Clear")
        clearButton.setOnAction {
            model.clear()
            model.changePattern(layout.CLEAR)
        }
        val clearImageView = javafx.scene.image.ImageView((Image("clear.PNG")))
        clearButton.graphic = (clearImageView)
        clearImageView.fitWidthProperty().bind(clearButton.widthProperty().divide(5))
        clearImageView.isPreserveRatio = true
        clearButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(clearButton)

        /*
        val playButton = Button("Play")
        playButton.setOnAction {
            model.play()
        }
        val playImageView = javafx.scene.image.ImageView((Image("play.png")))
        playButton.graphic = (playImageView)
        playImageView.fitWidthProperty().bind(playButton.widthProperty().divide(5))
        playImageView.isPreserveRatio = true
        playButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(playButton)

        val pauseButton = Button("Pause")
        pauseButton.setOnAction {
            model.pause()
        }
        val pauseImageView = javafx.scene.image.ImageView((Image("pause.png")))
        pauseButton.graphic = (pauseImageView)
        pauseImageView.fitWidthProperty().bind(pauseButton.widthProperty().divide(5))
        pauseImageView.isPreserveRatio = true
        pauseButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(pauseButton)

        //step button
        stepButton.setOnAction {
            model.step()
        }
        val stepImageView = javafx.scene.image.ImageView((Image("step.png")))
        pauseButton.graphic = (stepImageView)
        stepImageView.fitWidthProperty().bind(pauseButton.widthProperty().divide(5))
        stepImageView.isPreserveRatio = true
        stepButton.setMaxWidth(Double.MAX_VALUE)
        this.items.add(stepButton)*/

    }

    override fun update() {
        if (model.isGamePlaying) {
            stepButton.setDisable(true);
        } else {
            stepButton.setDisable(false);
        }
    }
}