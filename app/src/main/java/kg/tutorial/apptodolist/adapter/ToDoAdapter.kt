package kg.tutorial.apptodolist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kg.tutorial.apptodolist.R
import kg.tutorial.apptodolist.UpdateAndDelete
import kg.tutorial.apptodolist.model.ToDoModel

class ToDoAdapter(context: Context, private val listener: UpdateAndDelete, toDoList: MutableList<ToDoModel>):BaseAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var itemList = toDoList

    override fun getCount(): Int {
        return itemList.size
    }

    override fun getItem(position: Int): Any {
        return itemList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val UID: String = itemList.get(position).UID as String
        val itemTextData = itemList.get(position).itemDataText as String
        val done: Boolean = itemList.get(position).done as Boolean
        val view: View
        val viewHolder: ListViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.row_itemlayout_tasksfortoday, parent, false)
            viewHolder = ListViewHolder(view)
             view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ListViewHolder
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

private class ListViewHolder(row: View) {
    val textLabel: TextView = row.findViewById(R.id.item_textView) as TextView
    val isDone: CheckBox = row.findViewById(R.id.checkbox) as CheckBox
    val isDeleted: ImageView = row.findViewById(R.id.close) as ImageView
}










