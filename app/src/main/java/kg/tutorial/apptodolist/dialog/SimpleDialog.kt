package kg.tutorial.apptodolist.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import kg.tutorial.apptodolist.databinding.AddGroupBinding
import kg.tutorial.apptodolist.dialog.SimpleDialog.Companion.newInstance
import kg.tutorial.apptodolist.fragments.ImportantRecurringTasks
import kg.tutorial.apptodolist.fragments.MyGoals.Companion.newInstance


class SimpleDialog : DialogFragment() {

    private var _binding: AddGroupBinding? = null
    private val binding: AddGroupBinding get() = _binding!!


    companion object {
        const val TAG = "SimpleDialog"

        private const val KEY_TITLE = "KEY_TITLE"
        private const val KEY_SUBTITLE = "KEY_SUBTITLE"

        fun newInstance(title: String, subTitle: String, date: String): SimpleDialog {
            val args = Bundle()
            args.putString(KEY_TITLE, title)
            args.putString(KEY_SUBTITLE, subTitle)
            val fragment = SimpleDialog()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AddGroupBinding.inflate(inflater)
        binding.addTask.setOnClickListener {
            ImportantRecurringTasks.newInstance()
//            SimpleDialog.newInstance("Achive my goal", "Plan it every day", "By end of November").show(childFragmentManager, SimpleDialog.TAG)
/*
            val editTextString = ".,m,m,m,m,m,m.." // Get string from EditText
                // Use the Kotlin extension in the fragment-ktx artifact
                setFragmentResult("keyClicked", bundleOf("bundleKey" to editTextString))
           */ }



//            dismiss()

//        show(childFragmentManager, SimpleDialog.TAG)
        return  binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }
}
