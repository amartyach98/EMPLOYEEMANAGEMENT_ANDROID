package ctlinside.example.com.ctlinside;

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
import android.widget.LinearLayout;

public class LoginActivity extends AppCompatActivity {
    Button login_button;
    String user;

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        user = intent.getStringExtra("user");
        // Toast.makeText(getApplicationContext(), user, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.deepviolet));
        }
        login_button = (Button) findViewById(R.id.login_button);
        //To Login User
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(LoginActivity.this);
                View mView = layoutInflater.inflate(R.layout.loginsuccess, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(LoginActivity.this);
                alertDialogBuilderUserInput.setView(mView);

                alertDialogBuilderUserInput.setCancelable(false)
                        .setNegativeButton("", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (user.equals("Admin")) {
                            Intent intent = new Intent(LoginActivity.this, EmpListActivity.class);
                            startActivity(intent);
                        } else if (user.equals("Employee")) {
                            Intent intent = new Intent(LoginActivity.this, ActivityEmpDetailsForEmployee.class);
                            startActivity(intent);
                        }

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

                Button positiveButton = alertDialogAndroid.getButton(AlertDialog.BUTTON_POSITIVE);
                LinearLayout parent = (LinearLayout) positiveButton.getParent();
                parent.setGravity(Gravity.CENTER_HORIZONTAL);
                View leftSpacer = parent.getChildAt(1);
                leftSpacer.setVisibility(View.GONE);
            }
        });
    }
}
