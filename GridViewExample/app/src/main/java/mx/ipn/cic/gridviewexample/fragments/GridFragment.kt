package mx.ipn.cic.gridviewexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import mx.ipn.cic.gridviewexample.R
import mx.ipn.cic.gridviewexample.adapters.ContactGridAdapter
import mx.ipn.cic.gridviewexample.dummy.createDummyUsers
import mx.ipn.cic.gridviewexample.model.Contact

class GridFragment : Fragment() {

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
            R.layout.fragment_grid,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        val contactList = createDummyUsers(30)
        val gridContactos = view.findViewById<GridView>(R.id.gvContactos)
        gridContactos.adapter = ContactGridAdapter(contactList)
        gridContactos.numColumns = 3

        gridContactos.setOnItemClickListener { parent, view, position, id ->

            val adapter = parent.adapter
            val contacto: Contact = adapter.getItem(position) as Contact

            /*Toast.makeText(
                this.context,
                "${contacto.name} ${contacto.lastname}",
                Toast.LENGTH_LONG
            ).show()*/

            Snackbar.make(
                this.requireView(),
                "${contacto.name} ${contacto.lastname}",
                Snackbar.LENGTH_LONG
            ).show()

        }

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            GridFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}