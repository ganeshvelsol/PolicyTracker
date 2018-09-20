package policytracker.simplytextile.policytracker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import policytracker.simplytextile.policytracker.R;
import policytracker.simplytextile.policytracker.models.AgentList;

/**
 * Created by Velsol 170016 on 9/20/2018.
 */

public class AgentsListAdapter extends RecyclerView.Adapter<AgentsListAdapter.ViewHolders>
{
    List<AgentList> agentList;
    Context context;

    public AgentsListAdapter(List<AgentList> agentList, Context context) {
        this.agentList = agentList;
        this.context = context;
    }

    @Override
    public AgentsListAdapter.ViewHolders onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.agents_list_adapter, parent, false);
        return new ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(AgentsListAdapter.ViewHolders holder, int position)
    {

        holder.agents_id_name.setText(""+agentList.get(position).getId()+" ( "+agentList.get(position).getFirst_name()+" )");
        holder.agents_id_lastname.setText(""+agentList.get(position).getLast_name());
        holder.agents_id_business_name.setText(""+agentList.get(position).getBusiness_name());
        holder.agents_id_govt_details.setText(""+agentList.get(position).getGovt_id_number()+" ( "+agentList.get(position).getAadhar_number());
        holder.agents_id_cretaed_on.setText(""+agentList.get(position).getCreated());
        holder.agents_id_address.setText(""+agentList.get(position).getAddress().getAddress1()+","+agentList.get(position).getAddress().getCity()+","+
        agentList.get(position).getAddress().getState()+","+agentList.get(position).getAddress().getZip());
        holder.agents_id_phone.setText(""+agentList.get(position).getAddress().getPhone1());
        holder.agents_id_email.setText(""+agentList.get(position).getAddress().getEmail1());
    }

    @Override
    public int getItemCount() {
        return agentList.size();
    }
    class ViewHolders extends RecyclerView.ViewHolder
    {
        TextView agents_id_email,agents_id_phone,agents_id_address,agents_id_cretaed_on,agents_id_govt_details,
                agents_id_business_name,agents_id_lastname,agents_id_name;
        public ViewHolders(View itemView)
        {
            super(itemView);
            agents_id_name=(TextView)itemView.findViewById(R.id.agents_id_name);
            agents_id_lastname=(TextView)itemView.findViewById(R.id.agents_id_lastname);
            agents_id_business_name=(TextView)itemView.findViewById(R.id.agents_id_business_name);
            agents_id_govt_details=(TextView)itemView.findViewById(R.id.agents_id_govt_details);
            agents_id_cretaed_on=(TextView)itemView.findViewById(R.id.agents_id_cretaed_on);
            agents_id_address=(TextView)itemView.findViewById(R.id.agents_id_address);
            agents_id_phone=(TextView)itemView.findViewById(R.id.agents_id_phone);
            agents_id_email=(TextView)itemView.findViewById(R.id.agents_id_email);
        }
    }
}
