package mx.ipn.cic.listviewexample.model

class Person(
    var name: String,
    var lastname: String,
    var age: Int,
    var curp: String
) {

    companion object {
        fun createUserList(count: Int): List<Person> {

            val personList = mutableListOf<Person>()

            //Ciclo desde cero al "count" (longitud)
            for (i in 0 until count) {
                //Se crea una instancia del elemento "Person"
                val person = Person(
                    "Name $i",
                    "Lastname $i",
                    (i + i),
                    "CURP $i"
                )

                //Se agrega la instancia a la lista de personas.
                personList.add(person)
            }
            return personList
        }
    }

    override fun toString(): String {
        return "Person(name='$name', lastname='$lastname', age=$age, curp='$curp')"
    }

}