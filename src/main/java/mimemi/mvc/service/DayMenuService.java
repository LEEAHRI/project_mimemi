package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.DayMenuDTO;
import mimemi.mvc.dto.MealDTO;
import mimemi.mvc.dto.MealDTO;

public interface DayMenuService {
	/**
	 * ���� �Ĵ� ���
	 * @param: DayMenuDTO(int dayMenuId, String mealId, String goodsId, String dayMenuDate)
	 * */
	void insert(DayMenuDTO dayMenu) throws SQLException;
	
	/**
	 * ���� �Ĵ� ����
	 * @param: DayMenuDTO(int dayMenuId, String mealId)
	 * */
	void update(DayMenuDTO dayMenu) throws SQLException;
	
	/**
	 * ���� �Ĵ� ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<MealDTO>(��ü ��ǰ�� ��� �����͸� ������ ��)
	 * */
	List<DayMenuDTO> selectAll(String sort) throws SQLException;
	
	/**
	 * �̴��� ���� �Ĵ� ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<MealDTO>(goodsSale�� true�� ��ǰ)
	 * */
	List<DayMenuDTO> selectForSale(String sort, String date) throws SQLException;
	
	/**
	 * ��¥�� ��ǰ������ ���� �Ĵ� ��ȸ
	 * @param: ��ȸ�� ��ǰ �ڵ�
	 * @return: DayMenuDTO(�μ��� ���� ��¥�� ��ǰ ���̵� ������ ��ǰ)
	 * */
	DayMenuDTO selectByMealId(String date, String goodsId) throws SQLException;
	
	/**
	 * ��� �Ĵ� ��ȸ
	 * 1. �Ķ���ͷ� ���̵� ���� ��
	 * 2. �ֹ�, �ֹ� ��, �ֹ� ��� ��� ������ ������ �ش� ���̵��� ���� ���� ��������
	 * 3. ��ǰ, �Ǹ� ���ö�, ���� �Ĵ��� ������ ���� ���� ���� ��¥�� �������� �޴��� ������
	 * 4. ������ DayMenu ����Ʈ�� ����� ������
	 * @param: String userId
	 * @return:List<DayMenuDTO>(���̵� �������� ������� ��� �Ĵ� ����Ʈ)
	 * */
	List<DayMenuDTO> selectByUserOrder(String userId) throws SQLException;
}
