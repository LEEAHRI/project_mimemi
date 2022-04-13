package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.MealDTO;

public interface MealDAO {
	/**
	 * �Ǹ� ���ö� ���
	 * @param: MealDTO(String mealId, String goodsId, String mealName, int mealWeight, int mealKcal, int mealCarbo,
	 * 			int mealProtein, int mealFat)
	 * @return: int(��ϵ� ������ ��)
	 * */
	int insert(MealDTO meal) throws SQLException;
	
	/**
	 * �Ǹ� ���ö� ����
	 * @param: MealDTO(String mealId, String mealName, int mealWeight, int mealKcal, int mealCarbo,
	 * 			int mealProtein, int mealFat)
	 * @return: int(������ ������ ��)
	 * */
	int update(MealDTO meal) throws SQLException;
	
	/**
	 * �Ǹ� ���ö� �Ǹ� ���� ����
	 * : �Ǹ� ���ö��� �Ǹ� ���� �÷��� ����
	 * @param: MealDTO(String mealId, boolean mealSale)
	 * @return: int(������ ������ ��)
	 * */
	int updateForSale(MealDTO meal) throws SQLException;
	
	/**
	 * ��ü ���ö� ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<MealDTO>(��ü ��ǰ�� ��� �����͸� ������ ��)
	 * */
	List<MealDTO> selectAll(String sort) throws SQLException;
	
	/**
	 * �Ǹ� ���� ���ö� ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<MealDTO>(goodsSale�� true�� ��ǰ)
	 * */
	List<MealDTO> selectForSale(String sort) throws SQLException;
	
	/**
	 * ���ö� �ڵ�� ���ö� ��ȸ
	 * @param: ��ȸ�� ���ö� �ڵ�
	 * @return: MealDTO(�μ��� ���� ID�� ���ö� ���̵� ������ ��ǰ)
	 * */
	MealDTO selectByMealId(String mealId) throws SQLException;
}
