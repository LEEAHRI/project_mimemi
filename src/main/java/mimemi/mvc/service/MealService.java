package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.MealDTO;
import mimemi.mvc.dto.MealDTO;

public interface MealService {
	/**
	 * �Ǹ� ���ö� ���
	 * @param: MealDTO(String mealId, String goodsId, String mealName, int mealWeight, int mealKcal,
	 * 			int mealCarbo, int mealProtein, int mealFat)
	 * */
	void mealInsert(MealDTO meal) throws SQLException;
	
	/**
	 * �Ǹ� ���ö� ����
	 * @param: MealDTO(String mealId, String mealName, int mealWeight, int mealKcal, int mealCarbo,
	 * 			int mealProtein, int mealFat)
	 * */
	void mealUpdate(MealDTO meal) throws SQLException;
	
	/**
	 * �Ǹ� ���ö� �Ǹ� ���� ����
	 * : �Ǹ� ���ö��� �Ǹ� ���� �÷��� ����
	 * @param: MealDTO(String mealId, boolean mealSale)
	 * */
	void mealUpdateForSale(String mealId, String mealSale) throws SQLException;
	
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
	 * ���ö� �ڵ�� ���ö� ��ȸ
	 * @param: ��ȸ�� ���ö� �ڵ�
	 * @return: MealDTO(�μ��� ���� ID�� ���ö� ���̵� ������ ��ǰ)
	 * */
	List<MealDTO> mealSelectByMealId(String mealId) throws SQLException;
}
