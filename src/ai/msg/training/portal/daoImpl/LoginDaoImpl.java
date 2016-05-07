package ai.msg.training.portal.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ai.msg.training.portal.common.beans.Tenant;
import ai.msg.training.portal.common.beans.User;
import ai.msg.training.portal.common.utils.UserRowMapper;
import ai.msg.training.portal.dao.LoginDao;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean save(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User validation(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean userValidation(User bean) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public User get(String userId) {
		String sql ="SELECT user.tenantUserId,user.loginId,user.firstName,user.lastName,user.tenantAccountId,user.email,client.accountName,client.industryVertical FROM tenantUser user,tenantAccount client WHERE loginId = ? and user.tenantAccountId=client.accountId";
		 
		User user = (User)jdbcTemplate.queryForObject(
				sql, new Object[] { userId }, new UserRowMapper());
			
		return user;
	
		}
	public Tenant getTenantDetails(int tenantId){
		String sql="select * from tenantAccount where accountId=?";
		Tenant client = (Tenant)jdbcTemplate.queryForObject(
				sql, new Object[] { tenantId }, new RowMapper<Tenant>(){

					@Override
					public Tenant mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						Tenant tenant=new Tenant();
						tenant.setAccountId(rs.getString("accountId"));
						tenant.setAccountName(rs.getString("accountName"));
					//	tenant.setAccountUpdationDate(rs.getTimestamp(""));
						tenant.setAddressCountry(rs.getString("addressCountry"));
						tenant.setAddressLine1(rs.getString("addressLine1"));
						tenant.setAddressLine2(rs.getString("addressLine2"));
						tenant.setAddressLine3(rs.getString("addressLine3"));
						tenant.setIndustryVertical(rs.getString("industryVertical"));
						tenant.setBrandImage(rs.getString("brandImage"));
						return tenant;
					}
					
				});
			
		return client;
	}

}
