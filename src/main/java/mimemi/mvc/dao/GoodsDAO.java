package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.GoodsDTO;

public interface GoodsDAO {
	/**
	 * ��ǰ ���
	 *
	 * */
	int goodsInsert(GoodsDTO goods) throws SQLException;
	
	/**
	 * ��ǰ ����
	
	 * */
	int goodsUpdate(GoodsDTO goods) throws SQLException;
	
	/**
	 * ��ǰ �Ǹ� ���� ����

	 * */
	int goodsUpdateForSale(String goodsId, String goodsSale) throws SQLException;
	
	/**
	 * ��ǰ ����� ����
	
	 * */
	int goodsUpdateThumbnail(String goodsId, String goodsThumbnail) throws SQLException;
	
	/**
	 *��ǰ ID�� ��ǰ ��ȸ
	 * @return
	 * @throws SQLException
	 */
	GoodsDTO goodsSelectByGoodsId(String goodsId) throws SQLException;
	/**
	 * ��ü ��ǰ ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<GoodsDTO>(��ü ��ǰ�� ��� �����͸� ������ ��)
	 * 
	 * }
	 * */
	List<GoodsDTO> goodsSelectAll() throws SQLException;
	
	/**
	 * keyword�� ��ǰ ��ȸ
	 */
	List<GoodsDTO> goodsSelectByKeyword(String keyword) throws SQLException;
	/**
	 * �Ǹ� ���� ��ǰ ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<GoodsDTO>(goodsSale�� Y�� ��ǰ)
	 * */
	List<GoodsDTO> goodsSelectForSale() throws SQLException;
	

	/**
	 * ���� �ֹ��� �Ĵܸ� ��������
	 * @param String userId
	 * @return List<GoodsDTO>
	 * */
	List<GoodsDTO> selectOrderGoods(String userId) throws SQLException;
}

