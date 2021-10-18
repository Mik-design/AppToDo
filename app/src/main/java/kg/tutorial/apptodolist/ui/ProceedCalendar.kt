package kg.tutorial.apptodolist.ui

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kg.tutorial.apptodolist.databinding.ProceedCalendarBinding
import kotlinx.parcelize.Parcelize

class ProceedCalendar : Fragment() {

    private var _binding: ProceedCalendarBinding? = null
    private val binding: ProceedCalendarBinding get() = _binding!!

    private var date: Date? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        date = arguments?.getParcelable(DATE_KEY)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ProceedCalendarBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        clicked()
        println("DATE: $date")
        binding.tvDate.text = date?.year.toString()
    }

    /* private fun clicked() {
         binding..setOnClickListener {
                 requireActivity().supportFragmentManager
                     .beginTransaction()
                     .replace(R.id.fragment_view, ImportantRecurringTasks.newInstance())
                     .addToBackStack(null)
                     .commit()
             }
     }
    */

    @Parcelize
    data class Date(
        val year: Int,
        val month: Int,
        val day: Int
    ): Parcelable

    companion object {
        fun newInstance(date: Date) = ProceedCalendar().apply {
            arguments = Bundle().apply {
                putParcelable(DATE_KEY, date)
            }
        }
        const val DATE_KEY: String = "DATE"
    }
}

