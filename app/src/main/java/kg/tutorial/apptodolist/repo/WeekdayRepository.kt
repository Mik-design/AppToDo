package kg.tutorial.apptodolist.repo

import kg.tutorial.apptodolist.mainfragment.Todo
import kg.tutorial.apptodolist.dao.WeekdayDao


// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class WeekdayRepository(private val weekdayDao: WeekdayDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.

    suspend fun getAlphabetizedWords(): List<Todo> = weekdayDao.getAlphabetizedWords()


    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.

    suspend fun insert(todo: Todo) {
        weekdayDao.insert(todo)
    }
}
