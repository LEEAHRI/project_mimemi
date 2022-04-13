package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.UserDTO;

public interface UserService {
	/**
	 * �α��α��
	 * @param UserDTO(String userId, String userPwd)
	 * 
	 * select user_id , pwd, name from users where user_id=? and pwd=?
	 * */
	UserDTO loginCheck(UserDTO userDTO) throws SQLException;
	
	/**
	 * ȸ�����Ա��
	 * @param UserDTO(String userId, String userName, String userPwd, String userPhone, int userPoint, String userRegdate,
		boolean userQuit, String userBirth)
	 * 
	 * : ȸ������ �� �Է� ���� �����͸� �����ͼ� UserDTO�� insert
	 * */
	void insertUser(UserDTO userDTO) throws SQLException;
	
	/**
	 * ���̵�ã��
	 * @param userName, userPhone
	 * 
	 * : ���̵�ã�� Ŭ�� �� �̸��� �޴�����ȣ�� �Է¹޾� �ٷ� �˷��ش�.
	 * */
	void selectUserId(String userName, String userPhone) throws SQLException;
	
	/**
	 * ��й�ȣã��
	 * @param userId, userName, userPhone
	 * 
	 * : ��й�ȣã�� Ŭ�� �� userId, userName, userPhone�� �Է¹ް�
	 * 	 DB�� ���ϰ� ��ġ�ϸ� ��й�ȣ ���� �޼ҵ� ȣ��
	 * */
	void selectUserPwd(String userId, String userName, String userPhone) throws SQLException;
	
	/**
	 * ������Ϸ� Userã�� (���� ���� �� ���)
	 * @param userBirth
	 * 
	 * :Ư�� �޿� ������ ������ ��ȸ
	 * */
	List<UserDTO> selectByUserBirth(String userBirth) throws SQLException;
	
	/**
	 * ȸ������ ����
	 * @param UserDTO(String userPhone)
	 * : �޴�����ȣ�� ����?
	 * */
	void updateUser(UserDTO userDTO) throws SQLException;
	
	/**
	 * ��й�ȣ ����
	 * @param String userPwd
	 * */
	void updateUserPwd(String userPwd) throws SQLException;
	
	/**
	 * ȸ�� Ż��
	 * @param String userPwd
	 * : userPwd�� �Է¹޾� DB�� ��ġ�ϸ� 1�� �����ϰ�, DB�� �ִ� Ż�𿩺� �ٲ�.(DB���� �����ϴ°��� �ƴ�)
	 * */
	void deleteUser(String userPwd) throws SQLException;
}
