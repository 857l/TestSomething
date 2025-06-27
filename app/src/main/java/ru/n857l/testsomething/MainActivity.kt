package ru.n857l.testsomething

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.bottomsheet.BottomSheetDialog
import ru.n857l.testsomething.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            binding.loginButton.isEnabled = isChecked
        }

        binding.editText.doAfterTextChanged {
            binding.checkBox.isEnabled = !it.isNullOrEmpty()
        }

        binding.loginButton.setOnClickListener {
            val dialog = BottomSheetDialog(this).apply {
                setContentView(R.layout.dialog)
                setCancelable(false)

            }

            val closeButton = dialog.findViewById<ImageButton>(R.id.closeButton)
            closeButton?.setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()
        }

    }
}
