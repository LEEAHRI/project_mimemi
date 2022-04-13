package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.MealDTO;
import mimemi.mvc.dto.MealDTO;

public interface MealService {
	/**
	 * �Ǹ� ���ö� ���
	 * @param: MealDTO(String mealId, String goodsId, String mealName, int mealWeight, int mealCarbo,
	 * 			int mealProtein, int mealFat)
	 * */
	void insert(MealDTO meal) throws SQLException;
	
	/**
	 * �Ǹ� ���ö� ����
	 * @param: MealDTO(String mealId, String goodsId, String mealName, int mealWeight, int mealCarbo,
	 * 			int mealProtein, int mealFat)
	 * */
	void update(MealDTO meal) throws SQLException;
	
	/**
	 * �Ǹ� ���ö� ����
	 * : ���� �����ϴ� ���� �ƴ϶� �Ǹ� ���� �÷��� ������ ���� ����Ʈ���� ������ �ʵ��� ó����
	 * @param: MealDTO(String mealId, boolean mealSale)
	 * */
	void delete(MealDTO meal) throws SQLException;
	
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
