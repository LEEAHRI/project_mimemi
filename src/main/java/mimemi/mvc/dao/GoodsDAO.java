package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.GoodsDTO;
import mimemi.mvc.service.Goods;

public interface GoodsDAO {
	/**
	 * ��ǰ ���
	 * @param: GoodsDTO(String goodsId, String goodsName, String goodsDetail, String goodsThumbnail,
	 * 		   int goodsPrice, String goodsDetailImg)
	 * @return: int(��ϵ� ������ ��)
	 * */
	int goodsInsert(GoodsDTO goods) throws SQLException;
	
	/**
	 * ��ǰ ����
	 * @param: GoodsDTO(String goodsId, String goodsName, String goodsDetail, int goodsPrice)
	 * @return: int(������ ������ ��)
	 * */
	int goodsUpdate(GoodsDTO goods) throws SQLException;
	
	/**
	 * ��ǰ �Ǹ� ���� ����
	 * @param: String goodsId, String goodsSale
	 * @return: int(������ ������ ��)
	 * */
	int goodsUpdateForSale(String goodsId, String goodsSale) throws SQLException;
	
	/**
	 * ��ǰ ����� ����
	 * @param: String goodsId, String goodsThumbnail
	 * @return: int(������ ������ ��)
	 * */
	int goodsUpdateThumbnail(String goodsId, String goodsThumbnail) throws SQLException;
	
	
	/**
	 * ��ü ��ǰ ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<GoodsDTO>(��ü ��ǰ�� ��� �����͸� ������ ��)
	 * 
	 * }
	 * */
	List<GoodsDTO> goodsSelectAll() throws SQLException;
	
	/**
	 * �ð� ������ �Ǹŷ� ��, ���� �� ��ȸ ����� !! 
	 */
	
	/**
	 * �Ǹ� ���� ��ǰ ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<GoodsDTO>(goodsSale�� Y�� ��ǰ)
	 * */
	List<GoodsDTO> goodsSelectForSale(String sort) throws SQLException;
	
	/**
	 * ��ǰ������ ��ǰ ��ȸ
	 * @param: �̸��� �ش� Ű���尡 ������ üũ�� Ű���带 ����
	 * @return: List<GoodsDTO>(��ǰ�� Ű���尡 ���� ��ǰ)
	 * */


	List<GoodsDTO> goodsSelectByKeyword(String keyword) throws SQLException;

	

	
	
}
