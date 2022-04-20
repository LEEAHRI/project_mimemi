package mimemi.mvc.dao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import mimemi.mvc.dto.MealDTO;

public class DayMealDAOImpl implements DayMealDAO {
	private Properties proFile = new Properties();
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
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
	
	/**
	 * ���� �Ĵ� ��� 
	 */
	public int dayMealInsert(DayMealDTO dayMeal) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("daymeal.insert");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, dayMeal.getDayMenuId());
			ps.setString(2, dayMeal.getMealId());
			ps.setString(3, dayMeal.getMealId());
			ps.setString(4, dayMeal.getDayMenuDate());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	
	/**
	 * ���� �Ĵ� ����
	 * @param: int dayMenuId, String mealId
	 * @return: int(������ ������ ��)
	 * */
//	public int dayMealUpdate(int dayMenuId, String mealId) throws SQLException {
//		Connection con = null;
//		PreparedStatement ps = null;
//		int result = 0;
//		String sql = proFile.getProperty("daymeal.update");
//		try {
//			con = DbUtil.getConnection();
//			ps = con.prepareStatement(sql);
//			ps.setString(1, mealId);
//			ps.setString(2, mealId);
//			ps.setInt(3, dayMenuId);
//			result = ps.executeUpdate();
//		} finally {
//			DbUtil.dbClose(ps, con);
//			
//		}
//		return result;
//	}
	
	/**
	 * ���� �Ĵ� ����
	 * @param: int dayMenuId, String mealId
	 * @return: int(������ ������ ��)
	 * */
	public int dayMealUpdate(DayMealDTO dayMeal) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("daymeal.update"); 
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dayMeal.getMealId());
			ps.setString(2, dayMeal.getMealId());
			ps.setString(3, dayMeal.getDayMenuDate());
			ps.setInt(4, dayMeal.getDayMenuId());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	
	/**
	 * �̴��� ���� �Ĵ� ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<MealDTO>(goodsSale�� true�� ��ǰ)
	 * */
	public List<DayMealDTO> selectByMonth(String month) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<DayMealDTO> list = new ArrayList<DayMealDTO>();
		String sql = proFile.getProperty("daymeal.selectByMonth");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "2022/" + String.format("%02d" , Integer.parseInt(month)) + "/01");
			rs = ps.executeQuery();
			while (rs.next()) {
				DayMealDTO daymeal = new DayMealDTO(rs.getInt(1), rs.getString(2), rs.getString(3), dateFormat.format(rs.getDate(4)));
				list.add(daymeal);
			}
		} finally {
			DbUtil.dbClose(ps, con);
			
		}
		return list;
	}
	
	/**
	 * ��� �Ĵ� ��ȸ
	 * 1. �Ķ���ͷ� ���̵� ���� ��
	 * 2. �ֹ�, �ֹ� ��, �ֹ� �� ��� ������ ������ �ش� ���̵��� ���� ����&��� ��¥ ��������
	 * 3. ��ǰ, �Ǹ� ���ö�, ���� �Ĵ��� ������ ���� ���� ���� ��¥�� �������� �޴��� ������
	 * 4. ������ DayMenu ����Ʈ�� ����� ������
	 * @param: String userId
	 * @return:List<DayMenuDTO>(���̵� �������� ������� ��� �Ĵ� ����Ʈ)
	 * */
	public List<DayMealDTO> selectByUserOrder(String userId) throws SQLException {
		return null;
	}
}
