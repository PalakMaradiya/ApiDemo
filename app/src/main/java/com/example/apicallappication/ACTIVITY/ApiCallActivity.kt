package com.example.apicallappication.ACTIVITY

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request.Method.GET
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.apicallappication.ADAPTER.ApiAdapter
import com.example.apicallappication.RESPONSE.ObjectResponeItem
import com.example.apicallappication.databinding.ActivityApiCallBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ApiCallActivity : AppCompatActivity() {
    lateinit var  binding: ActivityApiCallBinding
    var url = "https://gorest.co.in/public/v2/users"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiCallBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }


    private fun initview() {


        binding.btnClick.setOnClickListener {
            getData()
        }
    }


    private fun getData() {

        var requestQueue = Volley.newRequestQueue(this)
//        val  request : jsonObjectRequest = JsonObjectRequest(GET, url, null,
//            { response ->
//                Log.e("TAG", "getData: "+ response )
//                binding.txt.text = response.toString()
//
//
//            },
//            { error ->
//                Log.e("TAG", "getData: "+error )
//
//            }
//        )


        val progressDialog = ProgressDialog(this@ApiCallActivity)
        progressDialog.setTitle("Please Wait ")
        progressDialog.setMessage("Application is loading")
        progressDialog.show()


        var request : StringRequest = StringRequest(GET,url , object : Response.Listener<String>{
            override fun onResponse(response: String?) {


              progressDialog.dismiss()

                var token = object  : TypeToken<List<ObjectResponeItem?>>(){}.type
                var result : List<ObjectResponeItem?> = Gson().fromJson(response,token)




                var adapter : ApiAdapter = ApiAdapter(this@ApiCallActivity,result, onClick = {

                    id: Int ->

                    var i = Intent(this@ApiCallActivity,DispalyDataActivity::class.java)
                    i.putExtra("id",id)
//                    i.putExtra("name",name)
//                    i.putExtra("email",email)
//                    i.putExtra("gender",gender)
//                    i.putExtra("statues",statues)
                    startActivity(i)
                })

                var manager = LinearLayoutManager(this@ApiCallActivity,RecyclerView.VERTICAL,false)
                binding.rcv.layoutManager = manager
                binding.rcv.adapter = adapter
            }

        }, Response.ErrorListener {
            Log.e("TAG", "getData: "+it )

        })
        requestQueue.add(request)
    }




}