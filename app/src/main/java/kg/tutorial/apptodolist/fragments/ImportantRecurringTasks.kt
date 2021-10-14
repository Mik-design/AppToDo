package kg.tutorial.apptodolist.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import kg.tutorial.apptodolist.databinding.ImportantRecurringtasksBinding


class ImportantRecurringTasks: Fragment(), AdapterView.OnItemSelectedListener {
    private var _binding: ImportantRecurringtasksBinding? = null
    private val binding: ImportantRecurringtasksBinding get() = _binding!!

    var states = arrayOf("None", "Low", "Medium", "High")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ImportantRecurringtasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.spinner.setOnItemSelectedListener(this)

        val arr = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, states)
        arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = arr

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        binding.msg.text = "Selected : " + states[position]

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
    companion object {
        fun newInstance(): ImportantRecurringTasks = ImportantRecurringTasks()
    }
}

