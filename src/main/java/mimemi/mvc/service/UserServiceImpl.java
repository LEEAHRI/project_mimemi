package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import javax.security.sasl.AuthenticationException;

import mimemi.mvc.dao.UserDAO;
import mimemi.mvc.dao.UserDAOImpl;
import mimemi.mvc.dto.UserDTO;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO = new UserDAOImpl();

	@Override
	public UserDTO loginUser(UserDTO user) throws SQLException, AuthenticationException {
		UserDTO userDTO = userDAO.loginUser(user);
		if(userDTO == null) {
			throw new AuthenticationException("아이디와 비밀번호를 확인해주세요");
		}
		return userDTO;
	}

	@Override
	public void insertUser(UserDTO user) throws SQLException {
		int result = userDAO.insertUser(user);
		if(result==0) {throw new SQLException("회원가입에 실패했습니다.");
		
		}

	}

	@Override
	public String selectUserId(String userName, String userPhone) throws SQLException {
		String result = userDAO.selectUserId(userName, userPhone);
		if(result==null) {throw new SQLException("해당하는 정보가 없습니다.");}
		return result;
	}

	@Override
	public boolean selectUserPwd(String userId, String userName, String userPhone) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserDTO> selectByKeyword(String keyword, String field) throws SQLException {
		// TODO Auto-generated method stub
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
	public void updateUserPwd(String userId, String userPwd) throws SQLException {
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
