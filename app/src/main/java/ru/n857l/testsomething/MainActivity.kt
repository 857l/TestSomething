package ru.n857l.testsomething

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = (application as MyApplication).viewModel

        val textView = findViewById<TextView>(R.id.textView)

        viewModel.observe(object : UiStateCallback {

            override fun post(message: String) {
                textView.text = message
            }
        })

    }

    override fun onResume() {
        super.onResume()
        viewModel.startTrackingTime()
    }

    override fun onPause() {
        super.onPause()
        viewModel.stopTrackingTime()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clear()
    }
}
