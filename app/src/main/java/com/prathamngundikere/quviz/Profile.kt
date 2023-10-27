/*package com.prathamngundikere.quviz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.prathamngundikere.quviz.util.profilePictureUrl
import com.prathamngundikere.quviz.util.userName

class Profile : Fragment(R.layout.fragment_profile) {

    private lateinit var profileImageView: ImageView
    private lateinit var profileTextView: TextView
    private lateinit var signOutButton: Button
    private lateinit var gso: GoogleSignInOptions
    private lateinit var con: Context
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileImageView = view.findViewById(R.id.profile_imageView)
        profileTextView = view.findViewById(R.id.profile_textView)
        signOutButton = view.findViewById(R.id.SignOUTbutton)
        /*
        con = requireContext()
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
            FirebaseAuth.getInstance().signOut()
            googleSignInClient = GoogleSignIn.getClient(con,gso)
            googleSignInClient.signOut()
                val signInIntent = Intent(context, LoginScreen::class.java)
                startActivity(signInIntent)
                finish()
        }
*/
    }
}
*/
package com.prathamngundikere.quviz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.prathamngundikere.quviz.adapter.Profile_History_Adapter
import com.prathamngundikere.quviz.datamodel.userfirebase
import com.prathamngundikere.quviz.util.profilePictureUrl
import com.prathamngundikere.quviz.util.userName

class Profile : Fragment(R.layout.fragment_profile) {

    private lateinit var profileImageView: ImageView
    private lateinit var profileTextView: TextView
    private lateinit var ps_sore: TextView
    private lateinit var signOutButton: Button
    private lateinit var gso: GoogleSignInOptions
    private lateinit var con: Context
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var profile_rv: RecyclerView
    private lateinit var historylist: ArrayList<userfirebase>
    private lateinit var dbref: DatabaseReference
    private lateinit var UserID:String
    private lateinit var TotalScore:String
    private lateinit var context: Context
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileImageView = view.findViewById(R.id.profile_imageView)
        profileTextView = view.findViewById(R.id.profile_textView)
        signOutButton = view.findViewById(R.id.SignOUTbutton)
        ps_sore = view.findViewById(R.id.hs_score)
        profile_rv = view.findViewById(R.id.profile_rv)
        if (isAdded) {
            context = requireContext()
        }
        // Retrieve totalscore from SharedPreferences
        /*val sharedPreferences = requireContext().getSharedPreferences("QuizPreferences", Context.MODE_PRIVATE)
        val  totalscoreq = sharedPreferences.getInt("totalscore", 0)
        ps_sore.text = "${totalscoreq}⭐"*/
        if(isAdded) {
            con = requireContext()
        }

        // Load profile picture using Glide (add Glide dependency to your app-level build.gradle)
        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()

        Glide.with(this)
            .load(profilePictureUrl)
            .placeholder(R.drawable.account_circle_48px) // You can set a default image
            .error(R.drawable.account_circle_48px) // You can set an error image
            .into(profileImageView)

        profileTextView.text = userName

        signOutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            googleSignInClient = GoogleSignIn.getClient(con, gso)
            googleSignInClient.signOut()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        if(isAdded) {
                            val sharedPreferences = requireContext().getSharedPreferences(
                                "UserPreferences",
                                Context.MODE_PRIVATE
                            )
                            val edit = sharedPreferences.edit()
                            edit.putInt("UserTotalScores", 0)
                            edit.apply()
                        }
                        val signInIntent = Intent(context, LoginScreen::class.java)
                        startActivity(signInIntent)
                        activity?.finish()
                    } else {
                        // Handle sign-out error
                    }
                }
        }
        getuserhistory()
    }
    private fun getuserhistory() {
        historylist = arrayListOf<userfirebase>()
        val user = FirebaseAuth.getInstance().currentUser
        UserID = user?.uid.toString()
        dbref = FirebaseDatabase.getInstance().getReference("$UserID")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                historylist.clear()
                if(snapshot.exists()){
                    for (histroySanp in snapshot.children){
                        val userdata = histroySanp.getValue(userfirebase::class.java)
                        historylist.add(userdata!!)
                    }
                    val adapter = Profile_History_Adapter(historylist)
                    profile_rv.adapter = adapter
                    var totalscores = 0
                    for(i in 0 until  historylist.size){
                        val s = historylist[i]
                        totalscores += s.userscore!!.toInt()
                    }
                    if(isAdded) {
                        val sharedPreferences = requireContext().getSharedPreferences(
                            "UserPreferences",
                            Context.MODE_PRIVATE
                        )
                        val edit = sharedPreferences.edit()
                        edit.putInt("UserTotalScores", totalscores)
                        edit.apply()
                        ps_sore.text = "${totalscores}⭐"
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }
}

