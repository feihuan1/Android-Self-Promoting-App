package com.example.selfpromotingapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.selfpromotingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.buttonPreview.setOnClickListener {
            onPreviewClicked()
        }

        val spinnerValues: Array<String> = arrayOf("Sales", "Frontend Engineer", "ML Engineer")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)

        binding.spinnerJobTitle.adapter = spinnerAdapter

    }

    private fun onPreviewClicked() {
        val contactName = binding.editTextContactName.text?.toString().orEmpty()
        val contactNumber = binding.editTextContactNumber.text?.toString().orEmpty()
        val myDisplayName = binding.editTextMyDisplayName.text?.toString().orEmpty()
        val includeJunior = binding.checkBoxJunior.isChecked
        val jobTitle = binding.spinnerJobTitle.selectedItem?.toString()
        val immediateStart = binding.checkBoxImmediateStart.isChecked
        val startDate = binding.editTextStartDate.text?.toString().orEmpty()

        val previewActivityIntent: Intent = Intent(this, PreviewActivity::class.java)

        previewActivityIntent.putExtra("Contact Name", contactName)
        previewActivityIntent.putExtra("Contact number", contactNumber)
        previewActivityIntent.putExtra("My Display Name", myDisplayName)
        previewActivityIntent.putExtra("Include Junior", includeJunior)
        previewActivityIntent.putExtra("Job Title", jobTitle)
        previewActivityIntent.putExtra("Immediate Start", immediateStart)
        previewActivityIntent.putExtra("Start Date", startDate)

        startActivity(previewActivityIntent)
    }
}