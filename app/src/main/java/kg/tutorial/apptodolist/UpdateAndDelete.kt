package kg.tutorial.apptodolist

interface UpdateAndDelete {
    fun modifyItem(itemUID: String, isDone:Boolean)
    fun onItemDelete(itemUID: String)
}