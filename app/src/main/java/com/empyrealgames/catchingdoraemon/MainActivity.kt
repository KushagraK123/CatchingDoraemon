package com.empyrealgames.catchingdoraemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.gridlayout.widget.GridLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*



class MainActivity : AppCompatActivity() {
    private var score: Int = 0
    private var time: Int = 0
    var handler: Handler = Handler()
    var runnable  = Runnable {}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runnable = object : Runnable{
            override fun run() {
                doraemon.visibility = View.INVISIBLE
                timeText.text = "GameOver"
            }
        }
    }


    fun increaseScore(view: View){
        handler.removeCallbacks(runnable)
        score += 1
        scoreText.setText("Score : $score")
        val p: GridLayout.LayoutParams = GridLayout.LayoutParams(doraemon.layoutParams)
        val r = Random()
        p.columnSpec = GridLayout.spec(r.nextInt(3));
        p.rowSpec = GridLayout.spec(r.nextInt(3))
        doraemon.setLayoutParams (p)
        handler.postDelayed(runnable, getCallBackTime())

    }

    fun getCallBackTime(): Long{
        var ans : Long  = 0
        if(score < 7){
            ans =  1500
        }else if(score < 15){
            ans = 1350
        }else if(score < 25){
            ans = 1100
        }else if(score < 35){
            ans = 900
        }else if(score < 55){
            ans = 850
        }else if(score < 80){
            ans = 700
        }else {
            ans = 500
        }
        return ans
    }


}
