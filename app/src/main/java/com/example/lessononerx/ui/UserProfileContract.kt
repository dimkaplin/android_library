package com.example.lessononerx.ui

class UserProfileContract {
    interface View {
      fun setState()
    }

    interface Presenter{
       fun onSave()
       fun onAttach()
       fun onDetach()
    }
}