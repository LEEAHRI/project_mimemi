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
	List<GoodsDTO> goodsSelectForSale() throws SQLException;
	
	/**
	 * ��ǰ������ ��ǰ ��ȸ
	 * @param: �̸��� �ش� Ű���尡 ������ üũ�� Ű���带 ����
	 * @return: List<GoodsDTO>(��ǰ�� Ű���尡 ���� ��ǰ)
	 * */

<<<<<<< HEAD
	List<GoodsDTO> selectByKeyword(String keyword) throws SQLException;
=======

	List<GoodsDTO> goodsSelectByKeyword(String keyword) throws SQLException;

<<<<<<< HEAD
	/**
	 * ���� �ֹ��� �Ĵܸ� ��������
	 * @param String userId
	 * @return List<GoodsDTO>
	 * */
	List<GoodsDTO> selectOrderGoods(String userId) throws SQLException;
}
=======
	
>>>>>>> main


	
	
}
>>>>>>> 16a23ac650cfe82f8faa349a876bbe02f9b9b15d
