package kg.tutorial.apptodolist.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kg.tutorial.apptodolist.R
import kg.tutorial.apptodolist.adapter.WeekdayAdapter
import kg.tutorial.apptodolist.databinding.WeekdaysBinding

class MainFragment : Fragment() {

    private var _binding: WeekdaysBinding? = null
    private val binding: WeekdaysBinding get() = _binding!!
    private val weekdayAdapter: WeekdayAdapter = WeekdayAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = WeekdaysBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recViewTask.adapter = weekdayAdapter
        weekdayAdapter.submitWeekday(FakeMassive.fakeTodoList)
        commentOnClicked()
        calendarOnClicked()
        mygoalsOnClicked()
        recurringOnClicked()
    }

    private fun recurringOnClicked() {
        binding.todoList.recTasks.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_view, RecurringTasks.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun mygoalsOnClicked() {
        binding.todoList.goals.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_view, MyGoals.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun calendarOnClicked() {
        binding.todoList.calendar.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_view, CalendarTwo.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun commentOnClicked() {
        binding.todoList.task.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_view, FragmentTasksfortoday.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }


    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}