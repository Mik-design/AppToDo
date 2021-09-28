package kg.tutorial.apptodolist.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kg.tutorial.apptodolist.databinding.MygoalsoneBinding

class MyGoals: Fragment() {

    private var _binding: MygoalsoneBinding? = null
    private val binding: MygoalsoneBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MygoalsoneBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tasksfortodaytwo.btnAdd.setOnClickListener {
            SimpleDialog.newInstance("Achive my goal", "Plan it every day", "By end of November").show(childFragmentManager, SimpleDialog.TAG)

        }
    }

    companion object {
        fun newInstance(): MyGoals = MyGoals()
    }
}


