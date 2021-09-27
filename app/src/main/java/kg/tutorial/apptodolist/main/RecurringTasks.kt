package kg.tutorial.apptodolist.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kg.tutorial.apptodolist.databinding.RecurringtasksoneBinding

class RecurringTasks : Fragment() {

    private var _binding: RecurringtasksoneBinding? = null
    private val binding: RecurringtasksoneBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RecurringtasksoneBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(): RecurringTasks = RecurringTasks()
    }
}
