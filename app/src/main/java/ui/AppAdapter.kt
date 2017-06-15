package ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import data.BorrowModel
import kotlinx.android.synthetic.main.item.view.*
import test.com.componentapp.R

class AppAdapter(private var borrowModelList: List<BorrowModel>, private val longClickListener: View.OnLongClickListener) : RecyclerView.Adapter<AppAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AppAdapter.ViewHolder, position: Int) {
        holder.bindItems(borrowModelList[position])
    }

    override fun getItemCount(): Int {
        return borrowModelList.size
    }

    fun addItem(borrowModelList: List<BorrowModel>) {
        this.borrowModelList = borrowModelList;
        notifyDataSetChanged();
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(borrowModel: BorrowModel) {
            itemView.itemTextView.text = borrowModel.itemName
            itemView.nameTextView.text = borrowModel.personName
            itemView.dateTextView.text = borrowModel.borrowDate.toLocaleString().substring(0, 11)
            itemView.setTag(borrowModel)
            itemView.setOnLongClickListener(longClickListener)

        }
    }
}