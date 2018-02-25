package com.tasktoysrt.exp

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class Main : AppCompatActivity(),
        Myflagment1.OnFragmentInteractionListener,
        PlusOneFragment.OnFragmentInteractionListener,
        BlankFragment.OnFragmentInteractionListener{
    override fun onFragmentInteraction(uri: Uri) {
        Log.d("Main",uri.toString())
    }

    fun switchToMyFragment1(){
        val manager = supportFragmentManager
        manager.beginTransaction().replace(R.id.fragment_main,  Myflagment1.newInstance("a","b") as Fragment).commit()
    }

    fun switchToPlusOne(){
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_main, PlusOneFragment.newInstance("a","b") as Fragment)
                .commit()
    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                switchToMyFragment1()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                switchToPlusOne()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                switchToBlankFlagment()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun switchToBlankFlagment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_main, BlankFragment.newInstance("a", "b") as Fragment)
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        supportFragmentManager.beginTransaction()
//                .add(Myflagment1.newInstance("a","b") as Fragment)
//                .commit()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
