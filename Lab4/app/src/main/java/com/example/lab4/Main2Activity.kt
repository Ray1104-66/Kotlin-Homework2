package com.example.lab4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class Main2Activity : AppCompatActivity() {
    private var set_drink: EditText? = null
    private var rg1: RadioGroup? = null
    private var rg2: RadioGroup? = null
    private var btn_send: Button? = null

    private var sugar = "無糖"
    private var ice_opt = "去冰"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rg1 = findViewById<RadioGroup>(R.id.radioGroup)
        rg1!!.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(radioGroup: RadioGroup?, i: Int) {
                if (i == R.id.radioButton1) {
                    sugar = "無糖"
                } else if (i == R.id.radioButton2) {
                    sugar = "少糖"
                } else if (i == R.id.radioButton3) {
                    sugar = "半糖"
                } else if (i == R.id.radioButton4) {
                    sugar = "全糖"
                }
            }
        })

        rg2 = findViewById<RadioGroup>(R.id.radioGroup2)
        rg2!!.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(radioGroup: RadioGroup?, i: Int) {
                if (i == R.id.radioButton5) {
                    ice_opt = "去冰"
                } else if (i == R.id.radioButton6) {
                    ice_opt = "微冰"
                } else if (i == R.id.radioButton7) {
                    ice_opt = "少冰"
                } else if (i == R.id.radioButton8) {
                    ice_opt = "正常冰"
                }
            }
        })

        btn_send = findViewById<Button>(R.id.btn_send)
        btn_send!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                set_drink = findViewById<EditText>(R.id.ed_drink)
                val drink = set_drink!!.getText().toString()
                val i = Intent()
                val b = Bundle()
                b.putString("drink", drink)
                b.putString("sugar", sugar)
                b.putString("ice", ice_opt)
                i.putExtras(b)
                setResult(101, i)
                finish()
            }
        })
    }
}