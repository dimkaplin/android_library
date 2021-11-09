package com.example.lessononerx.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.example.lessononerx.R
import com.example.lessononerx.databinding.ActivityClubBinding
import com.example.lessononerx.domain.City
import com.example.lessononerx.domain.UserProfile
import com.example.lessononerx.domain.UserStorage
import com.example.lessononerx.impl.UserRoomStorageImpl
import com.google.android.material.snackbar.Snackbar
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class ClubActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClubBinding
    //private var currentDisposable: Disposable? = null
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    /*set(value) {
        field?.takeIf { !it.isDisposed }?.dispose()
        field = value
    }*/
    companion object {
       val USER_NAME = "name of user"
        private val listUserProfile: UserStorage = UserRoomStorageImpl()
        fun createLaunchIntent(context:Context, userLogin: String, userProfile:UserProfile): Intent {
            val intent = Intent(context, ClubActivity::class.java)
            if (userLogin != "") {
                intent.putExtra(ClubActivity.USER_NAME, userLogin)
            }
            listUserProfile.saveUser(userProfile)
            return intent;
        }
        fun createLaunchIntent(context:Context): Intent {
            return createLaunchIntent(context, "", UserProfile("test",0, 0, City("city"),"","", "", ""))
        }
        fun getUserStorage() : UserStorage {
            return listUserProfile
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityClubBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_club)
        compositeDisposable.add(
            getUserStorage().users
                //.subscribeOn()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                //Snackbar.make(binding.root, getString(R.string.after_add_user_message), Snackbar.LENGTH_SHORT).show()
                Toast.makeText(applicationContext, getString(R.string.after_add_user_message), Toast.LENGTH_SHORT).show()
                /*Handler(Looper.getMainLooper()).post {
                    Toast.makeText(applicationContext, getString(R.string.after_add_user_message), Toast.LENGTH_SHORT).show()
                }*/
                //runOnUiThread {  }
            }
        )
        /*currentDisposable = getUserStorage().users.subscribe{
            Snackbar.make(binding.root, getString(R.string.after_add_user_message), Snackbar.LENGTH_SHORT).show()
        }*/
    }

    override fun onDestroy() {
        //currentDisposable?.dispose()
        compositeDisposable.dispose()
        super.onDestroy()
    }
}