package kg.tutorial.apptodolist.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kg.tutorial.apptodolist.databinding.TasksfortodayoneBinding

class FragmentTasksfortoday: Fragment() {

    private var _binding: TasksfortodayoneBinding? = null
    private val binding: TasksfortodayoneBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TasksfortodayoneBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tasksfortodaytwo.btnAdd.setOnClickListener {
            SimpleDialog.newInstance("Create task", "subtitle", "1st October").show(childFragmentManager, SimpleDialog.TAG)
            //CalendarSimpleDialog.newInstance("Check the date", "Check month", "any date")
        }
    }



    companion object {
        fun newInstance(): FragmentTasksfortoday = FragmentTasksfortoday()
    }
}