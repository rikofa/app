package com.kotlin.testapp.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelMain : ViewModel() {
    private var username : String = ""
    var password : String = ""
    var isLogin : Boolean = false

    @JvmName("getUsernamed")
    fun getUsername(): String {
        return username;
    }

    fun setUsername(username:String){
        this.username = username
    }

    @JvmName("setLogin1")
    fun setLogin(isLogin : Boolean){
        this.isLogin = isLogin
    }
    fun getLogin() : Boolean{
        Log.d("TAG", "apakah = " + this.isLogin)
        return this.isLogin
    }

    fun checkLogin(username : String, password : String) : Boolean{
        if(username.equals("admin") && password.equals("admin"))
            this.isLogin = true
        else
            this.isLogin = false

        return isLogin
    }


}