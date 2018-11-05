package ctlinside.example.com.ctlinside;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class LeaveRequestActivity extends AppCompatActivity {
    RelativeLayout rl_fdate, rl_tdate;
    DatePickerDialog datePickerDialog;
    TextView txt_fromdate, txt_todate;
    Button applybtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_request);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.deepviolet));
        }
        rl_fdate = (RelativeLayout) findViewById(R.id.rl_fdate);
        rl_tdate = (RelativeLayout) findViewById(R.id.rl_todate);
        txt_fromdate = (TextView) findViewById(R.id.txt_fromdate);
        applybtn = (Button) findViewById(R.id.applybtn);
        txt_todate = (TextView) findViewById(R.id.txt_tdate);
        rl_fdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(LeaveRequestActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the textview
                                txt_fromdate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.getDatePicker().setMaxDate(c.getTimeInMillis() + TimeUnit.MILLISECONDS.convert(7, TimeUnit.DAYS));
            }
        });


        rl_tdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(LeaveRequestActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the textview
                                txt_fromdate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.getDatePicker().setMaxDate(c.getTimeInMillis() + TimeUnit.MILLISECONDS.convert(60, TimeUnit.DAYS));
            }
        });


        applybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeaveRequestActivity.this, ActivityEmpDetailsForEmployee.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left);
                Toast.makeText(getApplicationContext(), "Leave Successfully Applied!!", Toast.LENGTH_LONG).show();

            }
        });
    }
}
