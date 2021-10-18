package kg.tutorial.apptodolist.main

import com.google.android.gms.common.util.CollectionUtils.listOf
import kg.tutorial.apptodolist.mainfragment.TodoData

object FakeMassive {
    val fakeTodoList = listOf<TodoData>(
        TodoData (1, false, 0f, "1st September", "To wakeup", "Monday"),
        TodoData (2, false, 0f, "2nd September", "To eat", "Tuesday"),
        TodoData (3, false, 0f, "3rd September", "To play", "Wednesday"),
        TodoData (4, false, 0f, "4th September", "To study", "Thursday"),
        TodoData (5, false, 0f, "5th September", "To earn money", "Friday"),
        TodoData (6, false, 0f, "6th September", "To take care of kids", "Saturday"),
        TodoData (7, false, 0f, "7th September", "To read a book", "Sunday"),
        TodoData (8, false, 0f, "8th September", "To play golf", "Monday" ),
        TodoData (9, false, 0f, "9th September", "To participate at the seminar", "Tuesday"),
        TodoData (10, false, 0f, "10th September", "To dream", "Wednesday"),
        TodoData (11, false, 0f, "11th September", "To cook food", "Thursday"),
        TodoData (12, false, 0f, "12th September", "To check the tasks", "Friday"),
        TodoData (13, false, 0f, "13th September", "To drive to town", "Saturday" ),
        TodoData (14, false, 0f, "14th September", "To live a happy life", "Sunday"),
        TodoData (15, false, 0f, "15th September", "To find a beatiful house", "Monday"),
    )
}
