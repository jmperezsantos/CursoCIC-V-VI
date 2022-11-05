package mx.ipn.cic.recyclerviewexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mx.ipn.cic.recyclerviewexample.R
import mx.ipn.cic.recyclerviewexample.model.Contact
import mx.ipn.cic.recyclerviewexample.viewholder.ContactViewHolder

class ContactsAdapter(
    val contactList: List<Contact>,
    val onItemClick: (Contact) -> Unit
) : RecyclerView.Adapter<ContactViewHolder>() {

    override fun getItemCount(): Int {
        return this.contactList.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactViewHolder {

        //Por medio de un inflater se crea la instancia de una
        //Nueva vista (items)
        val inflater = LayoutInflater.from(parent.context)
        val cardView = inflater.inflate(
            R.layout.contact_list_item,
            parent,
            false
        )

        return ContactViewHolder(cardView)

    }

    fun getItem(position: Int): Contact {
        return this.contactList[position]
    }

    override fun onBindViewHolder(
        viewHolder: ContactViewHolder,
        position: Int
    ) {

        //Actualizar la información mostrada por el ViewHolder
        val contact = this.getItem(position)
        viewHolder.bind(contact)

        viewHolder.itemView.setOnClickListener {
            onItemClick(contact)
        }

    }
}