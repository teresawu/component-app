package ui

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import data.BorrowModel
import data.BorrowViewModel
import kotlinx.android.synthetic.main.activity_viewmodel.*
import test.com.componentapp.R

class RoomActivity : AppCompatActivity(), LifecycleRegistryOwner {
    private var borrowViewModel: BorrowViewModel? = null
    private val registry = LifecycleRegistry(this)
    override fun getLifecycle(): LifecycleRegistry = registry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)
        borrowViewModel = ViewModelProviders.of(this).get(BorrowViewModel::class.java)
        addItem();
        borrowViewModel?.itemAndPersonList?.observe(this@RoomActivity, Observer<List<BorrowModel>> {
            itemAndPeople ->
            viewTxt.text = "Total = " + itemAndPeople?.size
        })
    }

    private fun addItem() {
        for (number in 1..10)
            borrowViewModel?.addItem(BorrowModel(number, "title" + number, "person" + number))
    }
}