package com.example.lessononerx.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lessononerx.R
import com.example.lessononerx.databinding.ActivityClubBinding
import com.example.lessononerx.domain.UserProfile

class ClubActivity : AppCompatActivity() {
    companion object {
       val USER_NAME = "name of user"
        fun createLaunchIntent(context:Context, userLogin: String): Intent {
            val intent = Intent(context, ClubActivity::class.java)
            if (userLogin != "") {
                intent.putExtra(ClubActivity.USER_NAME, userLogin)
            }
            return intent;
        }
        fun createLaunchIntent(context:Context): Intent {
            return createLaunchIntent(context, "")
        }
    }
    private lateinit var binding: ActivityClubBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityClubBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_club)
    }
}