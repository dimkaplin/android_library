package com.example.lessononerx.ui

import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.example.lessononerx.R
import com.example.lessononerx.databinding.ActivityUserProfileBinding
import com.example.lessononerx.domain.ActionForm
import com.example.lessononerx.domain.City
import com.example.lessononerx.domain.UserProfile
import com.example.lessononerx.domain.ViewState
import com.example.lessononerx.impl.UserRoomStorageImpl
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat

class UserProfileActivity : AppCompatActivity(), UserProfileContract.View {
    private lateinit var binding: ActivityUserProfileBinding
    private lateinit var currentAction: ActionForm
    private var presenter: UserProfileContract.Presenter = UserProfilePresenter(UserRoomStorageImpl())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.onAttach(this)
        initView()
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun showText(text: String) {
        Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
    }

    private fun initView() {
        binding.saveButton.setOnClickListener {
            presenter.onSave(getCurrentUser(), currentAction)
        }
        binding.enterButton.setOnClickListener{
            presenter.onEnter()
        }
        binding.forgetButton.setOnClickListener{
            presenter.onForget()
        }
        binding.registrationButton.setOnClickListener{
            presenter.onRegistration()
        }
        binding.cityTextView.addTextChangedListener{
            presenter.onChangeCity(binding.cityTextView.text.toString())
        }
    }

    private fun getCurrentUser():UserProfile {
        return UserProfile(
            binding.fioTextView.text.toString(),
            binding.ageTextView.text.toString().toIntOrNull(),
            0,
            City(binding.cityTextView.text.toString()),
            "",
            binding.loginTextView.text.toString(),
            binding.passwordTextView.text.toString(),
            binding.emailTextView.text.toString()

        )
    }

    override fun setState(state: ViewState) {
        binding.progressBarView.isVisible = false
        binding.contentLayout.isVisible = false
        binding.successImageView.isVisible = false
        when(state){
            ViewState.LOADING -> {
                binding.progressBarView.isVisible = true
            }
            ViewState.IDLE -> {
                binding.contentLayout.isVisible = true
            }
            ViewState.ERROR -> {
                binding.contentLayout.isVisible = true
                Snackbar.make(binding.root, getString(R.string.error_snack_text), Snackbar.LENGTH_SHORT).show()
            }
            ViewState.SUCCESS -> {
                binding.successImageView.isVisible = true
            }
        }
    }

    override fun setUser(user: UserProfile) {
        binding.fioTextView.setText(user.FIO)
        binding.cityTextView.setText(user.city.name)
        user.age?.let { binding.ageTextView.setText(it) }
    }

    override fun setCityError(errorCode: Int) {
        binding.cityTextView.setError(getErrorStringByCode(errorCode))
    }

    private fun getErrorStringByCode(errorCode: Int): String {
        return R.string.error_city_message.toString()
    }

    private fun breakSizeText() {
        binding.enterButton.getPaint().textSize = 35F
        binding.forgetButton.getPaint().textSize = 35F
        binding.registrationButton.getPaint().textSize = 35F
    }

    override fun setOnEnterUnderline() {
        currentAction = ActionForm.ENTER
        binding.enterButton.getPaint().textSize = 50F
        binding.forgetButton.getPaint().textSize = 35F
        binding.registrationButton.getPaint().textSize = 35F
        binding.titleTextView.setText(binding.enterButton.text)
        binding.ageTextField.setVisibility(View.GONE)
        binding.fioTextField.setVisibility(View.GONE)
        binding.cityTextField.setVisibility(View.GONE)
        binding.emailTextField.setVisibility(View.GONE)
        binding.loginTextField.setVisibility(View.VISIBLE)
        binding.passwordTextField.setVisibility(View.VISIBLE)
        binding.saveButton.setText(R.string.enter_title_action)
    }

    override fun setOnForgetUnderline() {
        breakSizeText()
        currentAction = ActionForm.FORGET
        binding.forgetButton.getPaint().textSize = 50F
        binding.titleTextView.setText(binding.forgetButton.text)
        binding.ageTextField.setVisibility(View.GONE)
        binding.fioTextField.setVisibility(View.GONE)
        binding.cityTextField.setVisibility(View.GONE)
        binding.loginTextField.setVisibility(View.GONE)
        binding.passwordTextField.setVisibility(View.GONE)
        binding.emailTextField.setVisibility(View.VISIBLE)
        binding.saveButton.setText(R.string.forget_title_action)
    }

    override fun setOnRegistrationUnderline() {
        breakSizeText()
        currentAction = ActionForm.REGISTER
        binding.registrationButton.getPaint().textSize = 50F
        binding.titleTextView.setText(binding.registrationButton.text)
        binding.ageTextField.setVisibility(View.VISIBLE)
        binding.fioTextField.setVisibility(View.VISIBLE)
        binding.cityTextField.setVisibility(View.VISIBLE)
        binding.loginTextField.setVisibility(View.VISIBLE)
        binding.passwordTextField.setVisibility(View.VISIBLE)
        binding.emailTextField.setVisibility(View.VISIBLE)
        binding.saveButton.setText(R.string.registration_title_action)
    }
}