package ru.n857l.testsomething

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
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
            val email = it.toString()
            val valid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

            if (!valid){
                binding.checkBox.isEnabled = false
                binding.textInputLayout.error = "Incorrect email"
            }
            else{
                binding.checkBox.isEnabled = !it.isNullOrEmpty()
                binding.textInputLayout.error = null
            }
        }

        binding.loginButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.dialog, null)

            val dialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .setCancelable(false)
                .create()

            val closeButton = dialogView.findViewById<ImageButton>(R.id.closeButton)
            closeButton?.setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()
        }

    }
}
