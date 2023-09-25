package com.example.mad_practical_8_21012011072

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.BroadcastReceiver
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextClock
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import java.text.SimpleDateFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addAlarm : Button = findViewById(R.id.create)
        val card : MaterialCardView = findViewById(R.id.card2)

        card.visibility = View.GONE

        addAlarm.setOnClickListener {
            TimePickerDialog(this, {tp, hour, minute -> setAlarmTime(hour, minute)}, 11,0,false).show()
        }
    }

    fun setAlarmTime(hour : Int, minute : Int){
        //card.visibility = View.VISIBLE
        val alarmtime = Calendar.getInstance()
        val year = alarmtime.get(Calendar.YEAR)
        val month = alarmtime.get(Calendar.MONTH)
        val date = alarmtime.get(Calendar.DATE)
        val hour = alarmtime.get(Calendar.HOUR)
        val minute = alarmtime.get(Calendar.MINUTE)
        alarmtime.set(year, month, date, hour, minute, 0)
        setAlarm(alarmtime.timeInMillis, AlarmBroadcastReceiver.ALARMSTART)
    }

    fun stop() {
       setAlarm(-1, AlarmBroadcastReceiver.ALARMSTOP)
    }

    fun setAlarm(militime : Long, action : String) {
        val intentalarm = Intent(applicationContext, AlarmBroadcastReceiver::class.java)
        intentalarm.putExtra(AlarmBroadcastReceiver.ALARMKEY, action)
        val pendingintent = PendingIntent.getBroadcast(applicationContext, 4356, intentalarm, PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmmanager = getSystemService(ALARM_SERVICE) as AlarmManager

        if (action == AlarmBroadcastReceiver.ALARMSTART) {
            alarmmanager.setExact(AlarmManager.RTC_WAKEUP, militime, pendingintent)
        }
        else if (action == AlarmBroadcastReceiver.ALARMSTOP) {
            alarmmanager.cancel(pendingintent)
            sendBroadcast(intentalarm)
        }
    }
}