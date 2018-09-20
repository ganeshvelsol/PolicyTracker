package policytracker.simplytextile.policytracker.apis;

import java.util.List;

import policytracker.simplytextile.policytracker.activities.CustomerListActivity;
import policytracker.simplytextile.policytracker.crRespnse.CustomerResponse;
import policytracker.simplytextile.policytracker.crRespnse.PoliciesResponse;
import policytracker.simplytextile.policytracker.response.AgentsResponse;
import policytracker.simplytextile.policytracker.response.SubscribersResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ApiService
{
//    @Headers("Content-Type: application/json")
//    @POST("api/subscribers/")
//    Call<SignUpResponse> signupdetails(@Body Subscriber subscriber);



//    @FormUrlEncoded
//    @POST("api/users/me/login")
//    Call<LoginResponse> Logindetails(@Field("login_name") String login_name,
//                                     @Field("password") String password);


//    @GET("api/companies")
//     Call<List<CompanyList>> getCompany(Callback<List<CompanyList>> successs);

    @Headers("Content-Type:application/json")
    @POST("api/subscribers")

    Call<SubscribersResponse> getUser(@Body String body);


   @Headers({"Content-Type:application/json"
           ,"app_sid:37a559d3bcd211e8be14aa3a52b410b4"})
    @GET("api/customers")
    Call<CustomerResponse> getCustomers();

   ///api/agents/

    @Headers({"Content-Type:application/json"
            ,"app_sid:37a559d3bcd211e8be14aa3a52b410b4"})
    @GET("api/agents/")
    Call<AgentsResponse> getAgents();


    //api/policies
    @Headers({"Content-Type:application/json"
            ,"app_sid:37a559d3bcd211e8be14aa3a52b410b4"})
    @GET("api/policies")
    Call<PoliciesResponse> getPolicies();

}
