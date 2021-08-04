package com.abdul.mtap3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainFragActivity : AppCompatActivity(),HeadlinesFragment.OnHeadlinesClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_frag)
    }

    override fun onHeadlineclick(headline: String) {
       // var newsDetailsFrag = NewsDetailsFrag()
        var newsDetailsFrag: NewsDetailsFrag = supportFragmentManager.findFragmentById(R.id.newsdetailsfrag) as NewsDetailsFrag
        newsDetailsFrag.setHeadlineTv(headline)

    }
}