package kg.tutorial.apptodolist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mygoals")
class MygoalsData(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val isCompleted: Boolean,
    val percent: Float,
    val date: String,
    val task: String,
    val weekday: String
)
