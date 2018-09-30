package policytracker.simplytextile.policytracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import policytracker.simplytextile.policytracker.apis.ApiClient;
import policytracker.simplytextile.policytracker.apis.ApiService;
import policytracker.simplytextile.policytracker.response.SubscribersResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity
{
    Button loginactivitybutton;
    TextView text_signup_mainactiivty;
    EditText usernameInput,passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }
    public void initViews()
    {
        loginactivitybutton=(Button)findViewById(R.id.loginactivitybutton);
        text_signup_mainactiivty=(TextView) findViewById(R.id.text_signup_mainactiivty);
        usernameInput=(EditText) findViewById(R.id.loginactivity_input_username);
        passwordInput=(EditText) findViewById(R.id.loginactivity_input_password);
        loginactivitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    functionalityWorks();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public void functionalityWorks() throws JSONException
    {
        ApiService planView = ApiClient.getClient().create(ApiService.class);

        final JSONObject parent=new JSONObject();

        JSONObject subscriber_elements=new JSONObject();
        subscriber_elements.put("id", 12);
        subscriber_elements.put("type_id", 6501);
        subscriber_elements.put("business_name", "somesha");
        subscriber_elements.put("first_name", "somesha");
        subscriber_elements.put("last_name", "last_na");
        subscriber_elements.put("aadhar_number", "");
        subscriber_elements.put("govt_id_number", "");
        subscriber_elements.put("irdai_number", "");



        JSONObject child_elements1=new JSONObject();
        child_elements1.put("address1", "");
        child_elements1.put("address2", "");
        child_elements1.put("address3", "");
        child_elements1.put("city", "");
        child_elements1.put("state", "");
        child_elements1.put("zip", "");
        child_elements1.put("email1", "sams@gmail.com");
        child_elements1.put("phone1", "5896321478");

        child_elements1.put("email2", "");
        child_elements1.put("phone2", "");

        subscriber_elements.put("address",child_elements1);

        JSONObject user_detils=new JSONObject();
        user_detils.put("login_name","name");
        user_detils.put("password","name");

        subscriber_elements.put("user",user_detils);


//        JSONArray company=new JSONArray();
//
//        JSONObject array_values=new JSONObject();
//
//        JSONObject policy_type_list=new JSONObject();
//
//        array_values.put("id","10056");
//        array_values.put("act_date","");
//        array_values.put("business_name","");
//        array_values.put("license_number","");
//
//
//        policy_type_list.put("id",5302);
//        policy_type_list.put("name","");
//        policy_type_list.put("description","");
//        policy_type_list.put("parent_id","");
//        policy_type_list.put("is_renewable",0);
//
//        array_values.put("policy_type",policy_type_list);
//        company.put(array_values);
        JSONObject policy_type_object =new JSONObject();
        policy_type_object.put("id",5302);
        policy_type_object.put("name","");
        policy_type_object.put("description","");
        policy_type_object.put("parent_id","");
        policy_type_object.put("is_renewable",0);


        JSONObject array_values=new JSONObject();
        array_values.put("id","10056");
        array_values.put("act_date","");
        array_values.put("business_name","");
        array_values.put("license_number","");
        array_values.put("policy_type",policy_type_object);

        JSONArray jarray=new JSONArray();
        jarray.put(array_values);






        subscriber_elements.put("company_list",jarray);

        parent.put("subscriber",subscriber_elements);


        Call<SubscribersResponse> da=planView.getUser(parent);
        da.enqueue(new Callback<SubscribersResponse>()
        {
            @Override
            public void onResponse(Call<SubscribersResponse> call, Response<SubscribersResponse> response)
            {
                if (response.body().getStatuscode()==0)
                {
                    Log.e("success",""+response.body().getStatuscode());
                    Toast.makeText(LoginActivity.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Log.e("success",""+parent);
                    Toast.makeText(LoginActivity.this, "else case"+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SubscribersResponse> call, Throwable t)
            {
                Toast.makeText(LoginActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
