package kg.tutorial.apptodolist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kg.tutorial.apptodolist.R
import kg.tutorial.apptodolist.UpdateAndDelete
import kg.tutorial.apptodolist.model.RecurringModel

class RecurringAdapter(context: Context, private val listener: UpdateAndDelete, recurringList: MutableList<RecurringModel>) : BaseAdapter() {
    private val inflater_one: LayoutInflater = LayoutInflater.from(context)
    private var itemList_one = recurringList

    override fun getCount(): Int {
        return itemList_one.size
    }

    override fun getItem(position: Int): Any {
        return itemList_one.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val UID: String = itemList_one.get(position).UID as String
        val itemTextData = itemList_one.get(position).itemDataText as String
        val done: Boolean = itemList_one.get(position).done as Boolean
        val view: View
        val viewHolder: RecurringListViewHolder

        if (convertView == null) {
            view = inflater_one.inflate(R.layout.row_itemlayout_tasksfortoday, parent, false)
            viewHolder = RecurringListViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as RecurringListViewHolder
        }
        viewHolder.textLabel.text = itemTextData
        viewHolder.isDone.isChecked = done
        viewHolder.isDone.setOnClickListener {
            listener.modifyItem(UID, !done)
        }
        viewHolder.isDeleted.setOnClickListener {
            listener.onItemDelete(UID)

        }

        return view
    }
}

private class RecurringListViewHolder(row: View) {
    val textLabel: TextView = row.findViewById(R.id.item_textView) as TextView
    val isDone: CheckBox = row.findViewById(R.id.checkbox) as CheckBox
    val isDeleted: ImageView = row.findViewById(R.id.close) as ImageView
}










