package com.example.lessononerx.ui

import com.example.lessononerx.domain.ActionForm
import com.example.lessononerx.domain.UserProfile
import com.example.lessononerx.domain.ViewState

class UserProfileContract {
    interface View {
      fun setState(state: ViewState)
      fun setUser(user: UserProfile)
      fun setCityError(errorCode: Int)
      fun setOnEnterUnderline()
      fun setOnForgetUnderline()
      fun setOnRegistrationUnderline()
      fun showText(text: String)
    }

    interface Presenter{
       fun onSave(user: UserProfile, action: ActionForm)
       fun onEnter()
       fun onForget()
       fun onRegistration()
       fun onAttach(view: View)
       fun onDetach()
       fun onChangeCity(city: String)
    }
}