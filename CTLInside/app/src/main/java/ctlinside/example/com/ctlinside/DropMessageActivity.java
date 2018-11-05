package ctlinside.example.com.ctlinside;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DropMessageActivity extends AppCompatActivity {
    Button sendbtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_message);
        sendbtn = (Button) findViewById(R.id.sendbtn);
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DropMessageActivity.this, EmpListActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Successfully Send!!", Toast.LENGTH_LONG).show();
            }
        });
    }

}
