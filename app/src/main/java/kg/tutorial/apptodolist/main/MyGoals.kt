package kg.tutorial.apptodolist.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kg.tutorial.apptodolist.databinding.MygoalsoneBinding

class MyGoals: Fragment() {

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
    }

    companion object {
        fun newInstance(): MyGoals = MyGoals()
    }
}


