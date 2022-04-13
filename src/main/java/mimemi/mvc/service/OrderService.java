package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.MealDTO;
import mimemi.mvc.dto.OrderDeliDTO;
import mimemi.mvc.dto.MealDTO;

public interface OrderService {
	/**
	 * ��� ������ ����
	 * @param: OrderDeliDTO(int orderDeliId, int orderLineCode, int orderStateId, String orderDeliDate)
	 * */
	void insertDeli(OrderDeliDTO orderDeli) throws SQLException;
	
	/**
	 * ��� ���� ����
	 * @param: OrderDeliDTO(int orderDeliId, String orderDeliDate)
	 * */
	void updateDeliDate(OrderDeliDTO orderDeli) throws SQLException;
	
	/**
	 * ��� �ֹ� ���� ����
	 * @param: OrderDeliDTO(int orderDeliId, int orderStateId)
	 * */
	void updateDeliState(OrderDeliDTO orderDeli) throws SQLException;
}
