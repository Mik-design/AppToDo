package kg.tutorial.apptodolist.mainfragment

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
class TodoData(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val isCompleted: Boolean,
    val percent: Float,
    val date: String,
    val task: String,
    val weekday: String
)