package com.example.calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Operator Buttons
        division.setOnClickListener { appendOnExpresstion("/", true)}
        multi.setOnClickListener { appendOnExpresstion("*", true)}
        plus.setOnClickListener { appendOnExpresstion("+", true)}
        moins.setOnClickListener { appendOnExpresstion("-", true)}

        // Number Buttons
        un.setOnClickListener { appendOnExpresstion("1", true) }
        deux.setOnClickListener { appendOnExpresstion("2", true) }
        trois.setOnClickListener { appendOnExpresstion("3", true) }
        quatre.setOnClickListener { appendOnExpresstion("4", true) }
        cinq.setOnClickListener { appendOnExpresstion("5", true) }
        six.setOnClickListener { appendOnExpresstion("6", true) }
        sept.setOnClickListener { appendOnExpresstion("7", true) }
        huit.setOnClickListener { appendOnExpresstion("8", true) }
        neuf.setOnClickListener { appendOnExpresstion("9", true) }

        buttonClear.setOnClickListener(){
            expression.text = ""
            result.text = ""
        }

        egal.setOnClickListener {
            try {
                val expression = ExpressionBuilder(expression.text.toString()).build()
                val res = expression.evaluate()
                val longResult = res.toLong()
                if(res == longResult.toDouble())
                    result.text = longResult.toString()
                else
                    result.text = result.toString()

            }catch (e:Exception){
                Log.d("Exception"," message : " + e.message )
            }
        }

    }


    fun appendOnExpresstion(string: String, canClear: Boolean) {

            if(result.text.isNotEmpty()){
                expression.text = ""
            }

            if (canClear) {
                result.text = ""
                expression.append(string)
            } else {
                expression.append(result.text)
                expression.append(string)
                result.text = ""
            }
        }

    }

