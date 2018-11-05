package ctlinside.example.com.ctlinside;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import ctlinside.example.com.ctlinside.Adapter.CustomAdapter;
import ctlinside.example.com.ctlinside.DataHandler.CustomDataHandler;

public class EmpListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView;
    CustomAdapter adapter;
    private ArrayList<CustomDataHandler> listContentArr = new ArrayList<CustomDataHandler>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(EmpListActivity.this, "Single Click on position :" + position,
                        Toast.LENGTH_SHORT).show();

                if (position != RecyclerView.NO_POSITION) {
                    CustomDataHandler clickedDataItem = listContentArr.get(position);
                    String EmpName = clickedDataItem.getEmployeeName();
                    String EmpID = clickedDataItem.getEmployeeId().substring(clickedDataItem.getEmployeeId().lastIndexOf(":") + 1);
                    // Toast.makeText(getApplicationContext(), "Tenant Name " + clickedDataItem.getName(), Toast.LENGTH_SHORT).show();
                    // Toast.makeText(getApplicationContext(), "House Number " + clickedDataItem.getContent(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EmpListActivity.this, ActivityEmpDetailsForAdmin.class);
                    intent.putExtra("Emp_Name", EmpName);
                    intent.putExtra("Emp_ID", EmpID);
                    startActivity(intent);


                }

            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(EmpListActivity.this, "Long press on position :" + position,
                        Toast.LENGTH_LONG).show();
            }
        }));


        adapter = new CustomAdapter(this);
        //Method call for populating the view
        populateRecyclerViewValues();
    }


    private void populateRecyclerViewValues() {

        for (int iter = 0; iter <= 5; iter++) {
            if (iter == 1) {
                CustomDataHandler dataHandler = new CustomDataHandler();

                dataHandler.setEmployeeName("Employee 1");
                dataHandler.setEmployeeId("Employee Id: " + iter);
                dataHandler.setEmployeeDept("IT Dept");
                listContentArr.add(dataHandler);
            }
            if (iter == 2) {
                CustomDataHandler dataHandler2 = new CustomDataHandler();

                dataHandler2.setEmployeeName("Employee 2");
                dataHandler2.setEmployeeId("Employee Id: " + iter);
                dataHandler2.setEmployeeDept("IT Dept");
                listContentArr.add(dataHandler2);
            }
            if (iter == 3) {
                CustomDataHandler dataHandler3 = new CustomDataHandler();

                dataHandler3.setEmployeeName("Employee 3");
                dataHandler3.setEmployeeId("Employee Id: " + iter);
                dataHandler3.setEmployeeDept("IT Dept");
                listContentArr.add(dataHandler3);
            }

            if (iter == 4) {
                CustomDataHandler dataHandler4 = new CustomDataHandler();

                dataHandler4.setEmployeeName("Employee 4");
                dataHandler4.setEmployeeId("Employee Id: " + iter);
                dataHandler4.setEmployeeDept("IT Dept");
                listContentArr.add(dataHandler4);
            }

            if (iter == 5) {
                CustomDataHandler dataHandler5 = new CustomDataHandler();

                dataHandler5.setEmployeeName("Employee 5");
                dataHandler5.setEmployeeId("Employee Id: " + iter);
                dataHandler5.setEmployeeDept("IT Dept");
                listContentArr.add(dataHandler5);
            }


        }
        //We set the array to the adapter
        adapter.setListContent(listContentArr);
        //We in turn set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
    }

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.emp_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_addemp) {
            Intent intent = new Intent(EmpListActivity.this, AddEmployeeActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_leavereq) {
            Intent intent = new Intent(EmpListActivity.this, LeaveRequestApproveActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_complains) {

        } else if (id == R.id.nav_messages) {
            Intent intent = new Intent(EmpListActivity.this, DropMessageActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_Logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private ClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView, final ClickListener clicklistener) {

            this.clicklistener = clicklistener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recycleView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clicklistener != null) {
                        clicklistener.onLongClick(child, recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clicklistener != null && gestureDetector.onTouchEvent(e)) {
                clicklistener.onClick(child, rv.getChildAdapterPosition(child));
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
