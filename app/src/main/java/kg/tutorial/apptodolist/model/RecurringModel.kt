package kg.tutorial.apptodolist.model

class RecurringModel {

    companion object Factory {
        fun createList(): RecurringModel = RecurringModel()
    }

    var UID: String? = null
    var itemDataText: String? = null
    var done: Boolean? = false
}
