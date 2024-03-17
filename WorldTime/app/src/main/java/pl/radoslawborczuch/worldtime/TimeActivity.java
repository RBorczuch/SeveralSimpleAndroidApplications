package pl.radoslawborczuch.worldtime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TimeActivity extends AppCompatActivity {



    TextView timeText;
    TextView wordTime;
    long startTime = 0;

    Calendar calendarDate =  Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");



    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            calendarDate.add(Calendar.SECOND, 1);
            timeText.setText(  dateFormat.format(calendarDate.getTime())  );

            //New York
            wordTime = (TextView) findViewById(R.id.text_NewYork);
            calendarDate.add(Calendar.HOUR_OF_DAY, -6);
            wordTime.setText(  dateFormat.format(calendarDate.getTime())  );
            calendarDate.add(Calendar.HOUR_OF_DAY, +6);

            //London
            wordTime = (TextView) findViewById(R.id.text_London);
            calendarDate.add(Calendar.HOUR_OF_DAY, -1);
            wordTime.setText(  dateFormat.format(calendarDate.getTime())  );
            calendarDate.add(Calendar.HOUR_OF_DAY, +1);

            //Tokyo
            wordTime = (TextView) findViewById(R.id.text_Tokyo);
            calendarDate.add(Calendar.HOUR_OF_DAY, 7);
            wordTime.setText(  dateFormat.format(calendarDate.getTime())  );
            calendarDate.add(Calendar.HOUR_OF_DAY, -7);


            timerHandler.postDelayed(this, 1000);
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        calendarDate.setTime(new Date());


        timeText = (TextView) findViewById(R.id.mobile_time);

        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);

    }


    @Override
    public void onPause() {
        super.onPause();
    }



}