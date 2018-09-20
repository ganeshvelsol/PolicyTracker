package policytracker.simplytextile.policytracker.activities;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import policytracker.simplytextile.policytracker.R;
import policytracker.simplytextile.policytracker.adapters.CustomerListAdapter;
import policytracker.simplytextile.policytracker.apis.ApiClient;
import policytracker.simplytextile.policytracker.apis.ApiService;
import policytracker.simplytextile.policytracker.crRespnse.CustomerResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerListActivity extends AppCompatActivity
{

    public static final String ss="name";
    RecyclerView customer_recycler;
    LinearLayoutManager llm;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_list);
        customer_recycler=(RecyclerView)findViewById(R.id.customer_recycler);
        llm=new LinearLayoutManager(this);
        ApiService planView = ApiClient.getClient().create(ApiService.class);
        Call<CustomerResponse> customers=planView.getCustomers();
        customers.enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response)
            {
                if (response.body().getStatuscode()==0)
                {
                    CustomerListAdapter adapter=new CustomerListAdapter(response.body().getData().getCustomer_list(),CustomerListActivity.this);;
                    customer_recycler.setAdapter(adapter);
                    customer_recycler.setLayoutManager(llm);
                }
                else
                {
                    Toast.makeText(CustomerListActivity.this, "from else"+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CustomerResponse> call, Throwable t)
            {
                Toast.makeText(CustomerListActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
