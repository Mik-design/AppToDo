package kg.tutorial.apptodolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import kg.tutorial.apptodolist.databinding.CircleWeekdayBinding
import kg.tutorial.apptodolist.mainfragment.Todo

class WeekdayAdapter : RecyclerView.Adapter<WeekdayAdapter.WeekdayVH>() {

        private var weekday: List<Todo> = emptyList()


    fun submitWeekday(item: List<Todo>) {
        weekday = item
        notifyDataSetChanged()
    }

    // xml dlya krujkov
    class WeekdayVH(private val binding: CircleWeekdayBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Todo) {
            //binding.fragmentvontainer.text = item.weekday
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

