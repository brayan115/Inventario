package com.tienda.minventario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tienda.minventario.fragments.AddFragment
import com.tienda.minventario.fragments.CalculoFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addFragment = AddFragment()
        val calculoFragment = CalculoFragment()
        val blankFragment = BlankFragment()
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)


        //DATABASE




         bottomNavigation.setOnNavigationItemSelectedListener  {
                 item -> when (item.itemId){
                R.id.page_1 -> makeCurrentFragment(addFragment)
                R.id.page_2 -> makeCurrentFragment(calculoFragment)
                R.id.page_3 -> makeCurrentFragment(blankFragment)
            }
            true
        }

    }
    private fun makeCurrentFragment(fragment: Fragment)=

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.content_framelayout,fragment)
            commit()
        }
}