package com.example.lessononerx.ui

import com.example.lessononerx.domain.ActionForm
import com.example.lessononerx.domain.UserProfile
import com.example.lessononerx.domain.ViewState
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

class UserProfileContract {
    interface View: MvpView {
        @AddToEndSingle
      fun setState(state: ViewState)
        @AddToEndSingle
      fun setUser(user: UserProfile)
        @AddToEndSingle
      fun setCityError(errorCode: Int)
        @AddToEndSingle
      fun setOnEnterUnderline()
        @AddToEndSingle
      fun setOnForgetUnderline()
        @AddToEndSingle
      fun setOnRegistrationUnderline()
        @AddToEndSingle
      fun showText(text: String)
        //moxy methods
        @Skip
      fun exit()
        @Skip
      fun openSecondScreen()

    }

    abstract class Presenter: MvpPresenter<View>() {
       abstract fun onSave(user: UserProfile, action: ActionForm)
       abstract fun onEnter()
       abstract fun onForget()
       abstract fun onRegistration()
      // abstract fun onAttach(view: View)
      // abstract fun onDetach()
       abstract fun onChangeCity(city: String)
    }
}