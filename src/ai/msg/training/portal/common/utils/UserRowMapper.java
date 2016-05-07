package ai.msg.training.portal.common.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ai.msg.training.portal.common.beans.User;

public class UserRowMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		
	    user.setTenantUserId(rs.getInt("tenantUserId"));
		user.setTenantAccountId(rs.getInt("tenantAccountId"));
/*		user.setAccountName("accountName");
		user.setIndustryVertical("industryVertical");*/
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setLoginId(rs.getString("loginId"));
		user.setEmail(rs.getString("email"));
		
		/*user.setCustId(rs.getInt("CUST_ID"));
		user.setName(rs.getString("NAME"));
		user.setAge(rs.getInt("AGE"));*/
		return user;
	}
	

}
