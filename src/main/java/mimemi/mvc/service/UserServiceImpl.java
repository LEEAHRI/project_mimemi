package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import javax.security.sasl.AuthenticationException;

import mimemi.mvc.dao.AddrDAO;
import mimemi.mvc.dao.AddrDAOImpl;
import mimemi.mvc.dao.UserDAO;
import mimemi.mvc.dao.UserDAOImpl;
import mimemi.mvc.dto.UserDTO;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO = new UserDAOImpl();
	private AddrDAO addrDAO = new AddrDAOImpl();

	@Override
	public UserDTO loginUser(String userId, String userPwd) throws SQLException, AuthenticationException {
		UserDTO userDTO = userDAO.loginUser(userId, userPwd);
		if(userDTO == null) {
			
			throw new AuthenticationException("���̵�� ��й�ȣ�� Ȯ�����ּ���");
		}
		return userDTO;
	}

	@Override
	public void insertUser(UserDTO user) throws SQLException {
		int result = userDAO.insertUser(user);
		if(result==0) {throw new SQLException("ȸ�����Կ� �����߽��ϴ�.");
		
		}
		

	}

	@Override
	public String selectUserId(String userName, String userPhone) throws SQLException {
		String result = userDAO.selectUserId(userName, userPhone);
		if(result==null) {throw new SQLException("�ش��ϴ� ������ �����ϴ�.");}
		return result;
	}

	@Override
	public boolean selectUserPwd(String userId, String userName, String userPhone) throws SQLException {
		boolean result = userDAO.selectUserPwd(userId, userName, userPhone);
		
		if(result == false) {throw new SQLException("�ش� ������ �������� �ʽ��ϴ�.");

		}else {
			return true;
		}
	}
		
	

	@Override
	public List<UserDTO> selectByKeyword(String keyword, String field) throws SQLException {
		
		return null;
	}

	@Override
	public UserDTO selectByID(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(UserDTO user) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUserPwd(String userId, String userPwd, String userName) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String userId, String userPwd) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean idCheck(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean phoneCheck(String userPhone) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
