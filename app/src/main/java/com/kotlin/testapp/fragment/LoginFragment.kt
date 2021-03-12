package com.kotlin.testapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import com.kotlin.testapp.R
import com.kotlin.testapp.ViewModel.ViewModelMain

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    var btnLogin : Button?=null
    var edtUsername : EditText?= null
    var edtPassword : EditText?= null

    var mainViewModel : ViewModelMain?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_login, container, false)

        initUI(view)

        mainViewModel = ViewModelProviders.of(requireActivity())[ViewModelMain::class.java]

        btnLogin?.setOnClickListener {
            if(mainViewModel!!.checkLogin(edtUsername!!.getText().toString(), edtPassword!!.getText().toString())){
            val transaction: FragmentTransaction? =
                fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayout, AkunFragment())?.commit()
            }else {
                Toast.makeText(requireContext(), "Password Salah", Toast.LENGTH_LONG)
            }
        }

        return view
    }

    fun initUI(v : View){
        btnLogin = v.findViewById(R.id.btnLogin)
        edtUsername = v.findViewById(R.id.edtUsername)
        edtPassword = v.findViewById(R.id.edtPassword)
    }

}