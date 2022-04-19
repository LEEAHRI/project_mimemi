package mimemi.mvc.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.List;
import mimemi.mvc.util.DbUtil;
import mimemi.mvc.dto.DayMealDTO;

public class DayMealDAOImpl implements DayMealDAO {
	private Properties proFile = new Properties();
	
	/**
	 * dbQuery.properties �ε��� Properties ��ü�� ����
	 * */
	public DayMealDAOImpl() {
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public int insert(DayMealDTO dayMenu) throws SQLException;
	
	/**
	 * ���� �Ĵ� ����
	 * @param: int dayMenuId, String mealId
	 * @return: int(������ ������ ��)
	 * */
	public int update(int dayMenuId, String mealId) throws SQLException;
	
	/**
	 * �̴��� ���� �Ĵ� ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<MealDTO>(goodsSale�� true�� ��ǰ)
	 * */
	public List<DayMealDTO> selectForSale(String sort, String date) throws SQLException;
	
	/**
	 * ��� �Ĵ� ��ȸ
	 * 1. �Ķ���ͷ� ���̵� ���� ��
	 * 2. �ֹ�, �ֹ� ��, �ֹ� �� ��� ������ ������ �ش� ���̵��� ���� ����&��� ��¥ ��������
	 * 3. ��ǰ, �Ǹ� ���ö�, ���� �Ĵ��� ������ ���� ���� ���� ��¥�� �������� �޴��� ������
	 * 4. ������ DayMenu ����Ʈ�� ����� ������
	 * @param: String userId
	 * @return:List<DayMenuDTO>(���̵� �������� ������� ��� �Ĵ� ����Ʈ)
	 * */
	public List<DayMealDTO> selectByUserOrder(String userId) throws SQLException;

}
