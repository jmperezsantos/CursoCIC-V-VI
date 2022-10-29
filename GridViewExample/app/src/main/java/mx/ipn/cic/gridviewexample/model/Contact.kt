package mx.ipn.cic.gridviewexample.model

class Contact(
    var name: String,
    var lastname: String,
    var phoneNumber: String,
    var email: String,
    var nickname: String
) {
    override fun toString(): String {
        return "Contact(name='$name', lastname='$lastname', phoneNumber='$phoneNumber', email='$email', nickname='$nickname')"
    }
}