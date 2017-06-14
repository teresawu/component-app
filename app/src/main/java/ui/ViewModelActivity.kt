package ui

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import data.AppViewModel
import kotlinx.android.synthetic.main.activity_viewmodel.*
import test.com.componentapp.R

class ViewModelActivity : AppCompatActivity(), LifecycleRegistryOwner {

    private val registry = LifecycleRegistry(this)
    override fun getLifecycle(): LifecycleRegistry = registry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)
        val model = ViewModelProviders.of(this).get(AppViewModel::class.java)
        model.getUsers().observe(this, Observer<List<String>> { users ->
            if (users != null) viewTxt.text = "User list size = " + users.size
        })
    }
}