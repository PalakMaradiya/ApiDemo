package com.example.apicallappication.ACTIVITY

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request.Method.GET
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.apicallappication.ADAPTER.AdapterSecondApi
import com.example.apicallappication.RESPONSE.ObjectResponeItem
import com.example.apicallappication.RESPONSE.SecondResopenItem
import com.example.apicallappication.databinding.ActivityDispalyDataBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DispalyDataActivity : AppCompatActivity() {
    lateinit var binding : ActivityDispalyDataBinding


    var url = "https://jsonplaceholder.typicode.com/todos"
    var id : Int = 0
//    lateinit var name : String
//    lateinit var Email : String
//    lateinit var Gender : String
//    lateinit var Satues : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDispalyDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {

        if (intent!=null)
        {

            id = intent.getIntExtra("id",id)
            var URL1 = "https://gorest.co.in/public/v2/users/$id"
//            name = intent.getStringExtra("name").toString()
//            Email = intent.getStringExtra("email").toString()
//            Gender = intent.getStringExtra("gender").toString()
//            Satues = intent.getStringExtra("statues").toString()

//            binding.txtId.text = id.toString()
//            binding.txtName.text = name
//            binding.txtEmail.text = Email
//            binding.txtGender.text = Gender
//            binding.txtStatus.text = Satues



            // aa code first api mathi user jena par click kar te data biji activity ma show thai che tena mate che

             // use  JsonObjectRequest
//            var requestQueue1 = Volley.newRequestQueue(this)
//            val  request1 : JsonObjectRequest = JsonObjectRequest(GET, URL1, null,
//                { response ->
//
//                    binding.txtId.text = response.toString()
//                    binding.txtName.text = response.toString()
//                    binding.txtEmail.text = response.toString()
//                    binding.txtGender.text = response.toString()
//                    binding.txtStatus.text = response.toString()
//
//                    Log.e("TAG", "getData: "+ response )
//
//
//                },
//                { error ->
//                    Log.e("TAG", "getData: "+error )
//
//                }
//            )
//            requestQueue1.add(request1)

            var requestQueue1 = Volley.newRequestQueue(this)
            val  request1 : StringRequest = StringRequest(GET, URL1, object : Response.Listener<String>{
                override fun onResponse(response: String?) {

                    var token = object  : TypeToken<ObjectResponeItem?>(){}.type
                    var result : ObjectResponeItem = Gson().fromJson(response,token)
                    binding.txtId.text = result.id.toString()
                    binding.txtName.text = result.name.toString()
                    binding.txtEmail.text = result.email.toString()
                    binding.txtGender.text = result.gender.toString()
                    binding.txtStatus.text = result.status.toString()

                }

            }, Response.ErrorListener {
                Log.e("TAG", "initview: "+ it)
            }

            )

            requestQueue1.add(request1)


          //  aa get data second api mate che
            binding.btnClick.setOnClickListener {

                getData()
            }

        }
    }


    private fun getData() {

        var requestQueue = Volley.newRequestQueue(this)

        // for second api call

        var request : StringRequest = StringRequest(GET,url , object : Response.Listener<String>{
            override fun onResponse(response: String?) {


                var token = object  : TypeToken<List<SecondResopenItem?>>(){}.type

                var result : List<SecondResopenItem?> = Gson().fromJson(response,token)


                var adapter : AdapterSecondApi = AdapterSecondApi(this@DispalyDataActivity,result)

                var manager = LinearLayoutManager(this@DispalyDataActivity, RecyclerView.VERTICAL,false)
                binding.recyclerView.layoutManager = manager

                binding.recyclerView.adapter = adapter
            }

        }, Response.ErrorListener {
            Log.e("TAG", "getData: "+it )

        })
        requestQueue.add(request)
    }
}