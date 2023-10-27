/*package com.prathamngundikere.quviz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class LoginScreen : AppCompatActivity() {
    private val RC_SIGN_IN = 123 // Request code for Google Sign-In
    private lateinit var  signInButton: SignInButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        signInButton = findViewById(R.id.SignINbutton)

        // Configure Google Sign-In options
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(this, gso)
        val account = GoogleSignIn.getLastSignedInAccount(this)
        if (account != null) {
            // User is already signed in, navigate to the profile screen
            startProfileScreen(account)
        }
        val firebaseAuth = FirebaseAuth.getInstance()

        signInButton.setOnClickListener {
            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }
    }

    private fun startProfileScreen(account: GoogleSignInAccount) {
        val intent = Intent(this, ProfileScreen::class.java)
        intent.putExtra("PROFILE_PICTURE", account.photoUrl.toString())
        intent.putExtra("USER_NAME", account.displayName ?: "")
        startActivity(intent)
        finish() // Optional: Close the login screen
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign-In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)
                val credential = GoogleAuthProvider.getCredential(account?.idToken, null)
                FirebaseAuth.getInstance().signInWithCredential(credential)
                    .addOnCompleteListener(this) { authTask ->
                        if (authTask.isSuccessful) {
                            val account = task.getResult(ApiException::class.java)
                            val profilePictureUrl = account?.photoUrl.toString()
                            val userName = account?.displayName ?: ""

                            val intent = Intent(this, foundation::class.java)
                            intent.putExtra("PROFILE_PICTURE", profilePictureUrl)
                            intent.putExtra("USER_NAME", userName)
                            startActivity(intent)
                            Toast.makeText(this, "Signed In", Toast.LENGTH_SHORT).show()
                            // Sign-in success, update UI or navigate to the next screen
                        } else {
                            Toast.makeText(this, "Sign In Failed", Toast.LENGTH_SHORT).show()
                            // Sign-in failed, display a message to the user
                        }
                    }
            } catch (e: ApiException) {
                val intents = Intent(this,foundation::class.java)
                startActivity(intents)
                finish()
                // Google Sign-In failed, handle error
            }
        }
    }
}*/
package com.prathamngundikere.quviz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.SignInButton.ButtonSize
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.prathamngundikere.quviz.util.profilePictureUrl
import com.prathamngundikere.quviz.util.userName

class LoginScreen : AppCompatActivity() {
    private val RC_SIGN_IN = 123 // Request code for Google Sign-In
    private lateinit var signInButton: SignInButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

       signInButton = findViewById(R.id.SignINbutton)

        // Configure Google Sign-In options
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(this, gso)
        val account = GoogleSignIn.getLastSignedInAccount(this)

        signInButton.setOnClickListener {
            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

        if (account != null) {
            // User is already signed in, navigate to the profile screen
            startProfileScreen(account)
        }
    }

    private fun startProfileScreen(account: GoogleSignInAccount) {
        // In your LoginScreen activity
        profilePictureUrl = account?.photoUrl?.toString()
        userName = account?.displayName ?: ""

        val intent = Intent(this, foundation::class.java)
        intent.putExtra("PROFILE_PICTURE", account.photoUrl?.toString() ?: "")
        intent.putExtra("USER_NAME", account.displayName ?: "")
        startActivity(intent)
        finish() // Optional: Close the login screen
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                val credential = GoogleAuthProvider.getCredential(account?.idToken, null)
                FirebaseAuth.getInstance().signInWithCredential(credential)
                    .addOnCompleteListener(this) { authTask ->
                        if (authTask.isSuccessful) {
                            startProfileScreen(account)
                            Toast.makeText(this, "Signed In", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Sign In Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
            } catch (e: ApiException) {
                // Google Sign-In failed, handle error
                val intent = Intent(this, LoginScreen::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
