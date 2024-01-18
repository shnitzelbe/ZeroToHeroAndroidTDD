package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY_TITLE_TEXT = "TITLE"
        const val KEY_TITLE_VISIBLE = "TITLE_VISIBLE"
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val textView: TextView = findViewById(R.id.titleTextView)
        //val button: Button = findViewById(R.id.changeButton)
        binding.hideButton.setOnClickListener {
            binding.titleTextView.visibility = View.GONE
        }

        savedInstanceState?.let {
            it.getBoolean(KEY_TITLE_VISIBLE, true)?.let { visible ->
                binding.titleTextView.visibility = if(visible) View.VISIBLE else View.GONE
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_TITLE_VISIBLE, binding.titleTextView.visibility == View.VISIBLE)
    }
}