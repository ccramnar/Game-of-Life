import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.event.ActionEvent
import javafx.util.Duration;


enum class layout {
    BLOCK, BEEHIVE, BLINKER, TOAD, GLIDER, CLEAR
}

class Model {
    // represent my board
    public var counter = 0
    public val sizeOuter = 50 //row
    public val sizeInner = 75 //column
    public val numberOfCells = 3750;
    public var pattern:layout = layout.BLOCK ;
    public var isGamePlaying = false;
    public val views = ArrayList<IView>()
    public val board = Array(sizeOuter) { BooleanArray(sizeInner) }
    public var timeLine: Timeline? = null;
    public val speed:Double = 1000.0;

    // view management
    fun addView(view: IView) {
        views.add(view)
    }

    fun removeView(view: IView) {
        views.remove(view)
    }

    fun notifyView() {
        for (view in views) {
            view.update()
        }
    }

    /*ANIMATION */
    open fun initializeTimeline() {

        val keyFrame = KeyFrame(Duration.millis(speed), { e: ActionEvent? ->
            updateBoard()
            ++counter
        })
        //Attach the keyframe to the Timeline.
        timeLine = Timeline(keyFrame)
        timeLine!!.cycleCount = Timeline.INDEFINITE
    }


    /*MODEL THINGS */

    fun changePattern(newPattern: layout) {
        pattern = newPattern;
    }

    fun clear() {
        for (row in  0 until sizeOuter) {
            for (column in 0 until sizeInner) {
                board[row][column] = false;
            }
        }
        changePattern(layout.CLEAR)
        counter = 0;
        notifyView()
    }

    init {
        for (row in  0 until sizeOuter) {
            for (column in 0 until sizeInner) {
                board[row][column] = false;
            }
        }
        println("here")
        initializeTimeline()
        play()
    }

    fun inBounds(row: Int, column: Int):Boolean {
        return ((0 <= row) && (row < sizeOuter) && (0 <= column) && (column < sizeInner));
    }

