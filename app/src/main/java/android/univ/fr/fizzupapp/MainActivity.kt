package android.univ.fr.fizzupapp

import android.os.Bundle
import android.univ.fr.fizzupapp.model.Data
import android.univ.fr.fizzupapp.model.DataX
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener


class MainActivity : AppCompatActivity() {
    private val dataList: MutableList<DataX> = mutableListOf()
    private lateinit var myAdapter: MyRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myAdapter = MyRecyclerViewAdapter(dataList)
        findViewById<RecyclerView>(R.id.recyclerView_main).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, OrientationHelper.VERTICAL))
            adapter = myAdapter
        }

        AndroidNetworking.initialize(this)
        AndroidNetworking.get("https://s3-us-west-1.amazonaws.com/fizzup/files/public/sample.json")
            .build().getAsObject(Data::class.java, object : ParsedRequestListener<Data> {
                override fun onResponse(response: Data) {
                    dataList.addAll(response.data)
                    myAdapter.notifyDataSetChanged()
                }

                override fun onError(anError: ANError?) {
                }
            })


        val networkConnexion = NetworkConnexion(applicationContext)
        networkConnexion.observe(this, Observer { isConnected ->
            if (isConnected) {
                findViewById<RecyclerView>(R.id.recyclerView_main).visibility = VISIBLE
                findViewById<TextView>(R.id.disconnectedText).visibility = GONE

            } else {
                //findViewById<RecyclerView>(R.id.recyclerView_main).visibility = GONE
                findViewById<TextView>(R.id.disconnectedText).visibility = VISIBLE
            }

        })
    }
}