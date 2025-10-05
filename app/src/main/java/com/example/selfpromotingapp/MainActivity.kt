package com.example.selfpromotingapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.selfpromotingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPreview.setOnClickListener {
            onPreviewClicked()
        }
    }

    private fun onPreviewClicked() {
        val contactName = binding.editTextContactName.text?.toString().orEmpty()
        val contactNumber = binding.editTextContactNumber.text?.toString().orEmpty()
        val myDisplayName = binding.editTextMyDisplayName.text?.toString().orEmpty()
        val includeJunior = binding.checkBoxJunior.isChecked
        val jobTitle = binding.spinnerJobTitle.selectedItem.toString()
        val immediateStart = binding.checkBoxImmediateStart.isChecked
        val startDate = binding.editTextStartDate.text?.toString().orEmpty()

        val textString = "$contactName, $contactNumber"
        Toast.makeText(this, textString, Toast.LENGTH_LONG).show()
    }
}