package policytracker.simplytextile.policytracker.crRespnse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import policytracker.simplytextile.policytracker.response.Data;

/**
 * Created by Velsol 170016 on 9/20/2018.
 */

public class PoliciesResponse
{
    @SerializedName("statuscode")
    @Expose
    private Integer statuscode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public Integer getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(Integer statuscode) {
        this.statuscode = statuscode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
