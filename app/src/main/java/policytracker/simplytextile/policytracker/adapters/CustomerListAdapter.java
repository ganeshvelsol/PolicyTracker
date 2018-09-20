package policytracker.simplytextile.policytracker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import policytracker.simplytextile.policytracker.R;
import policytracker.simplytextile.policytracker.response.CustomerList;

/**
 * Created by Velsol 170016 on 9/20/2018.
 */

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.ViewHolderss>
{
    List<CustomerList> customer_list;
    Context context;

    public CustomerListAdapter(List<CustomerList> customer_list, Context context) {
        this.customer_list = customer_list;
        this.context = context;
    }

    @Override
    public CustomerListAdapter.ViewHolderss onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_details_admin, parent, false);
        return new ViewHolderss(view);
    }

    @Override
    public void onBindViewHolder(CustomerListAdapter.ViewHolderss holder, int position) {
        holder.mtext.setText(""+customer_list.get(position).getId()+" ("+customer_list.get(position).getFirst_name()+" )");

        holder.lastname_customer.setText(""+customer_list.get(position).getLast_name());
        holder.mobile.setText(""+customer_list.get(position).getAddress().getPhone1());
        holder.customer_id_proof_proof.setText(""+customer_list.get(position).getId()+" ( "+customer_list.get(position).getGovt_id_number()+" )");
        holder.customer_address.setText(""+customer_list.get(position).getAddress().getAddress1()+","+customer_list.get(position).getAddress().getCity()+","+
        customer_list.get(position).getAddress().getState()+","+customer_list.get(position).getAddress().getZip());
        holder.customer_email.setText(""+customer_list.get(position).getAddress().getEmail1());
        holder.customer_dob.setText(""+customer_list.get(position).getDate_of_birth());
    }

    @Override
    public int getItemCount() {
        return customer_list.size();
    }
    class ViewHolderss extends RecyclerView.ViewHolder
    {
        TextView mtext,lastname_customer,mobile,customer_id_proof_proof,customer_address,customer_email,customer_dob;
        public ViewHolderss(View itemView) {
            super(itemView);
            mtext=(TextView)itemView.findViewById(R.id.mtext_customer_id_name);
            lastname_customer=(TextView)itemView.findViewById(R.id.lastname_customer);
            mobile=(TextView)itemView.findViewById(R.id.mobile);
            customer_id_proof_proof=(TextView)itemView.findViewById(R.id.customer_id_proof_proof);
            customer_address=(TextView)itemView.findViewById(R.id.customer_address);
            customer_email=(TextView)itemView.findViewById(R.id.customer_email);
            customer_dob=(TextView)itemView.findViewById(R.id.customer_dob);
        }
    }
}
