package sjsu.cmpelkk.myappandroid.Network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

private const val NewsAPPID = "dd7b85a45a0e43d5b32b1d8a39f0ee55"

class NewsViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    // The internal MutableLiveData String that stores the most recent response
    val _response = MutableLiveData<List<Article>>()

    /**
     * Call getNewsProperties() on init so we can display status immediately.
     */
    init {
        getNewsProperties()
        //getBackendProperties()
    }

    private fun getNewsProperties() {
        //_response.value = "Set the News API Response here!"
        //NewsApi.retrofitService.getProperties()
        NewsApi.retrofitService.getTopHeadlines("us", NewsAPPID).enqueue(
            object : Callback<TopHeadlines> {
                override fun onFailure(call: Call<TopHeadlines>, t: Throwable) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    // _response.value = "Failure: " + t.message
                }

                override fun onResponse(
                    call: Call<TopHeadlines>,
                    response: Response<TopHeadlines>
                ) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    //_response.value = response.body()
                    _response.value = response.body()?.articles
                        // "Success: ${response.body()?.articles} city retrieved; Status: ${response.body()?.status}; Total Results: ${response.body()?.totalResults}"
                }

            }
        )
    }
}