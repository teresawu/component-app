package ui

import data.BorrowModel
import data.BorrowedListViewModel
import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.activity_room.*
import java.util.ArrayList
import test.com.componentapp.R

class RoomActivity : LifecycleActivity(), View.OnLongClickListener {

    private var viewModel: BorrowedListViewModel? = null
    private var recyclerViewAdapter: AppAdapter? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)
        recyclerViewAdapter = AppAdapter(ArrayList<BorrowModel>(), this)
//        addBtn.setOnClickListener ({ view -> startActivity(Intent(RoomActivity@ this, AddActivity::class.java))})
        recyclerView = findViewById(R.id.recyclerView) as? RecyclerView
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = recyclerViewAdapter
        viewModel = ViewModelProviders.of(this).get(BorrowedListViewModel::class.java)
        viewModel!!.itemAndPersonList.observe(this@RoomActivity, Observer<List<BorrowModel>> { itemAndPeople -> recyclerViewAdapter!!.addItem(itemAndPeople!!) })
    }

    override fun onLongClick(v: View): Boolean {
        val borrowModel = v.tag as BorrowModel
        viewModel!!.deleteItem(borrowModel)
        return true
    }
}