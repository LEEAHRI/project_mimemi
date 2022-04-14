package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.MealDTO;
import mimemi.mvc.dto.OrderDTO;
import mimemi.mvc.dto.OrderDeliDTO;
import mimemi.mvc.dto.OrderLineDTO;
import mimemi.mvc.dto.MealDTO;

public interface OrderDeliService {
	/**
	 * ��� ������ ����
	 * @param: OrderDeliDTO(int orderDeliId, int orderLineCode, int orderStateId, String orderDeliDate)
	 * @return: int(��ϵ� ������ ��)
	 * */
	int insertDeli(OrderDeliDTO orderDeli) throws SQLException;
	
	/**
	 * ��� ���� ����
	 * @param: OrderDeliDTO(int orderDeliId, String orderDeliDate)
	 * @return: int(������ ������ ��)
	 * */
	int updateDeliDate(OrderDeliDTO orderDeli) throws SQLException;
	
	/**
	 * �ֹ� �� �ڵ�� ��� ������ ��ȸ
	 * @param: OrderDeliDTO(int orderDeliId, int orderStateId)
	 * @return: int(������ ������ ��)
	 * */
	List<OrderDeliDTO> selectByOrderLineId(int orderLineId) throws SQLException;
	
	/**
	 * ���� ��� ������ ��ȸ
	 * @param: OrderDeliDTO(int orderDeliId, int orderStateId)
	 * @return: int(������ ������ ��)
	 * */
	OrderDeliDTO selectByOrderDeliId(int orderDeliId) throws SQLException;
}
