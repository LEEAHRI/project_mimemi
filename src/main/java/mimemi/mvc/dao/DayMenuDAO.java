package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.DayMenuDTO;

public interface DayMenuDAO {
	/**
	 * ���� �Ĵ� ���
	 * @param: DayMenuDTO(int dayMenuId, String mealId, String goodsId, String dayMenuDate)
	 * @return: int(��ϵ� ������ ��)
	 * */
	int insert(DayMenuDTO dayMenu) throws SQLException;
	
	/**
	 * ���� �Ĵ� ����
	 * @param: DayMenuDTO(int dayMenuId, String mealId)
	 * @return: int(������ ������ ��)
	 * */
	int update(DayMenuDTO dayMenu) throws SQLException;
	
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
