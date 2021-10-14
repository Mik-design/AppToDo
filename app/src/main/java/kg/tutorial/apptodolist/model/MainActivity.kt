package kg.tutorial.apptodolist.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.tutorial.apptodolist.R
import kg.tutorial.apptodolist.fragments.MainFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_view, MainFragment.newInstance())
            .commit()
    }
}