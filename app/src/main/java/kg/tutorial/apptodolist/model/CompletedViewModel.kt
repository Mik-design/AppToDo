package kg.tutorial.apptodolist.secondfragment

import androidx.lifecycle.*
import kg.tutorial.apptodolist.repo.CompletedRepository
import kotlinx.coroutines.launch

class CompletedViewModel(private val repository: CompletedRepository): ViewModel() {

val completedLiveData: LiveData<CompletedData> = MutableLiveData()
    fun insert(completed: CompletedData) = viewModelScope.launch {
        repository.insert(completed)//??? what to insert here???
    }
}

/*class CompletedViewModelFactory(private val repository: CompletedRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CompletedViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CompletedViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }*/

