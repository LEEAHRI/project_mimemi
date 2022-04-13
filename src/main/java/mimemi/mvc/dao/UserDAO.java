package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.UserDTO;

public interface UserDAO {
	
	/**
	 * �α��α��
	 * @param UserDTO(String userId, String userPwd)
	 * */
	UserDTO loginUser(UserDTO user) throws SQLException;
	
	/**
	 * ȸ�����Ա��
	 * @param UserDTO(String userId, String userName, String userPwd, String userPhone, String userBirth)
	 * 
	 * : ȸ������ �� �Է� ���� �����͸� �����ͼ� UserDTO�� insert
	 * */
	int insertUser(UserDTO user) throws SQLException;
	
	/**
	 * ���̵�ã��
	 * @param userName, userPhone
	 * @return  userId
	 * 
	 * : ���̵�ã�� Ŭ�� �� �̸��� �޴�����ȣ�� �Է¹޾� �ٷ� �˷��ش�.
	 * */
	String selectUserId(String userName, String userPhone) throws SQLException;
		
	/**
	 * ��й�ȣã��
	 * @param userId, userName, userPhone
	 * @return void
	 * 
	 * : ��й�ȣã�� Ŭ�� �� userId, userName, userPhone�� �Է¹ް�
	 * 	 DB�� ���ϰ� ��ġ�ϸ� ��й�ȣ ���� �޼ҵ� ȣ��
	 * 	 ture�� ��й�ȣ ���� �������� �̵�
	 * */
	boolean selectUserPwd(String userId, String userName, String userPhone) throws SQLException;
	
	/**
	 * User �˻��ϱ�
	 * @param String keyword
	 * field : �̸�/���� ���
	 * ���������� if ������~
	 * */
	List<UserDTO> selectByKeyword(String keyword, String field) throws SQLException;
	
	/**
	 * Id�� user�˻��ϱ�(id�� ������ ���ƾ߸� �˻���)
	 * */
	UserDTO selectByID(String userId) throws SQLException;
	
	/**
	 * ȸ������ ����
	 * : �ּ�, ��ȣ 
	 * */
	int updateUser(UserDTO user) throws SQLException;
	
	/**
	 * ��й�ȣ ����
	 * @param userId, userPwd
	 * */
	int updateUserPwd(String userId, String userPwd) throws SQLException;
	
	/**
	 * ȸ�� Ż��
	 * : userPwd�� �Է¹޾� DB�� ��ġ�ϸ� 1�� �����ϰ�, DB�� �ִ� Ż�𿩺� �ٲ�.
	 * */
	int deleteUser(String userId, String userPwd) throws SQLException;
	
	/**
	
	 * ���̵� �ߺ� üũ
	 
	boolean idCheck(String userId) throws SQLException;
	
	/**
	 * �޴��� ��ȣ �ߺ� üũ
	  
	boolean phoneCheck(String userPhone) throws SQLException;
	*/
}
