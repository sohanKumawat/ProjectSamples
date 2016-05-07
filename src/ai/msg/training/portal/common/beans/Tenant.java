package ai.msg.training.portal.common.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope(value="session")
public class Tenant implements Serializable{


	
	private static final long serialVersionUID = 1000002222222L;
    
	public static List<String> convRoutings=new ArrayList<String>();
	
	private String accountId;
    private String accountName;
    private String industryVertical;
    private String addressLine1;
    private String addressLine2;
	private String addressLine3;
    private String addressCountry;
    private Date accountCreationDate;
    private Date accountUpdationDate;
    private String brandImage;
    private String convRouting;    
    static {
    	convRoutings.add("AUTO");
    	convRoutings.add("HYBRID");
    	convRoutings.add("MANUAL");
    }
    
    
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getIndustryVertical() {
		return industryVertical;
	}
	public void setIndustryVertical(String industryVertical) {
		this.industryVertical = industryVertical;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public String getAddressCountry() {
		return addressCountry;
	}
	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}
	public Date getAccountCreationDate() {
		return accountCreationDate;
	}
	public void setAccountCreationDate(Date accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}
	public Date getAccountUpdationDate() {
		return accountUpdationDate;
	}
	public void setAccountUpdationDate(Date accountUpdationDate) {
		this.accountUpdationDate = accountUpdationDate;
	}
	public String getBrandImage() {
		return brandImage;
	}
	public void setBrandImage(String brandImage) {
		this.brandImage = brandImage;
	}
	
	public String getConvRouting() {
		return convRouting;
	}
	
	public void setConvRouting(String convRouting) {
		this.convRouting = convRouting;
	}
	
	public static String getConvRoutingMode(int code){
		return convRoutings.get(code);
	}
	
}
