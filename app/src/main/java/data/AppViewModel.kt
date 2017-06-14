package data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import java.util.ArrayList

class AppViewModel : ViewModel() {
    private val users: MutableLiveData<List<String>> = MutableLiveData<List<String>>()

    fun getUsers(): LiveData<List<String>> {
        if (users.value == null) loadUsers()
        return users
    }

    private fun loadUsers() {
        val temp = ArrayList<String>()
        temp.add("userA")
        temp.add("userB")
        temp.add("userC")
        users!!.value = temp
    }
}