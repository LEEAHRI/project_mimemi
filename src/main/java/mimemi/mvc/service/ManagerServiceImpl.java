package mimemi.mvc.service;

import java.sql.SQLException;

import javax.security.sasl.AuthenticationException;

import mimemi.mvc.dao.ManagerDAO;
import mimemi.mvc.dao.ManagerDAOImpl;
import mimemi.mvc.dto.ManagerDTO;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDAO managerDAO = new ManagerDAOImpl();

	@Override
	public ManagerDTO loginManager(String managerId, String managerPwd) throws SQLException, AuthenticationException {
		ManagerDTO managerDTO = managerDAO.loginManager(managerId, managerPwd);
		if(managerDTO == null) {
			
			throw new AuthenticationException("���̵�� ��й�ȣ�� Ȯ�����ּ���");
		}
		return managerDTO;
	}

}
