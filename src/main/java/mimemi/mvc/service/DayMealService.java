package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.DayMealDTO;
import mimemi.mvc.dto.MealDTO;
import mimemi.mvc.dto.MealDTO;

public interface DayMealService {
	/**
	 * ���� �Ĵ� ���
	 * @param: DayMenuDTO(int dayMenuId, String mealId, String goodsId, String dayMenuDate)
	 * */
	void dayMealInsert(DayMealDTO dayMeal) throws SQLException;
	
	/**
	 * ���� �Ĵ� ����
	 * @param: int dayMenuId, String mealId
	 * */
	void dayMealUpdate(DayMealDTO dayMeal) throws SQLException;
	
	
	/**
	 * ���� �Ĵ� ��ü ��ȸ
	 * @return
	 * @throws SQLException
	 */
	List<DayMealDTO> selectAll() throws SQLException;
	
	/**
	 * �̴��� ���� �Ĵ� ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<MealDTO>(goodsSale�� true�� ��ǰ)
	 * */
	List<DayMealDTO> selectByMonth(String date) throws SQLException;
	
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
