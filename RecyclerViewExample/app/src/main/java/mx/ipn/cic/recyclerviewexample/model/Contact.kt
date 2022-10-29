package mx.ipn.cic.recyclerviewexample.model

class Contact(
    var name: String,
    var lastname: String,
    var email: String,
    var nickname: String
) {

    override fun toString(): String {
        return "Contact(name='$name', lastname='$lastname', email='$email', nickname='$nickname')"
    }
}