package com.egci428.singletouch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.R.menu
import android.view.Menu
import android.view.MenuItem


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(SingleTouchEventView(this))
    }
}

