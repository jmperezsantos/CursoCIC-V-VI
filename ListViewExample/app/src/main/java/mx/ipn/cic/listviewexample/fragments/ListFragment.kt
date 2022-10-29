package mx.ipn.cic.listviewexample.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import mx.ipn.cic.listviewexample.R
import mx.ipn.cic.listviewexample.adapters.PersonListAdapter
import mx.ipn.cic.listviewexample.model.Person

class ListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_list,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaUsuarios = Person.createUserList(20)
        val adapter = PersonListAdapter(listaUsuarios)

        val listView = view.findViewById<ListView>(R.id.lvPeople)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->

            val adapter = listView.adapter as PersonListAdapter
            val persona = adapter.getItem(position)

            Log.d("MPS", "Item Seleccionado: $persona")

        }

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ListFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}