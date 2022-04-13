package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.MealDTO;

public interface MealDAO {
	/**
	 * �Ǹ� ���ö� ���
	 * @param: MealDTO(String mealId, String goodsId, String mealName, int mealWeight, int mealCarbo,
	 * 			int mealProtein, int mealFat)
	 * @return: int(��ϵ� ������ ��)
	 * */
	int insert(MealDTO meal) throws SQLException;
	
	/**
	 * �Ǹ� ���ö� ����
	 * @param: MealDTO(String mealId, String goodsId, String mealName, int mealWeight, int mealCarbo,
	 * 			int mealProtein, int mealFat)
	 * @return: int(������ ������ ��)
	 * */
	int update(MealDTO meal) throws SQLException;
	
	/**
	 * �Ǹ� ���ö� ����
	 * : ���� �����ϴ� ���� �ƴ϶� �Ǹ� ���� �÷��� ������ ���� ����Ʈ���� ������ �ʵ��� ó����
	 * @param: MealDTO(String mealId, boolean mealSale)
	 * @return: int(������ ������ ��)
	 * */
	int delete(MealDTO meal) throws SQLException;
	
	/**
	 * ��ü �Ǹ� ���ö� �̸� ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<MealDTO>(��ü �Ǹ� ���ö��� ���̵�� �̸��� ������ ��)
	 * */
	List<MealDTO> selectAllName(String sort) throws SQLException;
	
	/**
	 * ��ü ��ǰ ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<MealDTO>(��ü ��ǰ�� ��� �����͸� ������ ��)
	 * */
	List<MealDTO> selectAll(String sort) throws SQLException;
	
	/**
	 * �Ǹ� ���� ��ǰ ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<MealDTO>(goodsSale�� true�� ��ǰ)
	 * */
	List<MealDTO> selectForSale(String sort) throws SQLException;
	
	/**
	 * ��ǰ�ڵ�� ��ǰ ��ȸ
	 * @param: ��ȸ�� ��ǰ �ڵ�
	 * @return: MealDTO(�μ��� ���� ID�� ��ǰ ���̵� ������ ��ǰ)
	 * */
	MealDTO selectByMealId(String mealId) throws SQLException;
}
