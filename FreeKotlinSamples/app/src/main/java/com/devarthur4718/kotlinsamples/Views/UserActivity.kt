package com.devarthur4718.kotlinsamples.Views

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager


import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.devarthur4718.kotlinsamples.Adapter.PartAdapter
import com.devarthur4718.kotlinsamples.DataModel.PartData

import com.devarthur4718.kotlinsamples.R
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.app_bar_user.*
import kotlinx.android.synthetic.main.content_user.*


class UserActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        setSupportActionBar(toolbar)
        toolbar.setTitle("Kotlin Samples")


        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        initActions()


    }

    private fun initActions() {
        //Create a list of itens for recycler
        var partList = ArrayList<PartData>()

        partList.add(PartData(1,resources.getString(R.string.menuItemOver)))
        partList.add(PartData(2,resources.getString(R.string.action_settings)))
        partList.add(PartData(3,resources.getString(R.string.menuArchitecture)))
        partList.add(PartData(4,resources.getString(R.string.menuBasicTypes)))
        partList.add(PartData(5,resources.getString(R.string.menuVisibilityControl)))
        partList.add(PartData(6,resources.getString(R.string.menuClass)))
        partList.add(PartData(7,resources.getString(R.string.menuConstructor)))
        partList.add(PartData(8,resources.getString(R.string.menuInheritance)))
        partList.add(PartData(9,resources.getString(R.string.menuVisibilityControl)))



        rv_recyclerView.layoutManager = LinearLayoutManager(this)
        rv_recyclerView.hasFixedSize()
        rv_recyclerView.adapter =  PartAdapter(partList, { partItem : PartData -> partItemClicked(partItem) })


    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.user, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_kotlin -> {

            }
            R.id.nav_item_android_samples ->{

            }


        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun partItemClicked(partItem : PartData) {
        Toast.makeText(this, "Clicked: ${partItem.itemName}", Toast.LENGTH_LONG).show()
    }
}
