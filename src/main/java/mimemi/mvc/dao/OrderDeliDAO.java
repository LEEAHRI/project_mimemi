package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.OrderDeliDTO;
import mimemi.mvc.dto.OrderStateDTO;

public interface OrderDeliDAO {
	
	/**
	 * ��� ���� ����
	 * @param: OrderDeliDTO(int orderDeliId, String orderDeliDate)
	 * @return: int(������ ������ ��)
	 * */
	int updateDeliDate(int orderDeliId, String orderDeliDate) throws SQLException;
	
	/**
	 * ��� �ڵ� ����
	 * @param: OrderDeliDTO(int orderDeliId, String orderStateId)
	 * @return: int(������ ������ ��)
	 * */
	int updateStateId(int orderDeliId, String orderStateId) throws SQLException;
	
	/**
	 * �ֹ� �� �ڵ�� ��� ������ ��ȸ
	 * @param: OrderDeliDTO(intoorderLineId)
	 * @return: List<OrderDeliDTO>
	 * */
	List<OrderDeliDTO> selectByOrderLineId(int orderLineId) throws SQLException;
	
	/**
	 * �ֹ� ���� �ڵ� ��������
	 * @return: List<OrderStateDTO>
	 * */
	List<OrderStateDTO> selectOrderState() throws SQLException;
}
