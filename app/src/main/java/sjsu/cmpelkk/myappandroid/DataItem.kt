package sjsu.cmpelkk.myappandroid

import android.net.Uri
import java.io.Serializable

data class DataItem(
    val name: String,
    val title: String,
    val story: String,
    val highlight: Boolean = false,
    val rating: Int,
    val imagename: String //Int, //String?
): Serializable

//val yourDrawable  = ResourcesCompat.getDrawable(resources, R.drawable.sjsu1, null)
//Uri.parse("android.resource://" + packageName + "/" + R.drawable.sjsu1)

//public val carddefaultdata = listOf<DataItem>(
//    DataItem("name1", "testtitle1", "Test story, Test storyTest storyTest storyTest storyTest storyTest storyTest storyTest storyTest storyTest storyTest storyTest story", false, 4, R.drawable.imageupload),
//    DataItem("name2", "testtitle2", "Test story", true, 4, R.drawable.sjsu1),
//    DataItem("name3", "testtitle3", "Test story", false, 4, R.drawable.sjsu2),
//    DataItem("name4", "testtitle4", "Test story", false, 4, R.drawable.sjsu3)
//    )

public val carddefaultdata = listOf<DataItem>(
        DataItem("name1", "Tesla and GameStop were some of the most popular US shares last week",
                "Tesla, Palantir and Amazon.com were some of the most popular US shares that ASX inevstors were trading last week.",
                false, 4, Uri.parse("android.resource://sjsu.cmpelkk.myappandroid" + "/" + R.drawable.usshare).toString()),
        // DataItem("name1", "testtitle1", "Test story, Test storyTest storyTest storyTest storyTest storyTest storyTest storyTest storyTest storyTest storyTest storyTest story", false, 4, Uri.parse("android.resource://sjsu.cmpelkk.myappandroid" + "/" + R.drawable.sjsu1).toString()),
        DataItem("name2", "Chevrolet will build an electric Silverado with 400 miles of range - Engadget",
                "General Motors President Mark Reuss has announced the electric Silverado pickup.", false, 4,
                Uri.parse("android.resource://sjsu.cmpelkk.myappandroid" + "/" + R.drawable.silv).toString()),
        DataItem("name3", "Patreon triples valuation to \$4 billion in new raise",
                "Patreon has tripled its valuation to \$4 billion in a \$155 million funding round led by Tiger Global", true,
                4, Uri.parse("android.resource://sjsu.cmpelkk.myappandroid" + "/" + R.drawable.patreon).toString()),//Uri is not serializable

        DataItem("name4", "U.K. Launches New Competition Watchdog Targeting Big Tech - The Wall Street Journal",
                "Digital Markets Unit to police how largest global technology firms wield their market power", false,
                4, Uri.parse("android.resource://sjsu.cmpelkk.myappandroid" + "/" + R.drawable.person).toString())
)
public val cardworlddata = listOf<DataItem>(
    DataItem("name1", "U.K. Launches New Competition Watchdog Targeting Big Tech - The Wall Street Journal",
            "Digital Markets Unit to police how largest global technology firms wield their market power", false,
            4, Uri.parse("android.resource://sjsu.cmpelkk.myappandroid" + "/" + R.drawable.person).toString()),
    DataItem("name2", "Japanese Governor Warns That Region's Hospitals Are 'on the Verge of Collapse' Amid COVID Spike",
            "The governor of Osaka, Japan recently warned that the region's hospitals are on the \"verge of collapse\" amid a surge in COVID-19 cases.", false,
            4, Uri.parse("android.resource://sjsu.cmpelkk.myappandroid" + "/" + R.drawable.japan).toString())
)
public val favouritesdata = listOf<DataItem>(
    DataItem("name3", "Patreon triples valuation to \$4 billion in new raise",
        "Patreon has tripled its valuation to \$4 billion in a \$155 million funding round led by Tiger Global", true,
        4, Uri.parse("android.resource://sjsu.cmpelkk.myappandroid" + "/" + R.drawable.patreon).toString()),//Uri is not serializable

    DataItem("name4", "U.K. Launches New Competition Watchdog Targeting Big Tech - The Wall Street Journal",
        "Digital Markets Unit to police how largest global technology firms wield their market power", false,
        4, Uri.parse("android.resource://sjsu.cmpelkk.myappandroid" + "/" + R.drawable.person).toString())
)
