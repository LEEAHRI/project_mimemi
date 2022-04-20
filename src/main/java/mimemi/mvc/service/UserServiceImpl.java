package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import javax.security.sasl.AuthenticationException;

import mimemi.mvc.dao.AddrDAO;
import mimemi.mvc.dao.AddrDAOImpl;
import mimemi.mvc.dao.UserDAO;
import mimemi.mvc.dao.UserDAOImpl;
import mimemi.mvc.dto.AddrDTO;
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
	public void insertUser(UserDTO user, AddrDTO addr) throws SQLException {
		int result = userDAO.insertUser(user,addr);
		if(result==0) {throw new SQLException("ȸ�����Կ� �����߽��ϴ�.");
		}
		if( !validId(user.getUserId()) || !validPwd(user.getUserPwd()) || !validPhone(user.getUserPhone()) ) {
			throw new SQLException("ȸ�����Կ� �����߽��ϴ�.");
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
	public int selectPointByUserId(String userId) throws SQLException {
		int result = userDAO.selectPointByUserId(userId);
		if(result<0) {throw new SQLException("�ش� ���̵� ���� ������ �����ϴ�.");		
		}else {
			return result;	
		}		
	}

	@Override
	public List<UserDTO> selectByKeyword(String keyword, String field) throws SQLException {
		List<UserDTO> userlist = userDAO.selectUserByKeyword(keyword, field);
		if(userlist==null) {throw new SQLException("�ش������� �������� �ʽ��ϴ�.");
		
		}
		return userlist;
	}

	@Override
	public UserDTO selectByID(String userId) throws SQLException {
		UserDTO userDTO = userDAO.selectByID(userId);
		if(userDTO==null) {throw new SQLException("�Է����� ���̵� ���� ������ �������� �ʽ��ϴ�.");}
		return userDTO;
	}
	@Override
	public UserDTO selectByPhone(String userPhone) throws SQLException {
		UserDTO userDTO = userDAO.selectByPhone(userPhone);
		if(userDTO==null) {throw new SQLException("�Է����� ��ȣ�� ���� ������ �������� �ʽ��ϴ�.");}
		return userDTO;
	}
	@Override
	public void updateUser(UserDTO user) throws SQLException {
		

	}

	@Override
	public void updateUserPwd(String userPwd) throws SQLException {
		int result = userDAO.updateUserPwd(userPwd, userPwd);
		if(result != 1) {
			throw new SQLException("��й�ȣ ���濡 �����߽��ϴ�.");
		}

	}

	@Override
	public void deleteUser(String userId, String userPwd) throws SQLException {
		int result = userDAO.deleteUser(userId, userPwd);
		if(result != 1)
			throw new SQLException(userId + "���� ȸ��Ż�� �����߽��ϴ�.");
	}

	@Override
	public boolean idCheck(String userId) throws SQLException {
		UserDTO userDTO = userDAO.selectByID(userId);
		if(userDTO != null) {
			return true;
		}else {
		return false;
		}
	}

	@Override
	public boolean phoneCheck(String userPhone) throws SQLException {
		UserDTO userDTO = userDAO.selectByID(userPhone);
		if(userDTO != null) {
			return true;
		}else {
		return false;
		}
	}

	@Override
	public boolean validId(String userId) throws SQLException {
		boolean hasDigit = false;
		boolean hasLower = false;
		boolean isLength = userId.length() >= 6 && userId.length() <= 20;
		
		for(int i=0; i<userId.length(); i++) {
			char c = userId.charAt(i);
			if(c>='0' && c<= '9') {
				hasDigit = true;
			}else if(c>='a' && c<='z') {
				hasLower = true;
			}
		}
		if( !hasDigit || !hasLower || !isLength) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean validPwd(String userPwd) throws SQLException {
		boolean hasDigit = false;
		boolean hasLower = false;
		boolean hasUpper = false;
		boolean islength = userPwd.length() >= 8 && userPwd.length() <= 15;

		for (int i = 0; i < userPwd.length(); i++) {
			char c = userPwd.charAt(i);
			if (c >= '0' && c <= '9') {
				hasDigit = true;
			} else if (c >= 'a' && c <= 'z') {
				hasLower = true;
        	} else if(c >= 'A' && c<='Z') {
        		hasUpper = true;
			}
		}

		if (!hasDigit || !hasLower || !hasUpper || !islength ) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean validPhone(String userPhone) throws SQLException {
		if(!userPhone.startsWith("010")){
			return false;
		}
		if(userPhone.length() != 11) {
			return false;
		}
		return true;
	}
}
