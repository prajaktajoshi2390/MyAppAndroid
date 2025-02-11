package sjsu.cmpelkk.myappandroid

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var datalist: MutableList<DataItem> = mutableListOf()
    lateinit var recyclerCard: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)
//        view.textView1.setOnclickListner{
//            val action = SecondFragmentDirections.navigateToSecondFragment(222)
//            Navigation.findNavController(view).navigate(action)
//        }
        return view
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        recyclerCard = itemView.findViewById(R.id.cardrecyclerview)
        datalist = cardworlddata.toMutableList()
        recyclerCard.adapter = HomeCardAdapter(datalist) //(carddefaultdata)

//        val fab: View = itemView.findViewById(R.id.floatingActionButton)
//        fab.setOnClickListener { view ->
//
//            val action = SecondFragmentDirections.actionSecondFragmentToPostActivity()
//            Navigation.findNavController(view).navigate(action)
//        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}

class HomeCardViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView) {
    val title: TextView = cardView.findViewById(R.id.carditemtitletextView)
    val story: TextView = cardView.findViewById(R.id.carditemdetailtext)
    val image: ImageView = cardView.findViewById(R.id.cardimageView)

    fun bind(oneitem: DataItem) {
        title.text = oneitem.title
        story.text = oneitem.story
        image.setImageURI(Uri.parse(oneitem.imagename))
        val context = cardView.context
        cardView.setOnClickListener {
            var position: Int = adapterPosition
            Snackbar.make(it, "Click detected on item $position",
                Snackbar.LENGTH_LONG).setAction("Action", null).show()

            val intent = Intent(context, NewsDetails::class.java).apply {
                //putExtra("DataItem", oneitem.title)
                putExtra("DataItem", oneitem as Serializable)
                //get the object with: val object = intent.extras.get("DataItem") as DataItem
            }
            context.startActivity(intent)
        }
        //header.setTextColor(Color.parseColor("#ffffff"))
        title.setTextColor(context.getColor(R.color.primaryDarkColor))
        //description.setTextColor(Color.parseColor("#ffa270"))
        story.setTextColor(context.getColor(R.color.secondaryDarkColor))

        val toggle: ToggleButton = cardView.findViewById(R.id.toggleFavourite)
        toggle.setBackgroundResource(R.drawable.favgray);
        toggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // The toggle is enabled
                toggle.setBackgroundResource(R.drawable.favyellow);
            } else {
                // The toggle is disabled
                toggle.setBackgroundResource(R.drawable.favgray);
            }
        }
    }

}

class HomeCardAdapter(var data: MutableList<DataItem>) : RecyclerView.Adapter<HomeCardViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCardViewHolder {
        //TODO("Not yet implemented")
        //create an instance of LayoutInflater
        //The layout inflater knows how to create views from XML layouts. The context contains information on how to correctly inflate the view.
        // In an adapter for a recycler view, you always pass in the context of the parent view group, which is the RecyclerView.
        val layoutInflater = LayoutInflater.from(parent.context)

        //create the view by asking the layoutinflater to inflate it.
        //Pass in the XML layout for the view, and the parent view group for the view. The third, boolean, argument is attachToRoot.
        // This argument needs to be false, because RecyclerView adds this item to the view hierarchy for you when it's time.
        val view = layoutInflater
            .inflate(R.layout.card_item_view, parent, false) as CardView


        //val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item_view, parent, false)
        return HomeCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return data.size
    }

    override fun onBindViewHolder(holder: HomeCardViewHolder, position: Int) {
        //TODO("Not yet implemented")
        holder.bind(data[position])
    }

    fun removeAt(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }

}