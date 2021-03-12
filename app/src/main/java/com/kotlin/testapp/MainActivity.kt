package com.kotlin.testapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders.of
import com.kotlin.testapp.ViewModel.ViewModelMain
import com.kotlin.testapp.fragment.AddFragment
import com.kotlin.testapp.fragment.AkunFragment
import com.kotlin.testapp.fragment.HomeFragment
import com.kotlin.testapp.fragment.LoginFragment
import np.com.susanthapa.curved_bottom_navigation.CbnMenuItem
import np.com.susanthapa.curved_bottom_navigation.CurvedBottomNavigationView


class MainActivity : AppCompatActivity() {
    val isLogin : Boolean = false
    var mainViewModel : ViewModelMain?=null
    var navBottom : CurvedBottomNavigationView?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = of(this)[ViewModelMain::class.java]

        /*if (!isLogin)
            navigateToFragment(LoginFragment())*/

        val menuItems = arrayOf(
            CbnMenuItem(
                R.drawable.ic_dashboard,
                R.drawable.avd_dashboard,
                R.id.navigation_dashboard
            ),
            CbnMenuItem(
                R.drawable.ic_baseline_add_24,
                R.drawable.avd_add,
                R.id.navigation_dashboard
            ),
            CbnMenuItem(
                R.drawable.ic_baseline_account_circle_24,
                R.drawable.avd_akun,
                R.id.navigation_dashboard
            )
        )

        navBottom = findViewById(R.id.nav_view)

        navBottom!!.setMenuItems(menuItems, 1)

        navBottom!!.setOnMenuItemClickListener { cbnMenuItem, i ->
            Log.d("INI APA", "ini loh = " + i)
            when(i){
                0->{
                    navigateToFragment(HomeFragment())
                }
                1->{
                    navigateToFragment(AddFragment())
                }
                2->{
                    if (mainViewModel!!.getLogin()) {
                        navigateToFragment(AkunFragment())
                    } else
                        navigateToFragment(LoginFragment())
                }
            }
        }

        navigateToFragment(AddFragment())
    }

    private fun navigateToFragment(fragmentToNavigate: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragmentToNavigate)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}