package jp.yuki.senda.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import jp.yuki.senda.aisatsuapp.databinding.ActivityMainBinding
import jp.yuki.senda.aisatsuapp.databinding.ActivityMainBinding.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button -> showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                if(hour >= 2 && hour <= 9){
                    binding.textView.text = "おはよう"
                }else if (hour >= 10 && hour <= 17){
                    binding.textView.text = "こんにちは"
                }else{
                    binding.textView.text = "こんばんは"
                }
            },
            13, 0, true
        )
        timePickerDialog.show()
    }
}