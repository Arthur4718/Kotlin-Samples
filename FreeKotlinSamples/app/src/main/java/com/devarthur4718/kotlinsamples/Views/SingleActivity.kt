package com.devarthur4718.kotlinsamples.Views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.devarthur4718.kotlinsamples.Adapter.PartAdapter
import com.devarthur4718.kotlinsamples.DataModel.PartData
import com.devarthur4718.kotlinsamples.R
import kotlinx.android.synthetic.main.content_user.*

class SingleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        setTheme(R.style.AppTheme)

        initAction()



    }

    private fun initAction() {

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

    private fun partItemClicked(partItem : PartData) {


    }
}
