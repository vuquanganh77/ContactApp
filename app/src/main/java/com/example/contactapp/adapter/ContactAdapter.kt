package com.example.contactapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.ContactActivity
import com.example.contactapp.R
import com.example.contactapp.model.Contact

class ContactAdapter(private var dataset: List<Contact>) :
    RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount() = dataset.size;

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.avatar.text = item.name[0].toString()
        holder.name.text = item.name
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ContactActivity::class.java)
            intent.putExtra("detail_name", item.name)
            intent.putExtra("detail_phone_number", item.phone)
            intent.putExtra("detail_mail", item.email)
            holder.itemView.context.startActivity(intent)
        }

        holder.itemView.setOnLongClickListener {
            showPopupMenu(holder.itemView, item)
            true
        }
    }
    private fun showPopupMenu(view: View, item: Contact) {
        val popupMenu = PopupMenu(view.context, view)
        val inflater: MenuInflater = popupMenu.menuInflater
        inflater.inflate(R.menu.contact_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_call -> {
                    Toast.makeText(view.context, "Calling ${item.name}", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_send_email -> {
                    Toast.makeText(view.context, "Send email to ${item.name}", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_send_message -> {
                    Toast.makeText(view.context, "Send message to ${item.name}", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }

}
class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    val avatar = view.findViewById<TextView>(R.id.avatar)
    val name = view.findViewById<TextView>(R.id.name)
}