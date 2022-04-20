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
	int mealInsert(MealDTO meal) throws SQLException;
	
	/**
	 * �Ǹ� ���ö� ����
	 * @param: MealDTO(String mealId, String mealName, int mealWeight, int mealKcal, int mealCarbo,
	 * 			int mealProtein, int mealFat)
	 * @return: int(������ ������ ��)
	 * */
	int mealUpdate(MealDTO meal) throws SQLException;
	
	/**
	 * �Ǹ� ���ö� �Ǹ� ���� ����
	 * : �Ǹ� ���ö��� �Ǹ� ���� �÷��� ����
	 * @param: MealDTO(String mealId, boolean mealSale)
	 * @return: int(������ ������ ��)
	 * */
	int mealUpdateForSale(String mealId, String mealSale) throws SQLException;
	
	/**
	 * ��ü ���ö� ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<MealDTO>(��ü ��ǰ�� ��� �����͸� ������ ��)
	 * */
	List<MealDTO> mealSelectAll() throws SQLException;
	
	/**
	 * �Ǹ� ���� ���ö� ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<MealDTO>(goodsSale�� true�� ��ǰ)
	 * */
	List<MealDTO> mealSelectForSale() throws SQLException;
	
	/**
	 * ���ö� ID�� ��ȸ
	 * @return
	 * @throws SQLException
	 */
	List<MealDTO> mealSelectByMealId(String keyword) throws SQLException;
}
