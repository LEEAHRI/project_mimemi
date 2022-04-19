package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.GoodsDTO;

public interface GoodsService {
	/**
	 * ��ǰ ���
	 * @param: GoodsDTO(String goodsId, String goodsName, String goodsDetail, String goodsThumbnail,
	 * 		   int goodsPrice, String goodsDetailImg)
	 * */
	void goodsInsert(GoodsDTO goods) throws SQLException;
	
	/**
	 * ��ǰ ����
	 * @param: GoodsDTO(String goodsId, String goodsName, String goodsDetail, int goodsPrice)
	 * */
	void goodsUpdate(GoodsDTO goods) throws SQLException;
	
	/**
	 * ��ǰ �Ǹ� ���� ����
	 * @param: String goodsId, String goodsSale
	 * */
	void goodsUpdateForSale(String goodsId, String goodsSale) throws SQLException;
	
	/**
	 * ��ǰ ����� ����
	 * @param: String goodsId, String goodsThumbnail
	 * */
	void goodsUpdateThumbnail(String goodsId, String goodsThumbnail) throws SQLException;
			
	/**
	 * ��ü ��ǰ��ȸ (��ǰ ����� ��������)
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<GoodsDTO>(��ü ��ǰ�� ��� �����͸� ������ ��)
	 * 
	 * 
	 */
	public List<GoodsDTO> goodsSelectAll() throws SQLException;
	/**
	 * �Ǹ� ���� ��ǰ ��ȸ
	 * @return: List<GoodsDTO>(goodsSale�� Y�� ��ǰ)
	 * */
	public List<GoodsDTO> goodsSelectForSale() throws SQLException;
	
	/**
	 * ��ǰ������ ��ǰ ��ȸ
	 * @param: �̸��� �ش� Ű���尡 ������ üũ�� Ű���带 ����
	 * @return: List<GoodsDTO>(��ǰ�� Ű���尡 ���� ��ǰ)
	 * */
	public List<GoodsDTO> goodsSelectByKeyword(String keyword) throws SQLException;
	
	/**
	 * ��ǰ�ڵ�� ��ǰ ��ȸ
	 * @param: ��ȸ�� ��ǰ �ڵ�
	 * @return: GoodsDTO(�μ��� ���� ID�� ��ǰ ���̵� ������ ��ǰ)
	 * */
	GoodsDTO selectByGoodsId(String goodsId) throws SQLException;

	/**
	 * ���� �ֹ��� �Ĵܸ� ��������
	 * @param String userId
	 * @return List<GoodsDTO>
	 * */
	List<GoodsDTO> selectOrderGoods(String userId) throws SQLException;
	
}
