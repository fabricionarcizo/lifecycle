package dk.itu.moapd.lifecycle

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var state = "Hello World!"
    private var status = false

    fun toggleStatus() {
        status = !status
    }

    fun isChecked(): Boolean {
        return status
    }

}
