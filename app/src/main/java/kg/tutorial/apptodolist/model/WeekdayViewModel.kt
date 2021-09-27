package kg.tutorial.apptodolist.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.tutorial.apptodolist.mainfragment.Todo
import kg.tutorial.apptodolist.repo.WeekdayRepository
import kotlinx.coroutines.launch


class WeekdayViewModel(private val repository: WeekdayRepository) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
//    val allTodo: LiveData<List<DateTodo>> = repository.allTodo.asLiveData()/??? do we need it?

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(todo: Todo) = viewModelScope.launch {
        repository.insert(todo)
    }
}
