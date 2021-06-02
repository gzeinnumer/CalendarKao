package com.gzeinnumer.calendarkao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import com.gzeinnumer.calendarkao.ui.dialog.CustomMyLibDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(), year + "-" + month + "-" + dayOfMonth, Toast.LENGTH_SHORT).show();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment previous = getSupportFragmentManager().findFragmentByTag(CustomMyLibDialog.TAG);
                if(previous != null){
                    transaction.remove(previous);
                }
                CustomMyLibDialog dialog = CustomMyLibDialog.newInstance();
                dialog.show(transaction, CustomMyLibDialog.TAG);
            }
        });
    }
}