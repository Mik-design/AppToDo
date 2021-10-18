package kg.tutorial.apptodolist.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kg.tutorial.apptodolist.R
import kg.tutorial.apptodolist.databinding.MygoalsoneBinding

class MyGoals : Fragment() {

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
        clicked()
    }
/*
        binding.tasksfortodaytwo.btnAdd.setOnClickListener {
            SimpleDialog.newInstance("Achive my goal", "Plan it every day", "By end of November").show(childFragmentManager, SimpleDialog.TAG)

        }
*/

    private fun clicked() {
        binding.tasksfortodaytwo.btnAdd.setOnClickListener {
            val dialog = Dialog(requireContext())
            dialog.setContentView(R.layout.add_group)
            val button = dialog.findViewById<Button>(R.id.add_task)
            button.setOnClickListener {
            dialog.dismiss()
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_view, ImportantGoals.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
            dialog.show()
        }
    }

    companion object {
        fun newInstance(): MyGoals = MyGoals()
    }
}


