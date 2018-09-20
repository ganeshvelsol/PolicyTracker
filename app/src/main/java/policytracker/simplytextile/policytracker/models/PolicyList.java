package policytracker.simplytextile.policytracker.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Velsol 170016 on 9/20/2018.
 */

public class PolicyList
{
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("customer")
    @Expose
    private Customer customer;
//    @SerializedName("agent")
//    @Expose
//    private Agent_ agent;
    @SerializedName("company")
    @Expose
    private Company company;
//    @SerializedName("policy_type")
//    @Expose
//    private PolicyType_ policy_type;
//    @SerializedName("policy_type_sub")
//    @Expose
//    private PolicyTypeSub policy_type_sub;
//    @SerializedName("policy_status")
//    @Expose
//    private PolicyStatus policy_status;
//    @SerializedName("coverage_info")
//    @Expose
//    private CoverageInfo coverage_info;
    @SerializedName("renewal_info")
    @Expose
    private RenewalInfo renewal_info;
//    @SerializedName("premium_info")
//    @Expose
//    private PremiumInfo premium_info;
//    @SerializedName("insured_type")
//    @Expose
//    private InsuredType insured_type;
    @SerializedName("policy_number")
    @Expose
    private String policy_number;
    @SerializedName("insured_details")
    @Expose
    private String insured_details;
    @SerializedName("product_name")
    @Expose
    private String product_name;
    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("commission_amount")
    @Expose
    private Integer commission_amount;
    @SerializedName("parent_id")
    @Expose
    private Object parent_id;
    @SerializedName("grace_days")
    @Expose
    private Integer grace_days;
//    @SerializedName("more")
//    @Expose
//    private More____ more;
    @SerializedName("update_counter")
    @Expose
    private Integer update_counter;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("last_updated")
    @Expose
    private String last_updated;
    @SerializedName("lapsation_date")
    @Expose
    private String lapsation_date;
//    @SerializedName("insured_info")
//    @Expose
//    private InsuredInfo insured_info;
//    @SerializedName("notification_info")
//    @Expose
//    private NotificationInfo notification_info;
    @SerializedName("beneficiary_information")
    @Expose
    private String beneficiary_information;
    @SerializedName("last_update")
    @Expose
    private String last_update;
}
