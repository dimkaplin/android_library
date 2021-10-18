package com.example.lessononerx.ui


import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.core.os.postDelayed
import com.example.lessononerx.domain.ActionForm
import com.example.lessononerx.domain.UserProfile
import com.example.lessononerx.domain.UserStorage
import com.example.lessononerx.domain.ViewState
import com.example.lessononerx.impl.UserRoomStorageImpl

private const val MOCK_DESPLAYED_DURATION = 3000L

class UserProfilePresenter(private val userStorage:UserStorage): UserProfileContract.Presenter {
    private var view: UserProfileContract.View? =null

    private var userTMP: UserProfile? = null

    override fun onSave(user: UserProfile, action: ActionForm) {
        view?.setState(ViewState.LOADING)
        when(action) {
            ActionForm.REGISTER -> {
                Handler(Looper.getMainLooper()).postDelayed(MOCK_DESPLAYED_DURATION) {
                    view?.setState(ViewState.ERROR)
                }
            }
            ActionForm.FORGET -> {
                 view?.showText("forget message")
            }
            ActionForm.ENTER -> {
                 view?.showText("enter message")
            }
        }

    }

    override fun onEnter() {
        view?.setOnEnterUnderline()
    }

    override fun onForget() {
        view?.setOnForgetUnderline()
    }

    override fun onRegistration() {
        view?.setOnRegistrationUnderline()
    }

    override fun onAttach(view: UserProfileContract.View) {
        this.view = view
        view?.setState(ViewState.IDLE)
        userTMP?.let {
            view.setUser(it)
        }
    }

    override fun onDetach() {
        view = null
    }

    override fun onChangeCity(city: String) {
        view?.setCityError(0)
    }

}