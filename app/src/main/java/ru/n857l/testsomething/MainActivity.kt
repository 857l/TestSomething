package ru.n857l.testsomething

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.n857l.testsomething.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = (application as App).viewModel

        binding.actionButton.setOnClickListener {
            Log.d("857ll", "asd")
            binding.actionButton.isEnabled = false
            binding.progressBar.visibility = View.VISIBLE
            viewModel.getJoke()
        }

        val textCallBack = object : TextCallBack {
            override fun provideText(text: String) = runOnUiThread {
                binding.actionButton.isEnabled = true
                binding.progressBar.visibility = View.INVISIBLE
                binding.textView.text = text
            }

        }
        viewModel.init(textCallBack)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clear()
    }
}