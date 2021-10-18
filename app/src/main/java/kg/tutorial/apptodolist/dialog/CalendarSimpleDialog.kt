package kg.tutorial.apptodolist.dialog

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import kg.tutorial.apptodolist.R
import kg.tutorial.apptodolist.databinding.CalendarTwoBinding
import kg.tutorial.apptodolist.fragments.ProceedCalendar
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat

class CalendarSimpleDialog: DialogFragment() {

    private var _binding: CalendarTwoBinding? = null
    private val binding: CalendarTwoBinding get() = _binding!!

    private var date: Date? = null

    companion object {

        const val TAG = "CalendarDialog"

        private const val KEY_TITLE = "KEY_TITLE"
        private const val KEY_SUBTITLE = "KEY_SUBTITLE"

        fun newInstance(title: String, subTitle: String, date: String): CalendarSimpleDialog {
            val args = Bundle()
            args.putString(KEY_TITLE, title)
            args.putString(KEY_SUBTITLE, subTitle)
            val fragment = CalendarSimpleDialog()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CalendarTwoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnClicked()
    }

    private fun btnClicked() {
        binding.ivClose.setOnClickListener {
            dismiss()
        }
        binding.calView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            date = Date(year, month, dayOfMonth)
        }
        binding.proceed.setOnClickListener {
            val nonFormattedDate: List<String> = convertLongToTime(binding.calView.date).split(".")
            val year = nonFormattedDate[0].toInt()
            val month = nonFormattedDate[1].toInt()
            val day = nonFormattedDate[2].toInt()
            val currentDate = Date(year, month, day)
            if (date != null) {
                println("SEND DATE: $currentDate")
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_view, ProceedCalendar.newInstance(date!!))
                    .addToBackStack(null)
                    .commit()
            } else {
                println("SEND CURRENT DATE: $currentDate")
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_view, ProceedCalendar.newInstance(currentDate))
                    .addToBackStack(null)
                    .commit()
            }
        }
        /*binding.close.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.close, ProceedCalendar.newInstance())
                .addToBackStack(null)
                .commit()
        }*/
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT

        )
    }
}

@Parcelize
data class Date(
    val year: Int,
    val month: Int,
    val day: Int
): Parcelable

private fun convertLongToTime(time: Long): String {
    val date = java.util.Date(time)
    val format = SimpleDateFormat("yyyy.MM.dd")
    return format.format(date)
}
