package kg.tutorial.apptodolist.repo

import kg.tutorial.apptodolist.dao.CompletedDao
import kg.tutorial.apptodolist.secondfragment.CompletedData


class CompletedRepository(private val completedDao: CompletedDao) {

    suspend fun getAlphabetizedWords(): List<CompletedData> = completedDao.getAlphabetizedWords()


    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.

    suspend fun insert(completed: CompletedData) {
        insert(completed)
    }
}