    fun addPattern( row: Int, column: Int) {
        println("here")
        println(pattern)
        when(pattern) {
            layout.BLOCK -> {
                board[row][column] = true;
                println("BLOCK LAYOUT")
                if (inBounds(row + 1, column + 1)) {
                    board[row + 1][column + 1] = true;
                }
                if (inBounds(row, column + 1)) {
                    board[row][column + 1] = true;
                }
                if (inBounds(row + 1, column)) {
                    board[row + 1][column] = true;
                }
            }
            layout.BEEHIVE ->  {
                //first row
                board[row][column] = false;
                if (inBounds(row, column + 1)) {
                    board[row][column + 1] = true;
                }
                if (inBounds(row, column + 2)) {
                    board[row][column + 2] = true;
                }
                if (inBounds(row, column + 3)) {
                    board[row][column + 3] = false;
                }
                //second row
                if (inBounds(row + 1, column)) {
                    board[row + 1][column] = true;
                }
                if (inBounds(row + 1, column + 1)) {
                    board[row + 1][column + 1] = false;
                }
                if (inBounds(row + 1, column + 2)) {
                    board[row + 1][column + 2] = false;
                }
                if (inBounds(row + 1, column + 3)) {
                    board[row + 1][column + 3] = true;
                }
                //third row
                if (inBounds(row + 2, column)) {
                    board[row + 2][column] = false;
                }
                if (inBounds(row + 2, column + 1)) {
                    board[row + 2][column + 1] = true;
                }
                if (inBounds(row + 2, column + 2)) {
                    board[row + 2][column + 2] = true;
                }
                if (inBounds(row + 2, column + 3)){
                    board[row + 2][column + 3] = false;
                }
            }
            layout.BLINKER -> {
                //first row
                board[row][column] = false;
                if (inBounds(row, column + 1)) {
                    board[row][column + 1] = false;
                }
                if (inBounds(row, column + 2)) {
                    board[row][column + 2] = false;
                }
                //second row
                if (inBounds(row + 1, column)) {
                    board[row + 1][column] = true;
                }
                if (inBounds(row + 1, column + 1)) {
                    board[row + 1][column + 1] = true;
                }
                if (inBounds(row + 1, column + 2)) {
                    board[row + 1][column + 2] = true;
                }
                //third row
                if (inBounds(row + 2, column)) {
                    board[row + 2][column] = false;
                }
                if (inBounds(row + 2, column + 1)) {
                    board[row + 2][column + 1] = false;
                }
                if (inBounds(row + 2, column + 2)) {
                    board[row + 2][column + 2] = false;
                }
            }
            layout.TOAD -> {
                //first row
                board[row][column] = false;
                if (inBounds(row, column + 1)) {
                    board[row][column + 1] = true;
                }
                if (inBounds(row, column + 2)) {
                    board[row][column + 2] = true;
                }
                if (inBounds(row, column + 3)) {
                    board[row][column + 3] = true;
                }
                //second row
                if (inBounds(row + 1, column)) {
                    board[row + 1][column] = true;
                }
                if (inBounds(row + 1, column + 1)) {
                    board[row + 1][column + 1] = true;
                }
                if (inBounds(row + 1, column + 2)) {
                    board[row + 1][column + 2] = true;
                }
                if (inBounds(row + 1, column + 3)) {
                    board[row + 1][column + 3] = false;
                }
            }
            layout.GLIDER -> {
                //first row
                board[row][column] = false;
                if (inBounds(row , column + 1))  {
                    board[row][column + 1] = false;
                }
                if (inBounds(row, column + 2))  {
                    board[row][column + 2] = true;
                }
                //second row
                if (inBounds(row + 1, column )) {
                    board[row + 1][column] = true;
                }
                if (inBounds(row + 1, column + 1)) {
                    board[row + 1][column + 1] = false;
                }
                if (inBounds(row + 1, column + 2)) {
                    board[row + 1][column + 2] = true;
                }
                //third row
                if (inBounds(row + 2, column)) {
                    board[row + 2][column] = false;
                }
                if (inBounds(row + 2, column + 1))  {
                    board[row + 2][column + 1] = true;
                }
                if (inBounds(row + 2, column + 2))  {
                    board[row + 2][column + 2] = true;
                }
            }
            else -> println("Choose a pattern")
        }
        notifyView()
    }

    fun checkNeighbours(row: Int, column: Int):Int {
        var numberOfNeighbours = 0;
        //row - 1
        if (inBounds(row - 1, column - 1)) {
            ++numberOfNeighbours;
        }
        if (inBounds(row - 1, column)) {
            ++numberOfNeighbours;
        }
        if (inBounds(row - 1, column + 1)) {
            ++numberOfNeighbours;
        }
        //row
        if (inBounds(row , column - 1)) {
            ++numberOfNeighbours;
        }
        if (inBounds(row , column )) {
            ++numberOfNeighbours;
        }
        if (inBounds(row , column + 1)) {
            ++numberOfNeighbours;
        }
        //row + 1
        if (inBounds(row + 1 , column - 1)) {
            ++numberOfNeighbours;
        }
        if (inBounds(row + 1 , column )) {
            ++numberOfNeighbours;
        }
        if (inBounds(row + 1 , column + 1)) {
            ++numberOfNeighbours;
        }
        return numberOfNeighbours;
    }

    fun updateBoard()  {
        for (row in  0 until sizeOuter) {
            for (column in 0 until sizeInner) {
                //ALIVE
                if (board[row][column]) {
                    val numberofNeighbours = checkNeighbours(row, column);
                    if (numberofNeighbours < 2) {
                        board[row][column] = false;
                    } else if (numberofNeighbours <= 3) {
                        board[row][column] = true;
                    }  else if (numberofNeighbours > 3) {
                        board[row][column] = false;
                    }
                } else {
                    val numberofNeighbours = checkNeighbours(row, column);
                    if (numberofNeighbours == 3) {
                        board[row][column] = true;
                    }
                }
            }
        }
        notifyView()
    }

    fun play(){
        //disable spacebar
        isGamePlaying = true;
        timeLine?.play()
    }

    fun pause() {
        isGamePlaying = false;
        timeLine?.pause()
        //enable spacebar for next
    }

}