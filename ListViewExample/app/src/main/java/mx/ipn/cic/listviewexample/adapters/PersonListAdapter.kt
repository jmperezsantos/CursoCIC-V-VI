package mx.ipn.cic.listviewexample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import mx.ipn.cic.listviewexample.R
import mx.ipn.cic.listviewexample.model.Person

class PersonListAdapter(
    val personList: List<Person>
) : BaseAdapter() {

    //Retorna el # de elementos a mostrar
    override fun getCount(): Int {
        return this.personList.size
    }

    //Retorna el elemento en la posición dada
    override fun getItem(position: Int): Person {
        return this.personList[position]
    }

    //Retorna el ID del elemento en la posición dada
    override fun getItemId(position: Int): Long {
        return this.getItem(position).hashCode().toLong()
    }

    override fun getView(
        position: Int,
        reusableView: View?,
        container: ViewGroup?
    ): View {

        var listItem = reusableView
        if (listItem == null) {
            val context = container!!.context
            val inflater = LayoutInflater.from(context)

            listItem = inflater.inflate(
                R.layout.person_list_item,
                container,
                false
            )
        }

        val person = this.getItem(position)

        val tvName = listItem!!.findViewById<TextView>(R.id.tvName)
        val tvLastname: TextView = listItem!!.findViewById(R.id.tvLastname)

        tvName.text = person.name
        tvLastname.text = person.lastname

        return listItem!!

    }
}