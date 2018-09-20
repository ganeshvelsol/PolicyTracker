package policytracker.simplytextile.policytracker.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Velsol 170016 on 9/18/2018.
 */

public class Data
{

//    @SerializedName("subscriber")
//    @Expose
//    private Subscriber subscriber;

    @SerializedName("customer_list")
    @Expose
    private List<CustomerList> customer_list;
    @SerializedName("totalrecords")
    @Expose
    private Integer totalrecords;

    public List<CustomerList> getCustomer_list() {
        return customer_list;
    }

    public void setCustomer_list(List<CustomerList> customer_list) {
        this.customer_list = customer_list;
    }

    public Integer getTotalrecords() {
        return totalrecords;
    }

    public void setTotalrecords(Integer totalrecords) {
        this.totalrecords = totalrecords;
    }
}
