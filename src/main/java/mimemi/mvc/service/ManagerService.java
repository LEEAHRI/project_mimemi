package mimemi.mvc.service;

import java.sql.SQLException;

import mimemi.mvc.dto.ManagerDTO;

public interface ManagerService {
	/**
	 * �α��� ���
	 * @param ManagerDTO(String managerId, String managerPwd)
	 * */
	ManagerDTO loginCheck(ManagerDTO managerDTO) throws SQLException;
}
