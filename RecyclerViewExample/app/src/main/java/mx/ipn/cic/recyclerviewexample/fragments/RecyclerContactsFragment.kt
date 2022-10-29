package mx.ipn.cic.recyclerviewexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
import com.google.android.material.snackbar.Snackbar
import mx.ipn.cic.recyclerviewexample.R
import mx.ipn.cic.recyclerviewexample.adapters.ContactsAdapter
import mx.ipn.cic.recyclerviewexample.dummy.createDummyContacts

class RecyclerContactsFragment : Fragment() {

    private lateinit var contactsRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_contacts, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        this.contactsRecycler = view.findViewById(R.id.rvContactos)

        //Se especifica el "tipo" de colección a mostrar
        //LISTA:
        // this.contactsRecycler.layoutManager = LinearLayoutManager(this.context)

        //CUADRICULA:
        this.contactsRecycler.layoutManager = GridLayoutManager(
            this.context,
            3
        )

        val adapter = ContactsAdapter(createDummyContacts(20)) { contacto ->

            Snackbar.make(
                this.requireView(),
                "Contacto Seleccinado: $contacto",
                Snackbar.LENGTH_LONG
            ).show()

        }

        this.contactsRecycler.adapter = adapter


    }

    companion object {
        @JvmStatic
        fun newInstance() =
            RecyclerContactsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}