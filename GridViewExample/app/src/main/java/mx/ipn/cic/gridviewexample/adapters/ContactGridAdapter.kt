package mx.ipn.cic.gridviewexample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import mx.ipn.cic.gridviewexample.R
import mx.ipn.cic.gridviewexample.model.Contact

class ContactGridAdapter(
    //DataSource
    val contactList: List<Contact>
) : BaseAdapter() {

    override fun getCount(): Int {
        return this.contactList.size
    }

    override fun getItem(position: Int): Contact {
        return this.contactList[position]
    }

    override fun getItemId(position: Int): Long {
        return this.getItem(position).hashCode().toLong()
    }

    override fun getView(
        position: Int,
        reusableView: View?,
        parent: ViewGroup?
    ): View {

        var gridItem = reusableView
        if (gridItem == null) {
            // es la primera vez que se crea un item para la posicion dada
            val context = parent!!.context
            val inflador = LayoutInflater.from(context)

            gridItem = inflador.inflate(
                R.layout.gridview_person_item,
                parent,
                false
            )
        }

        val contact = this.getItem(position)

        val tvName: TextView = gridItem!!.findViewById(R.id.tvName)
        val tvLastname: TextView = gridItem.findViewById(R.id.tvLastname)

        tvName.text = contact.name
        tvLastname.text = contact.nickname

        return gridItem!!
    }
}