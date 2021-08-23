package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel MapRow(ResultSet resultSet) {
		try {
			UserModel users = new UserModel();
			users.setId(resultSet.getLong("id"));
			users.setName(resultSet.getString("username"));
			users.setPassword(resultSet.getString("password"));
			users.setFullname(resultSet.getString("fullname"));
			users.setStatus(resultSet.getInt("status"));
			users.setRoleid(resultSet.getLong("roleid"));			
			users.setCreateddate(resultSet.getTimestamp("createddate"));
			users.setCreatedby(resultSet.getString("createdby"));
			if(resultSet.getTimestamp("modifieddate") != null) {
				users.setModifieddate(resultSet.getTimestamp("modifieddate"));
			}
			if(resultSet.getString("modifiedby") != null) {
				users.setModifiedby(resultSet.getString("modifiedby"));
			}
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				users.setRole(role);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return users;
		} catch (SQLException e) {
			return null;
		}
	}

}
