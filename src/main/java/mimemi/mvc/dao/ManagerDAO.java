package mimemi.mvc.dao;

import java.sql.SQLException;

import mimemi.mvc.dto.ManagerDTO;

public interface ManagerDAO {
	
	/**
	 * �α��� ���
	 * @param ManagerDTO(String managerId, String managerPwd)
	 * */
	ManagerDTO loginCheck(ManagerDTO managerDTO) throws SQLException;
	
}
