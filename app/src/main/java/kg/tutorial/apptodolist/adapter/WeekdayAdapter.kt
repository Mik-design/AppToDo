package kg.tutorial.apptodolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.tutorial.apptodolist.data.WeekdayData
import kg.tutorial.apptodolist.databinding.CircleWeekdayBinding

class WeekdayAdapter : RecyclerView.Adapter<WeekdayAdapter.WeekdayVH>() {

    private var weekday: List<WeekdayData> = emptyList()


    fun submitWeekday(item: List<WeekdayData>) {
        weekday = item
        notifyDataSetChanged()
    }

    // xml dlya krujkov
    class WeekdayVH(private val binding: CircleWeekdayBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WeekdayData) {
            binding.date.text = item.date.toString()
            binding.week.text = item.weekday
            binding.per.text = item.percent.toString()

//            binding.fragmentcontainer.text = item.weekday
        }

        companion object {
            fun from(parent: ViewGroup): WeekdayVH {
                val inflater = LayoutInflater.from(parent.context)
                val binding = CircleWeekdayBinding.inflate(inflater)
                return WeekdayVH(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekdayVH =
        WeekdayVH.from(parent)

    override fun onBindViewHolder(holder: WeekdayVH, position: Int) = holder.bind(weekday[position])

    override fun getItemCount(): Int = weekday.size
}

