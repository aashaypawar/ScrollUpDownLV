package org.geeksforgeeks.scrollupdownlv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mList = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",)

        val mListView = findViewById<ListView>(R.id.list_view)
        val mTextView = findViewById<TextView>(R.id.text_view)
        val mAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, mList)

        mListView.adapter = mAdapter

        mListView.setOnScrollListener(object : AbsListView.OnScrollListener{
            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {
                // Do nothing
            }

            private var lastFirstVisibleItem = 0

            override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
                if (lastFirstVisibleItem < firstVisibleItem) {
                    // Down
                    mTextView.text = "Scrolling down"
                }
                if (lastFirstVisibleItem > firstVisibleItem) {
                    // Up
                    mTextView.text = "Scrolling Up"
                }
                lastFirstVisibleItem = firstVisibleItem
            }
        })

    }
}