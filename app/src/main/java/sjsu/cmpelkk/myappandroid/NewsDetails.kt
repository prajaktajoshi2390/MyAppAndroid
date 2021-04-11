package sjsu.cmpelkk.myappandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.appbar.CollapsingToolbarLayout

class NewsDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        val dataitem: DataItem? = intent.extras?.get("DataItem") as? DataItem
//        val toolbarlayout: CollapsingToolbarLayout =
//            findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)
        val newsDetailsImage = findViewById<ImageView>(R.id.newsDetailsImage)
        val author = findViewById<TextView>(R.id.newsDetailsAuthor)
        val newsDetailsTitle = findViewById<TextView>(R.id.newsDetailsTitle)
        val newsDetailsStory = findViewById<TextView>(R.id.newsDetailsStory)
        if (dataitem != null) {
            newsDetailsTitle.text = dataitem.title
            //toolbarlayout.setBackgroundResource(R.drawable.sjsu1)
            newsDetailsImage.setImageURI(Uri.parse(dataitem.imagename))
            author.text = "By Author: " + dataitem.name
            newsDetailsStory.text = dataitem.story
        }
        // setSupportActionBar(findViewById(R.id.toolbar)) //toolbar in activity_detail_scrolling.xml
        // supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}