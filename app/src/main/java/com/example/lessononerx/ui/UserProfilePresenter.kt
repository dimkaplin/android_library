package com.example.lessononerx.ui


import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.core.os.postDelayed
import com.example.lessononerx.Screens
import com.example.lessononerx.domain.ActionForm
import com.example.lessononerx.domain.UserProfile
import com.example.lessononerx.domain.UserStorage
import com.example.lessononerx.domain.ViewState
import com.example.lessononerx.impl.UserRoomStorageImpl
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen

private const val MOCK_DESPLAYED_DURATION = 3000L

class UserProfilePresenter(
                 private val userStorage:UserStorage
                ,private val router: Router
 ): UserProfileContract.Presenter() {
    //private var view: UserProfileContract.View? =null

    private var userTMP: UserProfile? = null

    override fun onSave(user: UserProfile, action: ActionForm) {
        viewState.setState(ViewState.LOADING)
        when(action) {
            ActionForm.REGISTER -> {
                Handler(Looper.getMainLooper()).postDelayed(MOCK_DESPLAYED_DURATION) {
                    //viewState.setState(ViewState.ERROR)
                    viewState.setState(ViewState.SUCCESS)
                    viewState.openSecondScreen()
                    //viewState.exit() // with moxy
                    router.exit() // with cicerone
                    router.navigateTo(Screens.Main())

                }
            }
            ActionForm.FORGET -> {
                 viewState.showText("forget message")
            }
            ActionForm.ENTER -> {
                 viewState.showText("enter message")
            }
        }

    }

    override fun onEnter() {
        viewState.setOnEnterUnderline()
    }

    override fun onForget() {
        viewState.setOnForgetUnderline()
    }

    override fun onRegistration() {
        viewState.setOnRegistrationUnderline()
    }

    /*override fun onAttach(view: UserProfileContract.View) {
        this.view = view
        view?.setState(ViewState.IDLE)
        userTMP?.let {
            view.setUser(it)
        }
    }

    override fun onDetach() {
        view = null
    }*/

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setState(ViewState.IDLE)
    }


    override fun onChangeCity(city: String) {
        viewState.setCityError(0)
    }

}