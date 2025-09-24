package com.example.iiii

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // 뷰 선언
    private lateinit var textView2: TextView
    private lateinit var rGroup1: RadioGroup
    private lateinit var btnOK: Button
    private lateinit var imgPet: ImageView
    private lateinit var swiAgree: Switch
    private lateinit var btnOK2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 뷰 바인딩
        textView2 = findViewById<TextView>(R.id.textView2)
        rGroup1 = findViewById<RadioGroup>(R.id.rGroup1)
        btnOK = findViewById<Button>(R.id.btnOK)
        imgPet = findViewById<ImageView>(R.id.imgPet)
        swiAgree = findViewById<Switch>(R.id.swiAgree)
        btnOK2 = findViewById<Button>(R.id.btnOK2)

        // 초기에는 숨김 처리
        textView2.visibility = View.INVISIBLE
        rGroup1.visibility = View.INVISIBLE
        btnOK.visibility = View.INVISIBLE
        imgPet.visibility = View.INVISIBLE
        btnOK2.visibility = View.INVISIBLE

        // Switch 체크 시 숨김/보이기
        swiAgree.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                textView2.visibility = View.VISIBLE
                rGroup1.visibility = View.VISIBLE
                btnOK.visibility = View.VISIBLE
                imgPet.visibility = View.VISIBLE
                btnOK2.visibility = View.VISIBLE
            } else {
                textView2.visibility = View.INVISIBLE
                rGroup1.visibility = View.INVISIBLE
                btnOK.visibility = View.INVISIBLE
                imgPet.visibility = View.INVISIBLE
                btnOK2.visibility = View.INVISIBLE
                rGroup1.clearCheck()
            }
        }

        // 버튼 클릭 시 프로그램 종료
        btnOK.setOnClickListener {
            finish()
        }

        // btn2 클릭 시 초기화
        btnOK2.setOnClickListener {
            // 모든 선택 상태 초기화
            rGroup1.clearCheck()
            imgPet.visibility = View.INVISIBLE
            textView2.visibility = View.INVISIBLE
            rGroup1.visibility = View.INVISIBLE
            btnOK.visibility = View.INVISIBLE
            btnOK2.visibility = View.INVISIBLE
            swiAgree.isChecked = false
        }

        // 라디오 버튼 선택 시 이미지 변경
        rGroup1.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.oreo -> {
                    imgPet.setImageResource(R.drawable.oreo)
                    imgPet.visibility = View.VISIBLE
                }
                R.id.pie -> {
                    imgPet.setImageResource(R.drawable.pie)
                    imgPet.visibility = View.VISIBLE
                }
                R.id.q10 -> {
                    imgPet.setImageResource(R.drawable.q10)
                    imgPet.visibility = View.VISIBLE
                }
                else -> {
                    imgPet.visibility = View.INVISIBLE

                }
            }
        }
    }
}
