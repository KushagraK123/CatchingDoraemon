package com.empyrealgames.catchingdoraemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.gridlayout.widget.GridLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private var score: Int = 0
    private var time: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    fun increaseScore(view: View){
        score++
        scoreText.setText("Score : $score" )
        val p: GridLayout.LayoutParams = GridLayout.LayoutParams(doraemon.layoutParams)
        val r:Random = Random()
        p.columnSpec = GridLayout.spec(r.nextInt(3));
        p.rowSpec = GridLayout.spec(r.nextInt(3))
        doraemon.setLayoutParams (p)

    }

}
