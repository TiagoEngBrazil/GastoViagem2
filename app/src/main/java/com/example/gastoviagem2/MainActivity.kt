package com.example.gastoviagem2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gastoviagem2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            calculate()
        }
    }

    private fun isValue(): Boolean {
        return (binding.editDistance.text.toString() != "" && binding.editPrice.text.toString() != ""
            && binding.editAutonomy.text.toString() != ""
            && binding.editAutonomy.text.toString().toFloat() != 0f)
        }

        private fun calculate() {
            if (isValue()) {
                val distance = binding.editDistance.text.toString().toFloat()
                val price = binding.editPrice.text.toString().toFloat()
                val autonomy = binding.editAutonomy.text.toString().toFloat()

                val totalValue = (price * distance) / autonomy
                binding.textFullPrice.text = "R$ ${"%.2f".format(totalValue)}"
            } else {
                Toast.makeText(this, R.string.validation_fill_all_fields, Toast.LENGTH_LONG).show()
            }
        }
    }
