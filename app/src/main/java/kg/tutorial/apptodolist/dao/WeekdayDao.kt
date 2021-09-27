package kg.tutorial.apptodolist.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kg.tutorial.apptodolist.mainfragment.Todo

@Dao
interface WeekdayDao {

    @Query("SELECT * FROM todo")
    suspend fun getAlphabetizedWords(): List<Todo>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(todo: Todo)

    @Query("DELETE FROM todo")
    suspend fun deleteAll()
}
