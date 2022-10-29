package mx.ipn.cic.gridviewexample.dummy

import mx.ipn.cic.gridviewexample.model.Contact

fun createDummyUsers(count: Int): List<Contact> {

    val listaContactos = mutableListOf<Contact>()

    for (i in 0 until count) {

        val contacto = Contact(
            "Name $i",
            "Lastname $i",
            "Phone Number: 123456789$i",
            "Email $i",
            "Nickname: $i"
        )
        listaContactos.add(contacto)
    }

    return listaContactos
}