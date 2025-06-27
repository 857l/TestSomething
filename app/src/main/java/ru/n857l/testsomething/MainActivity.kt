package ru.n857l.testsomething

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import ru.n857l.testsomething.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding .inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            binding.loginButton.isEnabled = isChecked
        }

        binding.editText.doAfterTextChanged {
            binding.checkBox.isEnabled = !it.isNullOrEmpty()
        }

    }
}
