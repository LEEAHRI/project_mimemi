package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.DayMealDTO;

public interface DayMealDAO {
	/**
	 * ���� �Ĵ� ���
	 * @param: DayMenuDTO(int dayMenuId, String mealId, String goodsId, String dayMenuDate)
	 * @return: int(��ϵ� ������ ��)
	 * */
	int insert(DayMealDTO dayMenu) throws SQLException;
	
	/**
	 * ���� �Ĵ� ����
	 * @param: int dayMenuId, String mealId
	 * @return: int(������ ������ ��)
	 * */
	int update(int dayMenuId, String mealId) throws SQLException;
	
	/**
	 * �̴��� ���� �Ĵ� ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<MealDTO>(goodsSale�� true�� ��ǰ)
	 * */
	List<DayMealDTO> selectForSale(String sort, String date) throws SQLException;
	
	/**
	 * ��� �Ĵ� ��ȸ
	 * 1. �Ķ���ͷ� ���̵� ���� ��
	 * 2. �ֹ�, �ֹ� ��, �ֹ� �� ��� ������ ������ �ش� ���̵��� ���� ����&��� ��¥ ��������
	 * 3. ��ǰ, �Ǹ� ���ö�, ���� �Ĵ��� ������ ���� ���� ���� ��¥�� �������� �޴��� ������
	 * 4. ������ DayMenu ����Ʈ�� ����� ������
	 * @param: String userId
	 * @return:List<DayMenuDTO>(���̵� �������� ������� ��� �Ĵ� ����Ʈ)
	 * */
	List<DayMealDTO> selectByUserOrder(String userId) throws SQLException;
}
