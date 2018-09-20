package policytracker.simplytextile.policytracker.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import policytracker.simplytextile.policytracker.R;
import policytracker.simplytextile.policytracker.adapters.AgentsListAdapter;
import policytracker.simplytextile.policytracker.apis.ApiClient;
import policytracker.simplytextile.policytracker.apis.ApiService;
import policytracker.simplytextile.policytracker.response.AgentsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgentsActivityList extends AppCompatActivity
{
    RecyclerView agents_list_recycler;
    LinearLayoutManager llm;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents_list);
        agents_list_recycler=(RecyclerView)findViewById(R.id.agents_list_recycler);
        llm=new LinearLayoutManager(this);

        ApiService ps = ApiClient.getClient().create(ApiService.class);
        Call<AgentsResponse> agents=ps.getAgents();
        agents.enqueue(new Callback<AgentsResponse>() {
            @Override
            public void onResponse(Call<AgentsResponse> call, Response<AgentsResponse> response)
            {
                if (response.body().getStatuscode()==0)
                {
                    AgentsListAdapter adapter=new AgentsListAdapter(response.body().getData().getAgentList(),AgentsActivityList.this);
                    agents_list_recycler.setAdapter(adapter);
                    agents_list_recycler.setLayoutManager(llm);

                }
                else
                {
                    Toast.makeText(AgentsActivityList.this, "from else"+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AgentsResponse> call, Throwable t)
            {
                Toast.makeText(AgentsActivityList.this, "something went wrong", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
