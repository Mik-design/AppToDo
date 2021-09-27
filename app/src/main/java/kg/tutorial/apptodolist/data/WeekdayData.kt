package kg.tutorial.apptodolist.mainfragment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.MonthDay

@Entity(tableName = "todo")
class Todo(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val isCompleted: Boolean,
    val percent: Float,
    val date: String,
    val task: String
)