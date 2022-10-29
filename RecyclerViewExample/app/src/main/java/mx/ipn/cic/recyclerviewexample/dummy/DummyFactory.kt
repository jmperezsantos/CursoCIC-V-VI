package mx.ipn.cic.recyclerviewexample.dummy

import mx.ipn.cic.recyclerviewexample.model.Contact

fun createDummyContacts(count: Int): List<Contact> {

    val contactsList = mutableListOf<Contact>()

    for (i in 0 until count) {

        contactsList.add(
            Contact(
                "Name $i",
                "Lastname $i",
                "Email $i",
                "Nickname $i"
            )
        )
    }

    return contactsList

}