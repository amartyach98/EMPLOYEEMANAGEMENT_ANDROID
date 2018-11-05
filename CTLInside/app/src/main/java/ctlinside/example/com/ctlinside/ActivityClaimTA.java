package ctlinside.example.com.ctlinside;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ActivityClaimTA extends AppCompatActivity {
    AppCompatSpinner spinner_Client_Name;
    AppCompatSpinner spinner_Project_Type;
    int GALLERY = 2;
    int REQUEST_IMAGE_CAPTURE = 4;
    String clientname, projecttype;
    RelativeLayout rl_pickphoto, rl_takephoto;
    Button submitbtn;
    String[] clientnamelist = {"Client Name*", "NEC", "CERAGON", "TVS", "ZTE", "HUAWEI", "CAMPUS VISIT"};
    String[] projecttypelist = {"Project Name*", "INC (MICROWAVE)", "INC (BTS)", "LOS SURVEY", "RFI SURVEY", "DRIVE TEST", "SWAPPING", "DISMENTAL", "CAMPUS VISIT (HR) DEPARTMENT"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim_ta);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.deepviolet));
        }
        rl_pickphoto = (RelativeLayout) findViewById(R.id.rl_pickphoto);
        rl_takephoto = (RelativeLayout) findViewById(R.id.rl_takephoto);
        submitbtn = (Button) findViewById(R.id.submitbtn);
        spinner_Client_Name = (AppCompatSpinner) findViewById(R.id.spinner_Client_Name);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, clientnamelist);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_Client_Name.setSelection(0);
        //Setting the ArrayAdapter data on the Spinner
        spinner_Client_Name.setAdapter(aa);
        spinner_Project_Type = (AppCompatSpinner) findViewById(R.id.spinner_Project_Type);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, projecttypelist);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_Project_Type.setSelection(0);
        //Setting the ArrayAdapter data on the Spinner
        spinner_Project_Type.setAdapter(aa2);
        spinner_Client_Name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                } else {
                    clientname = spinner_Client_Name.getItemAtPosition(position).toString();

                    Toast.makeText(getApplicationContext(), clientname, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner_Project_Type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                } else {
                    projecttype = spinner_Project_Type.getItemAtPosition(position).toString();

                    Toast.makeText(getApplicationContext(), projecttype, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityClaimTA.this, ActivityEmpDetailsForEmployee.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left);
                Toast.makeText(getApplicationContext(), "Leave Successfully Applied!!", Toast.LENGTH_LONG).show();
            }
        });

        rl_pickphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, GALLERY);
            }
        });
        rl_takephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY) {
            if (resultCode == ActivityClaimTA.RESULT_OK) {
                if (data != null && data.getData() != null) {
                    Uri uri = data.getData();


                }
            } else if (resultCode == ActivityClaimTA.RESULT_CANCELED) {

            }
        }

    }
}

