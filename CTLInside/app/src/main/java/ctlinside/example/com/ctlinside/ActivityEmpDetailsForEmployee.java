package ctlinside.example.com.ctlinside;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class ActivityEmpDetailsForEmployee extends AppCompatActivity {
    RelativeLayout rl_dtod, rl_acheivements, rl_mymessages, rl_personaldetails;
    Button btn_leavereq, claimtabtn;
    Toolbar app_bar;
    ImageView back;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.moreoptions, menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.doc_downloads:
                itemdownload();
                return true;
            case R.id.emp_ChangePassword:
                Toast.makeText(getApplicationContext(), "Change Password Tapped!!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.emp_LogOut:
                itemlogout();
                Toast.makeText(getApplicationContext(), "Log Out Tapped!!", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_details_for_employee);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.deepviolet));
        }
        rl_dtod = (RelativeLayout) findViewById(R.id.rl_dtod);
        btn_leavereq = (Button) findViewById(R.id.btn_leavereq);
        rl_acheivements = (RelativeLayout) findViewById(R.id.rl_acheivements);

        rl_mymessages = (RelativeLayout) findViewById(R.id.rl_mymessages);
        rl_personaldetails = (RelativeLayout) findViewById(R.id.rl_personaldetails);
        claimtabtn = (Button) findViewById(R.id.claimtabtn);
        app_bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(app_bar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.threedots);
        app_bar.setOverflowIcon(drawable);

        btn_leavereq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityEmpDetailsForEmployee.this, LeaveRequestActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_right);
            }
        });

        rl_dtod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(ActivityEmpDetailsForEmployee.this);
                View mView = layoutInflater.inflate(R.layout.dtod_dialog, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(ActivityEmpDetailsForEmployee.this);
                alertDialogBuilderUserInput.setView(mView);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                            }
                        })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.dismiss();
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
                Button negetiveButton = alertDialogAndroid.getButton(AlertDialog.BUTTON_NEGATIVE);
                LinearLayout parent = (LinearLayout) negetiveButton.getParent();
                parent.setGravity(Gravity.CENTER_HORIZONTAL);
                View leftSpacer = parent.getChildAt(1);
                leftSpacer.setVisibility(View.GONE);
            }
        });

        claimtabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityEmpDetailsForEmployee.this, ActivityClaimTA.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_right);
            }
        });

        rl_acheivements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityEmpDetailsForEmployee.this, EmployeeAcheivementActivity.class);
                startActivity(intent);
            }
        });
        rl_personaldetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityEmpDetailsForEmployee.this, PersonalDetailsActivity.class);
                startActivity(intent);
            }
        });
        rl_mymessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityEmpDetailsForEmployee.this, EmployeeMyMessages.class);
                startActivity(intent);
            }
        });
    }


    public void itemdownload() {
        LayoutInflater layoutInflater = LayoutInflater.from(ActivityEmpDetailsForEmployee.this);
        View mView = layoutInflater.inflate(R.layout.downloaddialog, null);
        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(ActivityEmpDetailsForEmployee.this);
        alertDialogBuilderUserInput.setView(mView);
        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton("Pay Slip", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
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


    }

    public void itemlogout() {
        LayoutInflater layoutInflater = LayoutInflater.from(ActivityEmpDetailsForEmployee.this);
        View mView = layoutInflater.inflate(R.layout.logoutdialog, null);
        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(ActivityEmpDetailsForEmployee.this);
        alertDialogBuilderUserInput.setView(mView);
        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {

                    }
                })
                .setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                dialogBox.cancel();
                            }
                        });

        final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
        alertDialogAndroid.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                alertDialogAndroid.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getColor(R.color.deepviolet));
                alertDialogAndroid.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getColor(R.color.deepviolet));

            }
        });
        alertDialogAndroid.show();
    }

}
