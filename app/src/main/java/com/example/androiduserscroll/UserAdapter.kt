package com.example.androiduserscroll

import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.net.URL

class UserAdapter(private val userList: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.profileImageView)
        val textView: TextView = itemView.findViewById(R.id.userName)
        val button: Button = itemView.findViewById(R.id.userButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_user, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.textView.text = "${currentItem.firstName} ${currentItem.lastName}"
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.button.setOnClickListener {
        }
    }

    override fun getItemCount() = userList.size

    private fun loadImageFromUrl(url: String, imageView: ImageView) {
        AsyncTask.execute {
            try {
                val conn = URL(url).openConnection()
                conn.connect()
                val bitmap = BitmapFactory.decodeStream(conn.getInputStream())
                imageView.post {
                    imageView.setImageBitmap(bitmap)
                }
            } catch (ex: Exception) {
            }
        }
    }
}