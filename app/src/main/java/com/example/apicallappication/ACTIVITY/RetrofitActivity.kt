package com.example.apicallappication.ACTIVITY

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.apicallappication.INTREFACE.PoductInreface
import com.example.apicallappication.OBJECT.RetrofitHelper
import com.example.apicallappication.databinding.ActivityRetrofitBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RetrofitActivity : AppCompatActivity() {
    lateinit var binding: ActivityRetrofitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }





    private fun initview() {

        binding.btnClick.setOnClickListener {

            val Procuteapi = RetrofitHelper.getInstance().create(PoductInreface::class.java)
            // launching a new coroutine
            GlobalScope.launch {
                val result = Procuteapi.getProduct()
                if (result != null) {
                    // Checking the results
                    Log.e("TAG", "initview data: "+ result.body().toString())
                }
            }

        }



    }

}

