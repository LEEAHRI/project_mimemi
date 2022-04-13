package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.UserDTO;

public interface UserDAO {
	
	/**
	 * �α��α��
	 * */
	UserDTO loginCheck(UserDTO userDTO) throws SQLException;
	
	/**
	 * ȸ�����Ա��
	 * 
	 * : ȸ������ �� �Է� ���� �����͸� �����ͼ� UserDTO�� insert
	 * */
	int insertUser(UserDTO userDTO) throws SQLException;
	
	/**
	 * ���̵�ã��
	 * @param userName, userPhone
	 * 
	 * : ���̵�ã�� Ŭ�� �� �̸��� �޴�����ȣ�� �Է¹޾� �ٷ� �˷��ش�.
	 * */
	String selectUserId(String userName, String userPhone) throws SQLException;
	
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
	int updateUser(UserDTO userDTO) throws SQLException;
	
	/**
	 * ��й�ȣ ����
	 * */
	int updateUserPwd(String userPwd) throws SQLException;
	
	/**
	 * ȸ�� Ż��
	 * : userPwd�� �Է¹޾� DB�� ��ġ�ϸ� 1�� �����ϰ�, DB�� �ִ� Ż�𿩺� �ٲ�.
	 * */
	int deleteUser(String userPwd) throws SQLException;
}
