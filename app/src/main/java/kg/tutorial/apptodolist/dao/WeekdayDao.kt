package kg.tutorial.apptodolist.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kg.tutorial.apptodolist.mainfragment.TodoData

@Dao
interface WeekdayDao {

    @Query("SELECT * FROM todo")
    suspend fun getAlphabetizedWords(): List<TodoData>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(todo: TodoData)

    @Query("DELETE FROM todo")
    suspend fun deleteAll()
}
