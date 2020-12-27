package dk.itu.moapd.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)
            .get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        true_button.setOnClickListener {
            viewModel.state = getString(R.string.true_text)
            updateUI()
        }

        false_button.setOnClickListener {
            viewModel.state = getString(R.string.false_text)
            updateUI()
        }

        check_box.setOnClickListener {
            viewModel.toggleStatus()
            val status = if (viewModel.isChecked()) "checked" else "unchecked"
            viewModel.state = String.format("You %s the checkbox", status)
            updateUI()
        }

        updateUI()
    }

    private fun updateUI() {
        text_view.text = viewModel.state
    }

}
