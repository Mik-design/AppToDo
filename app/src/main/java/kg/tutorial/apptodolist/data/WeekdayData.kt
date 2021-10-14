package kg.tutorial.apptodolist.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "weekDates")
class WeekdayData(
    @PrimaryKey(autoGenerate = true)
    val date: String,
    val weekday: String,
    val percent: Float,

)