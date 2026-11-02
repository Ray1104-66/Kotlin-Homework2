package com.example.lab6

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // 每筆資料包含圖片與名稱，不允許為 null
    private data class Data(
        val photo: Int,
        val name: String
    )

    // 提供 Spinner 與 GridView 使用的自訂 Adapter
    private inner class MyAdapter(
        private val data: Array<Data>,
        private val layoutId: Int
    ) : BaseAdapter() {

        override fun getCount(): Int = data.size

        override fun getItem(position: Int): Data = data[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup?
        ): View {

            // 有舊的 View 就重用，沒有才建立
            val itemView = convertView
                ?: layoutInflater.inflate(layoutId, parent, false)

            val item = getItem(position)

            val nameView = itemView.findViewById<TextView>(R.id.name)
            val imageView = itemView.findViewById<ImageView>(R.id.imageView)

            nameView.text = item.name
            imageView.setImageResource(item.photo)

            return itemView
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 交通工具名稱
        val transNameArray = arrayOf(
            "腳踏車", "機車", "汽車", "巴士"
        )

        // 交通工具圖片
        val transPhotoIdArray = intArrayOf(
            R.drawable.trans1,
            R.drawable.trans2,
            R.drawable.trans3,
            R.drawable.trans4
        )

        // 表情名稱
        val cubeeNameArray = arrayOf(
            "哭哭", "發抖",
            "再見", "生氣",
            "昏倒", "竊笑",
            "很棒", "你好",
            "驚嚇", "大笑"
        )

        // 表情圖片
        val cubeePhotoIdArray = intArrayOf(
            R.drawable.cubee1,
            R.drawable.cubee2,
            R.drawable.cubee3,
            R.drawable.cubee4,
            R.drawable.cubee5,
            R.drawable.cubee6,
            R.drawable.cubee7,
            R.drawable.cubee8,
            R.drawable.cubee9,
            R.drawable.cubee10
        )

        // 訊息清單
        val messageArray = arrayOf(
            "訊息１", "訊息２", "訊息３",
            "訊息４", "訊息５", "訊息６"
        )

        // 直接建立完整資料，不需要先填入 null
        val transData = Array(transNameArray.size) { index ->
            Data(
                photo = transPhotoIdArray[index],
                name = transNameArray[index]
            )
        }

        val cubeeData = Array(cubeeNameArray.size) { index ->
            Data(
                photo = cubeePhotoIdArray[index],
                name = cubeeNameArray[index]
            )
        }

        // 建立 Adapter
        val transAdapter = MyAdapter(
            transData,
            R.layout.trans_list
        )

        val cubeeAdapter = MyAdapter(
            cubeeData,
            R.layout.cubee_list
        )

        val messageAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            messageArray
        )

        // 下拉選單
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = transAdapter

        // 三欄表情網格
        val gridView = findViewById<GridView>(R.id.gridView)
        gridView.numColumns = 3
        gridView.adapter = cubeeAdapter

        // 訊息清單
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = messageAdapter
    }
}