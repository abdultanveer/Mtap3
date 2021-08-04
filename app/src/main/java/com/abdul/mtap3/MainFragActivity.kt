package com.abdul.mtap3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainFragActivity : AppCompatActivity(), HeadlinesFragment.OnHeadlinesClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_frag)
    }

    override fun onHeadlineclick(headline: String) {
        // var newsDetailsFrag = NewsDetailsFrag()
        if (supportFragmentManager.findFragmentById(R.id.newsdetailsfrag) != null) {
            //the app is launched on a tablet
            var newsDetailsFrag: NewsDetailsFrag =
                supportFragmentManager.findFragmentById(R.id.newsdetailsfrag) as NewsDetailsFrag
            newsDetailsFrag.setHeadlineTv(headline)

        } else {  //app is launched on a phone
            var newsDetailsFrag = NewsDetailsFrag()
            var args = Bundle()
            args.putString("hl", headline)
           // newsDetailsFrag.setHeadlineTv(headline)
            newsDetailsFrag.arguments = args
            var headlinesFragment = supportFragmentManager.findFragmentById(R.id.headlinesfrag)
            supportFragmentManager.beginTransaction().remove(headlinesFragment!!).commit()
            supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout_fragContainer, newsDetailsFrag).commit()
            //add(R.id.framelayout_fragContainer,newsDetailsFrag)
        }

    }
}