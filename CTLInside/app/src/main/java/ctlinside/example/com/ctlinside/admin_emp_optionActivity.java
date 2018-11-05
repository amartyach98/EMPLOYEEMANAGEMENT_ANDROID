package ctlinside.example.com.ctlinside;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class admin_emp_optionActivity extends AppCompatActivity {
    Button button_admin, button_employee;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_emp_option);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.black)); // Navigation bar the soft bottom of some phones like nexus and some Samsung note series
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.deepviolet)); //status bar or the time bar at the top
        }
        button_admin = (Button) findViewById(R.id.button_admin);
        button_employee = (Button) findViewById(R.id.button_employee);
        //on Admin Click
        button_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(admin_emp_optionActivity.this, LoginActivity.class);
                intent.putExtra("user", "Admin");
                startActivity(intent);
            }
        });
        //On Employee Click
        button_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(admin_emp_optionActivity.this,LoginActivity.class);
                intent.putExtra("user", "Employee");
                startActivity(intent);
            }
        });

    }
}
