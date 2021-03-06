package com.devarthur4718.kotlinsamples

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.devarthur4718.kotlinsamples.Views.SingleActivity
import com.devarthur4718.kotlinsamples.Views.UserActivity
//* Created by Arthur Gomes at 04/03/19 12:49 - contact me at devarthur4718@gmail.com.br

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        //Passando para a próxima tela

        Handler().postDelayed({

            startActivity(Intent(this, SingleActivity::class.java))

            finish()

        }, 2000)

    }
}
