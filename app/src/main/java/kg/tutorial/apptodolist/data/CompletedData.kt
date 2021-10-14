package kg.tutorial.apptodolist.secondfragment

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "completed")
class CompletedData(
    @PrimaryKey(autoGenerate = true)
    val isCompleted: Boolean,
    val percent: Float,
    val date: String,
    val task: String
)

