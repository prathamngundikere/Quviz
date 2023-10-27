/*package com.prathamngundikere.quviz

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.prathamngundikere.quviz.databinding.ActivityFoundationBinding
import com.prathamngundikere.quviz.util.profilePictureUrl
import com.prathamngundikere.quviz.util.userName

class foundation : AppCompatActivity() {
    private lateinit var binding: ActivityFoundationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoundationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val homefragment = Home()
        val searchfragment = Search()
        val profilefragment = Profile()
        profilePictureUrl = intent.getStringExtra("PROFILE_PICTURE")
        userName = intent.getStringExtra("USER_NAME")
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragment,homefragment)
            commit()
        }
        binding.bnv.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home_btn -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flfragment,homefragment)
                        commit()
                    }
                }
                R.id.search_btn -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flfragment,searchfragment)
                        commit()
                    }
                }
                R.id.prfile_btn -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flfragment,profilefragment)
                        commit()
                    }
                }
                else ->{
                }
            }
            true
        }
    }

    companion object {
        fun finish() {
            finish()
        }
    }
}*/
package com.prathamngundikere.quviz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.prathamngundikere.quviz.databinding.ActivityFoundationBinding

class foundation : AppCompatActivity() {
    private lateinit var binding: ActivityFoundationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoundationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = Home()
        val searchFragment = Search()

        val profileFragment = Profile()
        val intent = intent

        val profilePictureUrl = intent.getStringExtra("PROFILE_PICTURE") ?: ""
        val userName = intent.getStringExtra("USER_NAME") ?: ""

        val args = Bundle()
        args.putString("PROFILE_PICTURE", profilePictureUrl)
        args.putString("USER_NAME", userName)
        profileFragment.arguments = args

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragment, homeFragment)
            commit()
        }

        binding.bnv.setOnItemSelectedListener {
            clearSelection(binding.bnv.menu)
            it.isChecked = true
            when (it.itemId) {
                R.id.home_btn -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flfragment, homeFragment)
                        commit()
                    }
                }
                R.id.search_btn -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flfragment, searchFragment)
                        commit()
                    }
                }
                R.id.prfile_btn -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flfragment, profileFragment)
                        commit()
                    }
                }
                else -> {
                    binding.bnv.menu.findItem(R.id.home_btn).isChecked = true
                }
            }
            true
        }
    }
    private fun clearSelection(menu: Menu) {
        for (i in 0 until menu.size()) {
            val menuItem = menu.getItem(i)
            menuItem.isChecked = false
        }
    }
}
