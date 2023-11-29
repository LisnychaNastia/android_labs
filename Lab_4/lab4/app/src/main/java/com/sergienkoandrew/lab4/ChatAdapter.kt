package com.sergienkoandrew.lab4

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sergienkoandrew.lab4.model.Chat

class ChatAdapter(private var items: List<Chat>):
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(newItems: List<Chat>){
        items = newItems
        this.notifyDataSetChanged()
    }

    inner class ChatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val chatAvatar = itemView.findViewById<ImageView>(R.id.chat_avatar)
        private val chatName = itemView.findViewById<TextView>(R.id.chat_name)
        private val chatLastMessage = itemView.findViewById<TextView>(R.id.chat_lastMessage)
        private val chatLastMessageTime = itemView.findViewById<TextView>(R.id.chat_lastMessageTime)
        private val chatReadStatus = itemView.findViewById<ImageView>(R.id.chat_readStatus)

        fun bind(chatModel: Chat){
            chatName.text = chatModel.name
            chatLastMessage.text = chatModel.lastMessage
            chatLastMessageTime.text = chatModel.lastMessageTime
            chatModel.avatarIndex?.let { chatAvatar.setImageResource(it) }

            val isReadIcon = if (chatModel.isRead){
                R.drawable.read_icon
            } else {
                R.drawable.unread_icon
            }
            chatReadStatus.setImageResource(isReadIcon)
        }
    }
}