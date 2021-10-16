class Model {
    // represent my board
    private val sizeOuter = 80
    private val sizeInner = 75

    private val views = ArrayList<IView>()
    private val board = Array(sizeOuter) { BooleanArray(sizeInner) }

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
}