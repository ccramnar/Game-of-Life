import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.input.MouseEvent
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.shape.StrokeType


class GridView(gmodel: Model) : IView, GridPane() {
    private var model: Model? = gmodel;

    init {
        this.padding = Insets(10.0, 10.0, 10.0, 10.0);
        this.vgap = 0.1;
        this.hgap = 0.1;
        this.isGridLinesVisible = true;
        this.setAlignment(Pos.CENTER);

        for (i in 0 until 50) {
            for (j in 0 until 75) {
                val cellRect = Rectangle(9.1,9.1)
                cellRect.strokeType = StrokeType.INSIDE
                cellRect.strokeWidth = 0.5
                cellRect.isSmooth = true
                cellRect.toFront()
                cellRect.x = i.toDouble()
                cellRect.y = j.toDouble()
                if (model?.board?.get(i)?.get(j) == true) {
                    cellRect.fill = Color.BLACK
                } else {
                    cellRect.fill = Color.WHITE
                }

                // Add the Rectangle to the grid at the col/row.
                setConstraints(cellRect, j, i)
                this.add(cellRect, j, i)

                cellRect.setOnMouseClicked{ e -> addPatternMouseEvent(e) }
            }
        }
    }

    private fun addPatternMouseEvent(e: MouseEvent) {
        val eventSource = e.source as Rectangle
        println(e)
        println(e.source)
        val eventSourceCol = getColumnIndex(eventSource)
        val eventSourceRow = getRowIndex(eventSource)
        println(model)
        model?.addPattern(eventSourceRow, eventSourceCol)
    }

    override fun update() {
        println("Refreshing the board")
        var skip = true;
        for ( child:Node in this.getChildren()) {
            if (skip) {
                skip = false;
                continue;
            }
            val dragCol = getColumnIndex(child)
            val dragRow = getRowIndex(child)
            val cellRectTemp = child as Rectangle
            if (model?.board?.get(dragRow)?.get(dragCol) == true && cellRectTemp.fill != Color.BLACK) {
                cellRectTemp.fill = Color.BLACK
            }
            if (model?.board?.get(dragRow)?.get(dragCol) == false && cellRectTemp.fill != Color.WHITE) {
                cellRectTemp.fill = Color.WHITE
            }
        }
    }
}