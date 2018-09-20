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




        JsonArray citiesArray = new JsonArray();

        JSONObject paramObject = new JSONObject();
        paramObject.put("subscriber", "");
        paramObject.put("id", "12");
        paramObject.put("type_id", "4384984938943");
        paramObject.put("business_name", "somesha");
        paramObject.put("first_name", "somesha");
        paramObject.put("last_name", "last_na");
        paramObject.put("aadhar_number", "963258741789");
        paramObject.put("govt_id_number", "12345");
        paramObject.put("irdai_number", "");
        paramObject.put("address", "");
        paramObject.put( "address1","hyd");
        paramObject.put("address2","wgl");
        paramObject.put("address3","wgl");
        paramObject.put("city","ss");
        paramObject.put("state","telangana");
        paramObject.put("zip","503621");
        paramObject.put("email1","vv@gmail.com");
        paramObject.put("phone1","9874563217");
        paramObject.put("email2","");
        paramObject.put( "phone2","");
        paramObject.put("address", citiesArray);
        paramObject.put("login_name", "sam");
        paramObject.put("password", "2222");
        citiesArray.add("company_list");
        paramObject.put("company_list",citiesArray);


        Call<SubscribersResponse> da=planView.getUser(paramObject.toString());
        da.enqueue(new Callback<SubscribersResponse>()
        {
            @Override
            public void onResponse(Call<SubscribersResponse> call, Response<SubscribersResponse> response)
            {
                if (response.body().getStatuscode()==0)
                {
                    Log.e("success",""+response.body().getStatuscode());
                    Toast.makeText(LoginActivity.this, "success"+response.body().getData(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Log.e("success",""+response.body().getStatuscode());
                    Toast.makeText(LoginActivity.this, "else case"+response.body().getData(), Toast.LENGTH_SHORT).show();
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
