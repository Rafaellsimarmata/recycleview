package com.example.recyclereview
import android.util.Log
import android.view.LayoutInflater
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListFacultyAdapter(private val listFaculty: ArrayList<Faculty>): RecyclerView.Adapter<ListFacultyAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_data, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listFaculty.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listFaculty[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        Log.d("name", name)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listFaculty[holder.adapterPosition])
//            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
//            intentDetail.putExtra(KEY_FACULTY, listFaculty[holder.adapterPosition])
//            holder.itemView.context.startActivity(intentDetail)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Faculty)
    }

}