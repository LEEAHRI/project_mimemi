package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dao.DayMealDAO;
import mimemi.mvc.dao.DayMealDAOImpl;
import mimemi.mvc.dto.DayMealDTO;
import mimemi.mvc.dto.MealDTO;

public class DayMealServiceImpl implements DayMealService {

	private DayMealDAO dayMealDAO = new DayMealDAOImpl();
	
	@Override
	public void dayMealInsert(DayMealDTO dayMeal) throws SQLException {
		int result = dayMealDAO.dayMealInsert(dayMeal);
		if(result == 0) {
			throw new SQLException("���ö��� ��ϵ��� �ʾҽ��ϴ�");
		}
	}
	
	public void dayMealUpdate(DayMealDTO dayMeal) throws SQLException {
		int result = dayMealDAO.dayMealUpdate(dayMeal);
		if(result == 0) {
			throw new SQLException("���ö��� �������� �ʾҽ��ϴ�");
		}
	}

	@Override
	public List<DayMealDTO> selectByMonth(String date) throws SQLException {
		List<DayMealDTO> list = dayMealDAO.selectByMonth(date);
		if(list.size() == 0 || list.isEmpty()) {
			throw new SQLException("���ö��� ������ ���� �˻��� �� �����ϴ�.");
		}
		return list;
	}

	@Override
	public List<DayMealDTO> selectByUserOrder(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
