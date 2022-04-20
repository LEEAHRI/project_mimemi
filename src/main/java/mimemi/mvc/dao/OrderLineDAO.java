package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.OrderDeliDTO;
import mimemi.mvc.dto.OrderLineDTO;

public interface OrderLineDAO {

	/**
	 * �ֹ� �� ����(���)
	 * @param int orderLineId(���� ���� ���̵� �������� ��� �������� ��� ��� ó����)
	 * @return int(������ ���ڵ� ��)
	 */
	int delete(int orderLineId) throws SQLException;
	
	/**
	 * ���� ���̵�� �ֹ� �� ��ȸ
	 * @param int orderId(���� ���̵� �ش��ϴ� �ֹ� �� ��������)
	 * @return List<OrderLineDTO>
	 */
	List<OrderLineDTO> selectLineByOrderId(int orderId) throws SQLException;

}