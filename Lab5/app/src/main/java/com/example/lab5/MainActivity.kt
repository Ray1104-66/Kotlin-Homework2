package com.example.lab5

import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val dialog = AlertDialog.Builder(this@MainActivity)
                dialog.setTitle("請選擇功能")
                dialog.setMessage("請根據下方按鈕選擇要顯示的物件")

                dialog.setNeutralButton("取消", object : DialogInterface.OnClickListener {
                    override fun onClick(dialogInterface: DialogInterface?, i: Int) {
                        Toast.makeText(this@MainActivity, "dialog關閉", Toast.LENGTH_SHORT).show()
                    }
                })

                dialog.setNegativeButton("自定義Toast", object : DialogInterface.OnClickListener {
                    override fun onClick(dialogInterface: DialogInterface?, i: Int) {
                        showToast()
                    }
                })

                dialog.setPositiveButton("顯示list", object : DialogInterface.OnClickListener {
                    override fun onClick(dialogInterface: DialogInterface?, i: Int) {
                        showListDialog()
                    }
                })
                dialog.show()
            }
        })
    }

    private fun showToast() {
        val toast = Toast(this@MainActivity)
        toast.setText("message")
        toast.setGravity(Gravity.TOP, 0, 50)
        toast.setDuration(Toast.LENGTH_SHORT)
        val inflater = getLayoutInflater()
        val layout = inflater.inflate(
            R.layout.custom_toast,
            findViewById<ViewGroup?>(R.id.custom_toast_root)
        )
        toast.setView(layout)
        toast.show()
    }

    private fun showListDialog() {
        val list = arrayOf<String?>("message1", "message2", "message3", "message4", "message5")
        val dialog_list = AlertDialog.Builder(this@MainActivity)
        dialog_list.setTitle("使用List呈現")
        dialog_list.setItems(list, object : DialogInterface.OnClickListener {
            override fun onClick(dialogInterface: DialogInterface?, i: Int) {
                Toast.makeText(
                    this@MainActivity, "您選擇的是" + list[i],
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        dialog_list.show()
    }
}