package ctlinside.example.com.ctlinside;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class ActivityEmpDetailsForAdmin extends AppCompatActivity {
    RelativeLayout rl_calender, rl_background, rl_edit;
    DatePickerDialog datePickerDialog;
    TextView presentdate, txt_empid, txt_empname;
    String abc, efd;
    Button btn_pd;
    ImageView tick_img;

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        txt_empname = (TextView) findViewById(R.id.txt_empname);
        txt_empid = (TextView) findViewById(R.id.txt_empid);

        abc = intent.getStringExtra("Emp_Name");
        efd = intent.getStringExtra("Emp_ID").trim();
        // Toast.makeText(getApplicationContext(), emp_name + " " + emp_id, Toast.LENGTH_LONG).show();
        txt_empname.setText(abc.trim());
        txt_empid.setText(efd.trim());
        Toast.makeText(getApplicationContext(), abc + " " + efd, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_details_for_admin);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.deepviolet));
        }
        rl_background = (RelativeLayout) findViewById(R.id.rl_background);
        txt_empname = (TextView) findViewById(R.id.txt_Emp_Name);
        txt_empid = (TextView) findViewById(R.id.txt_Emp_Id);
        rl_edit = (RelativeLayout) findViewById(R.id.rl_edit);
        btn_pd = (Button) findViewById(R.id.btn_pd);
        presentdate = (TextView) findViewById(R.id.presentdate);
        rl_calender = (RelativeLayout) findViewById(R.id.rl_calnder);
        btn_pd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(ActivityEmpDetailsForAdmin.this);
                View mView = layoutInflaterAndroid.inflate(R.layout.revealpdialog, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(ActivityEmpDetailsForAdmin.this);
                alertDialogBuilderUserInput.setView(mView);

                final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);

                alertDialogBuilderUserInput.setCancelable(false)
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(ActivityEmpDetailsForAdmin.this,PersonalDetailsActivity.class);
                        startActivity(intent);
        //check password

                    }
                });
                final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        alertDialogAndroid.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getColor(R.color.deepviolet));
                    }
                });
                alertDialogAndroid.show();
            }
        });
        rl_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityEmpDetailsForAdmin.this, EmpListActivity.class);
                startActivity(intent);
            }
        });
        rl_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(ActivityEmpDetailsForAdmin.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the textview
                                presentdate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis() + TimeUnit.MILLISECONDS.convert(-45, TimeUnit.DAYS));
                datePickerDialog.getDatePicker().setMaxDate(c.getTimeInMillis() + TimeUnit.MILLISECONDS.convert(365, TimeUnit.DAYS));
            }
        });

        rl_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(ActivityEmpDetailsForAdmin.this);
                View mView = layoutInflater.inflate(R.layout.editforadmindialog, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(ActivityEmpDetailsForAdmin.this);
                alertDialogBuilderUserInput.setView(mView);
                alertDialogBuilderUserInput.setMessage("Choose what to edit");
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Salary", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {

                            }
                        })
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("P-D", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        alertDialogAndroid.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getColor(R.color.deepviolet));
                        alertDialogAndroid.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getColor(R.color.deepviolet));
                        alertDialogAndroid.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(getColor(R.color.deepviolet));
                    }
                });
                alertDialogAndroid.show();
                Button neutralButton = alertDialogAndroid.getButton(AlertDialog.BUTTON_NEUTRAL);
                LinearLayout parent = (LinearLayout) neutralButton.getParent();
                parent.setGravity(Gravity.CENTER_HORIZONTAL);
                View leftSpacer = parent.getChildAt(1);
                leftSpacer.setVisibility(View.GONE);
            }
        });
    }
}
