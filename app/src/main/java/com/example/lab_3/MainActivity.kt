package com.example.lab_3

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


//Вариант 8. Дана строка. Инвертировать ее, то есть произвести обмен значениями
//между первым и последним символами строки,
//вторым и предпоследним и так далее.


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onClickButton(@Suppress("UNUSED_PARAMETER")view: View){
        val inp = findViewById<TextView>(R.id.textInputEditText)
        if(inp.text.isNullOrBlank()){
            return
        }
        val st = inp.text.toString()
        invertString(st)
    }

    fun invertString (s:String){
        val len = s.length
        var res_A:CharSequence = s.subSequence(0,len/2)
        var res_B:CharSequence = s.subSequence(len/2, len)
        res_A = res_A.reversed()
        res_B = res_B.reversed()
        val out = res_B.toString() + res_A.toString()
        Log.d("test", out)

    }
}

