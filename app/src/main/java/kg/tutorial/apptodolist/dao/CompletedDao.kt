package kg.tutorial.apptodolist.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kg.tutorial.apptodolist.secondfragment.Completed

@Dao
interface CompletedDao {
    @Query("SELECT * FROM completed")
    suspend fun getAlphabetizedWords(): List<Completed>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(completed: Completed)

    @Query("DELETE FROM completed")
    suspend fun deleteAll()
}

