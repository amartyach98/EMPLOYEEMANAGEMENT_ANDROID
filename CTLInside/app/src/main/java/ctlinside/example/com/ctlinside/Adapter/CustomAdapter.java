package ctlinside.example.com.ctlinside.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ctlinside.example.com.ctlinside.DataHandler.CustomDataHandler;
import ctlinside.example.com.ctlinside.R;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    //Creating an arraylist of POJO objects
    private ArrayList<CustomDataHandler> list_members = new ArrayList<>();
    private final LayoutInflater inflater;
    View view;
    MyViewHolder holder;
    private Context context;


    public CustomAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    //This method inflates view present in the RecyclerView
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.recycler_row_layout, parent, false);
        holder = new MyViewHolder(view);

        return holder;
    }

    //Binding the data using get() method of CustomAdapter object
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        CustomDataHandler list_items = list_members.get(position);
        holder.txt_Emp_Name.setText(list_items.getEmployeeName());
        holder.txt_Emp_Id.setText(list_items.getEmployeeId());
        holder.txt_dept.setText(list_items.getEmployeeDept());
    }

    //Setting the arraylist
    public void setListContent(ArrayList<CustomDataHandler> list_members) {
        this.list_members = list_members;
        notifyItemRangeChanged(0, list_members.size());

    }


    @Override
    public int getItemCount() {
        return list_members.size();
    }


    //View holder class, where all view components are defined
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txt_Emp_Name, txt_dept, txt_Emp_Id;

        public MyViewHolder(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txt_Emp_Name = (TextView) itemView.findViewById(R.id.txt_Emp_Name);
            txt_Emp_Id = (TextView) itemView.findViewById(R.id.txt_Emp_Id);
            txt_dept = (TextView) itemView.findViewById(R.id.txt_dept);

        }

        @Override
        public void onClick(View v) {
        }
    }

    public void removeAt(int position) {
        list_members.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(0, list_members.size());
    }

}
