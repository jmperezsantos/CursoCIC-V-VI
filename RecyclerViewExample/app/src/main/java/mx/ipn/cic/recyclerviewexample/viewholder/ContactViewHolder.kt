package mx.ipn.cic.recyclerviewexample.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.ipn.cic.recyclerviewexample.R
import mx.ipn.cic.recyclerviewexample.model.Contact

class ContactViewHolder(
    view: View,
    //val onItemClick: (Contact) -> Unit
) : RecyclerView.ViewHolder(view) {

    /*private lateinit var currentContact: Contact

    //Configuración del objeto
    init {
        view.setOnClickListener {
            onItemClick(this.currentContact)
        }
    }*/

    private val tvName: TextView = view.findViewById(R.id.tvName)
    private val tvLastname: TextView = view.findViewById(R.id.tvLastname)

    //Método para configurar el item del recyclerview
    fun bind(contacto: Contact) {

        //this.currentContact = contacto

        this.tvName.text = contacto.name
        this.tvLastname.text = contacto.nickname

    }

}