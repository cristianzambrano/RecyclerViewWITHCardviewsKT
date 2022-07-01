package uteq.solutions.recyclerviewconcardviewskotlin

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager

        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET, "https://reqres.in/api/users",
            Response.Listener<String> { response ->

                val JSONlista = JSONObject(response)
                val JSONlistaUsuarios: JSONArray = JSONlista.getJSONArray("data")
                var lstUsuarios = ArrayList<Usuario>()
                lstUsuarios = Usuario.JsonObjectsBuild(JSONlistaUsuarios)

                val resId = R.anim.layout_animation_down_to_up
                val animation = AnimationUtils.loadLayoutAnimation(
                    applicationContext,
                    resId
                )
                recyclerView.layoutAnimation = animation

                adapter = RecyclerAdapter(lstUsuarios)

                recyclerView.adapter = adapter

            },
            Response.ErrorListener {  })


        queue.add(stringRequest)


    }




}