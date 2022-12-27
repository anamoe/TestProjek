package app.cansol.test.AppData

import app.cansol.test.Interface.ResultListener
import app.cansol.test.Model.User

/**
 * it contains dummy users
 * findUser() performs search against provided credentials
 **/
object UserData {

    val users: ArrayList<User> = ArrayList()

    var currentUser: User? = null
    fun initUsers() {
        users.add(User("1", "John", "John@gmail.com", "eve.holt@reqres.in", "cityslicka"))
        users.add(User("2", "Mike", "mike@gmail.com", "03482521111", "thisisMike"))
        users.add(User("3", "alex", "alex@gmail.com", "03482523333", "thisisAlex"))
    }

    fun findUser(phoneNumber: String, password: String, listener: ResultListener){

            for (user in users) {
                if (user.phoneNumber == phoneNumber) {
                    if (user.password == password) {
                        currentUser = user
                        listener.onSuccess("Success")
                        return
                    } else {
                        listener.onFailure("Number/Password is wrong!")
                        return
                    }
                }
            }
            listener.onFailure("Account doesn't exist!")
        }


}