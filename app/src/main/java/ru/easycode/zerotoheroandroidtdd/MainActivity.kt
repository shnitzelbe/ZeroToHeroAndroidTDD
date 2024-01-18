package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY_TITLE_TEXT = "TITLE"
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val textView: TextView = findViewById(R.id.titleTextView)
        //val button: Button = findViewById(R.id.changeButton)
        binding.changeButton.setOnClickListener {
            binding.titleTextView.text = "I am an Android Developer!"
        }

        savedInstanceState?.let {
            it.getString(KEY_TITLE_TEXT, null)?.let { title ->
                binding.titleTextView.text = title
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_TITLE_TEXT, binding.titleTextView.text.toString())
    }
}