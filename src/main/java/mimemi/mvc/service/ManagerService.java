package mimemi.mvc.service;

import java.sql.SQLException;

import javax.security.sasl.AuthenticationException;

import mimemi.mvc.dto.ManagerDTO;

public interface ManagerService {
	/**
	 * �α��� ���
	 * @param ManagerDTO(String managerId, String managerPwd)
	 * @throws AuthenticationException 
	 * */
	ManagerDTO loginManager(String managerId, String managerPwd) throws SQLException, AuthenticationException;
}
