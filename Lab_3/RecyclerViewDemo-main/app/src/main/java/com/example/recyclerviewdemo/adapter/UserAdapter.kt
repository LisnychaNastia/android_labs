package com.example.recyclerviewdemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.R
import com.example.recyclerviewdemo.model.User
import kotlinx.android.synthetic.main.item_user_layout.view.*

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var userList = emptyList<User>()

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemView.tv_last_name.text = userList[position].lastName
        holder.itemView.tv_first_name.text = userList[position].firstName
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setList(list : List<User>){
        userList = list
        notifyDataSetChanged()
    }
}