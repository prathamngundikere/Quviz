package com.prathamngundikere.quviz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class ProfileScreen : AppCompatActivity() {
    private lateinit var gso: GoogleSignInOptions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)

        val profileImageView: ImageView = findViewById(R.id.profile_imageView)
        val profileTextView: TextView = findViewById(R.id.profile_textView)
        val signOutButton: Button = findViewById(R.id.SignOUTbutton)
        val homeButton: Button = findViewById(R.id.HOMEbutton2)

        val profilePictureUrl = intent.getStringExtra("PROFILE_PICTURE")
        val userName = intent.getStringExtra("USER_NAME")

        // Load profile picture using Glide (add Glide dependency to your app-level build.gradle)
        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        Glide.with(this)
            .load(profilePictureUrl)
            .placeholder(R.drawable.account_circle_48px) // You can set a default image
            .error(R.drawable.account_circle_48px) // You can set an error image
            .into(profileImageView)

        profileTextView.text = "$userName"
        signOutButton.setOnClickListener {
            // Sign out the user from Firebase Authentication
            FirebaseAuth.getInstance().signOut()

            // Sign out the user from Google Sign-In
            val googleSignInClient = GoogleSignIn.getClient(this, gso)
            googleSignInClient.signOut().addOnCompleteListener(this) {
                // After signing out, navigate to the login screen
                val signInIntent = Intent(this, LoginScreen::class.java)
                startActivity(signInIntent)
                finish() // Close the profile screen
            }
        }
    }
}
