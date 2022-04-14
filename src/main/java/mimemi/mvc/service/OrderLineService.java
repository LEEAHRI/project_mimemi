package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.OrderLineDTO;

public interface OrderLineService {
	
	
	/**
	 * �ֹ��� ��ȸ
	 * @param orderId
	 * @return
	 * @throws SQLException
	 */
	List<OrderLineDTO> selectByOrderId(int orderId) throws SQLException;
	
	/**
	 * �ֹ��� �߰�
	 * @param orderLine
	 * @throws SQLException
	 */
	void insert(OrderLineDTO orderLine) throws SQLException;
	
	/**
	 * �ֹ��� ����
	 * @param orderLineId
	 * @throws SQLException
	 */
	void delete(int orderLineId) throws SQLException;
	
	/**
	 * �ֹ��� ����
	 * @param orderLine
	 * @throws SQLException
	 */
	
	void updatOrderLine (OrderLineDTO orderLine) throws SQLException;
	
	

}
