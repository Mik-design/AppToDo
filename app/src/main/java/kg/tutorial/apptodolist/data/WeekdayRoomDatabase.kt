package kg.tutorial.apptodolist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kg.tutorial.apptodolist.dao.WeekdayDao
import kg.tutorial.apptodolist.mainfragment.TodoData


// Annotates class to be a Room Database with a table (entity) of the Todo class
@Database(entities = [TodoData::class], version = 1, exportSchema = false)
abstract class WeekdayRoomDatabase : RoomDatabase() {

    abstract fun weekdayDao(): WeekdayDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: WeekdayRoomDatabase? = null

        fun getDatabase(context: Context): WeekdayRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WeekdayRoomDatabase::class.java,
                    "todo_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
