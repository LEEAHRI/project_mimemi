package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.UserDTO;

public interface UserService {
	/**
	 * �α��α��
	 * select user_id , pwd, name from users where user_id=? and pwd=?
	 * */
	UserDTO loginCheck(UserDTO userDTO) throws SQLException;
	
	/**
	 * ȸ�����Ա��
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
	 * : �޴�����ȣ�� ����?
	 * */
	void updateUser(UserDTO userDTO) throws SQLException;
	
	/**
	 * ��й�ȣ ����
	 * */
	void updateUserPwd(String userPwd) throws SQLException;
	
	/**
	 * ȸ�� Ż��
	 * : userPwd�� �Է¹޾� DB�� ��ġ�ϸ� 1�� �����ϰ�, DB�� �ִ� Ż�𿩺� �ٲ�.
	 * */
	void deleteUser(String userPwd) throws SQLException;
}
