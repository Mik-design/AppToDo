package kg.tutorial.apptodolist.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.firebase.database.*
import kg.tutorial.apptodolist.R
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
        clicked()
    }

    private fun clicked() {
        binding.recurringtaskstwo.btnPlus.setOnClickListener {
                val dialog = Dialog(requireContext())
                dialog.setContentView(R.layout.add_group)
                val button = dialog.findViewById<Button>(R.id.add_task)
                button.setOnClickListener {
                    dialog.dismiss()
                    requireActivity().supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_view, ImportantRecurringTasks.newInstance())
                        .addToBackStack(null)
                        .commit()
                }
                dialog.show()
            }
        }


    companion object {
        fun newInstance(): RecurringTasks = RecurringTasks()
    }
}


/*binding.tasksfortodaytwo.btnAdd.setOnClickListener {
SimpleDialog.newInstance("Follow up", "Recheck", "Every week").show(childFragmentManager, SimpleDialog.TAG)
}      }*/





