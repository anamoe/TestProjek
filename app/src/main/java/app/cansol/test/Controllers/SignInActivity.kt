package app.cansol.test.Controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import app.cansol.test.AppData.UserData
import app.cansol.test.Interface.ResultListener
import app.cansol.test.Network.Network
import app.cansol.test.R

class SignInActivity : AppCompatActivity(), ResultListener {

    /**
     initialize hardcoded users in oncreate method**/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        UserData.initUsers()
    }

    /**
    it simply call the method from for searching user against provided credentials
     **/
    fun signIn(view: View) {
        val number = findViewById<EditText>(R.id.edTxtSignInPhoneNumber).text
        val password = findViewById<EditText>(R.id.edTxtSignInPassword).text

        if (number.trim().isNotEmpty() && password.isNotEmpty()) {
            if (Network.checkNetwork(this)) {
                UserData.findUser(number.toString(), password.toString(), this)
            } else Toast.makeText(this, "Check network connection", Toast.LENGTH_SHORT).show()
        } else Toast.makeText(this, "Field(s) is empty!", Toast.LENGTH_SHORT).show()

    }

    /**
     following both are Interface method implementation
     **/
    override fun onSuccess(message: String) {
        app.cansol.test.AppData.AppData(this).userId = UserData.currentUser!!.id
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    override fun onFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
