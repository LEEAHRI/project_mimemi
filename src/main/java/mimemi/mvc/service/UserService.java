package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import javax.security.sasl.AuthenticationException;

import mimemi.mvc.dto.AddrDTO;
import mimemi.mvc.dto.UserDTO;

public interface UserService {
	/**
	 * �α��α��
	 * @param UserDTO(String userId, String userPwd)
	 * @throws AuthenticationException 
	 * */
	UserDTO loginUser(String userId, String userPwd) throws SQLException, AuthenticationException;
	
	/**
	 * ȸ�����Ա��
	 * @param UserDTO(String userId, String userName, String userPwd, String userPhone, String userBirth)
	 * 
	 * : ȸ������ �� �Է� ���� �����͸� �����ͼ� UserDTO�� insert
	 * */
	void insertUser(UserDTO user, AddrDTO addr) throws SQLException;
	
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
	 * 	 true�� ��й�ȣ ���� �������� �̵�
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
	 * Id�� ����Ʈ �˻��ϱ�
	 * */
	int selectPointByUserId(String userId) throws SQLException;
	
	/**
	 * ȸ������ ����
	 * : �ּ�, ��ȣ 
	 * */
	void updateUser(UserDTO user) throws SQLException;
	
	/**
	 * ��й�ȣ ����
	 * @param userId, userPwd
	 * */
	void updateUserPwd(String userPwd) throws SQLException;
	
	/**
	 * ȸ�� Ż��
	 * : userPwd�� �Է¹޾� DB�� ��ġ�ϸ� 1�� �����ϰ�, DB�� �ִ� Ż�𿩺� �ٲ�.
	 * */
	void deleteUser(String userId, String userPwd) throws SQLException;
	
	/**
	 * ���̵� �ߺ� üũ
	 */
	boolean idCheck(String userId) throws SQLException;
	
	/**
	 * �޴��� ��ȣ �ߺ� üũ
	 */
	boolean phoneCheck(String userPhone) throws SQLException;
	
	/**
	 * ���̵� ���� üũ
	 * */
	boolean validId(String userId) throws SQLException;
	/**
	 * ��й�ȣ ���� üũ
	 * */
	boolean validPwd(String userPwd) throws SQLException;
}
