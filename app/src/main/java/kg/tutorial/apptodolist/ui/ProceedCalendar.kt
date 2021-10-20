package kg.tutorial.apptodolist.ui

import android.app.AlertDialog
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*
import kg.tutorial.apptodolist.R
import kg.tutorial.apptodolist.UpdateAndDelete
import kg.tutorial.apptodolist.adapter.ToDoAdapter
import kg.tutorial.apptodolist.databinding.ProceedCalendarBinding
import kg.tutorial.apptodolist.model.ToDoModel
import kotlinx.parcelize.Parcelize

class ProceedCalendar : Fragment(), UpdateAndDelete {

    lateinit var database: DatabaseReference//
    var toDoList: MutableList<ToDoModel>? = null

    lateinit var adapter: ToDoAdapter

    private var listViewItem: ListView? = null//

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
        println("DATE: $date")
        binding.tvDate.text = date?.year.toString()

        database = FirebaseDatabase.getInstance("https://apptodo-33e5b-default-rtdb.firebaseio.com").reference

        val btnAdd = view.findViewById<FloatingActionButton>(R.id.btn_add)
        listViewItem = binding.tasksfortodaytwo.itemListView

        btnAdd.setOnClickListener {
            val alertDialog = AlertDialog.Builder(requireContext())
            val textEditText = EditText(requireContext())
            alertDialog.setMessage("Add ToDo item")
            alertDialog.setTitle("Enter ToDo item")
            alertDialog.setView(textEditText)
            alertDialog.setPositiveButton("Add") { dialog, i ->
                val todoItemData = ToDoModel.createList()
                todoItemData.itemDataText = textEditText.text.toString()
                todoItemData.done = false


                val newItemData = database.child("todo").push()
                todoItemData.UID = newItemData.key
                newItemData.setValue(todoItemData)


                dialog.dismiss()
                Toast.makeText(requireContext(), "item saved", Toast.LENGTH_LONG).show()
            }
            alertDialog.show()
        }
        toDoList = mutableListOf<ToDoModel>()
        adapter = ToDoAdapter(requireContext(), this, toDoList!!)
        listViewItem!!.adapter = adapter

        database.addValueEventListener(object : ValueEventListener {

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), "No item added", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                toDoList!!.clear()
                addItemToList(snapshot)
            }

        })
    }

    private fun addItemToList(snapshot: DataSnapshot) {
        val items = snapshot.children.iterator()

        if (items.hasNext()) {
            val toDoIndexedValue = items.next()
            val itemsIterator = toDoIndexedValue.children.iterator()

            while (itemsIterator.hasNext()) {
                val currentItem = itemsIterator.next()
                val toDoItemData = ToDoModel.createList()
                val map = currentItem.value as HashMap<String, Any>

                toDoItemData.UID = currentItem.key
                toDoItemData.done = map.get("done") as Boolean
                toDoItemData.itemDataText = map.get("itemDataText") as String?
                toDoList?.add(toDoItemData)
            }
        }
        adapter.notifyDataSetChanged()
    }

    override fun modifyItem(itemUID: String, isDone: Boolean) {
        val itemReference = database.child("todo").child(itemUID)
        itemReference.child("done").setValue(isDone)
    }

    override fun onItemDelete(itemUID: String) {
        val itemReference = database.child("todo").child(itemUID)
        itemReference.removeValue()
        adapter.notifyDataSetChanged()
    }

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

