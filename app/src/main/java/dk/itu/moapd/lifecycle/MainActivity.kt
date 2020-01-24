package dk.itu.moapd.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        const val STATE = "state"
        const val CHECK = "check"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        true_button.setOnClickListener {
            text_view.text = getString(R.string.true_text)
        }

        false_button.setOnClickListener {
            text_view.text = getString(R.string.false_text)
        }

        check_box.setOnCheckedChangeListener { _, isChecked ->
            val status = if (isChecked) "checked" else "unchecked"
            text_view.text = String.format("You %s the checkbox", status)
        }

        if (savedInstanceState != null) {
            check_box.isChecked = savedInstanceState.getBoolean(CHECK, false)
            text_view.text = savedInstanceState.getString(STATE, "Hello World!")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val state = text_view.text.toString()
        outState.putString(STATE, state)

        val status = check_box.isChecked
        outState.putBoolean(CHECK, status)

        super.onSaveInstanceState(outState)
    }

}
