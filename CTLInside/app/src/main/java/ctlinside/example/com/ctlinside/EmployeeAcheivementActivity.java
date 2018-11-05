package ctlinside.example.com.ctlinside;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import ctlinside.example.com.ctlinside.Adapter.AcheivementsCustomAdapter;
import ctlinside.example.com.ctlinside.DataHandler.AcheivementsCustomDatahandler;


public class EmployeeAcheivementActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AcheivementsCustomAdapter adapter;
    private ArrayList<AcheivementsCustomDatahandler> listContentArr = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_acheivement);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.deepviolet));
        }

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //As explained in the tutorial, LineatLayoutManager tells the RecyclerView that the view
        //must be arranged in linear fashion
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(EmployeeAcheivementActivity.this, "Certificate will be download soon :" + position,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
//                Toast.makeText(EmployeeAcheivementActivity.this, "Long press on position :" + position,
//                        Toast.LENGTH_LONG).show();
            }
        }));


        adapter = new AcheivementsCustomAdapter(this);
        //Method call for populating the view
        populateRecyclerViewValues();

    }

    private void populateRecyclerViewValues() {
        /** This is where we pass the data to the adpater using POJO class.
         *  The for loop here is optional. I've just populated same data for 50 times.
         *  You can use a JSON object request to gather the required values and populate in the
         *  RecyclerView.
         * */
        for (int iter = 0; iter <= 50; iter++) {
            //Creating POJO class object
            AcheivementsCustomDatahandler pojoObject = new AcheivementsCustomDatahandler();
            //Values are binded using set method of the POJO class
            pojoObject.setAcheivemntname("Acheivement Name");

            listContentArr.add(pojoObject);
        }
        //We set the array to the adapter
        adapter.setListContent(listContentArr);
        //We in turn set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);

    }

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
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
