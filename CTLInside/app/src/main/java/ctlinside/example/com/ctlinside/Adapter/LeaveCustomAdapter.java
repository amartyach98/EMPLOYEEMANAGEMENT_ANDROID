package ctlinside.example.com.ctlinside.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ctlinside.example.com.ctlinside.DataHandler.LeaveCustomDataHandler;
import ctlinside.example.com.ctlinside.R;

public class LeaveCustomAdapter extends RecyclerView.Adapter<LeaveCustomAdapter.MyViewHolder> {


    private ArrayList<LeaveCustomDataHandler> list_members = new ArrayList<>();
    private final LayoutInflater inflater;
    View view;
    MyViewHolder holder;
    private Context context;


    public LeaveCustomAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    //This method inflates view present in the RecyclerView
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.leavereq_row, parent, false);
        holder = new MyViewHolder(view);
        return holder;
    }

    //Binding the data using get() method of POJO object
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        LeaveCustomDataHandler list_items = list_members.get(position);
        holder.emp_name.setText(list_items.getEmpname());
        holder.txt_reason.setText(list_items.getLeavereason());
        holder.txt_date.setText(list_items.getDate());
    }

    //Setting the arraylist


    public void setListContent(ArrayList<LeaveCustomDataHandler> list_members) {
        this.list_members = list_members;
        notifyItemRangeChanged(0, list_members.size());

    }


    @Override
    public int getItemCount() {
        return list_members.size();
    }


    //View holder class, where all view components are defined
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txt_reason, emp_name, txt_date;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txt_reason = (TextView) itemView.findViewById(R.id.txt_reason);
            emp_name = (TextView) itemView.findViewById(R.id.emp_name);
            txt_date = (TextView) itemView.findViewById(R.id.txt_date);


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
