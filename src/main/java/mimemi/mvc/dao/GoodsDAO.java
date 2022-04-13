package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.GoodsDTO;

public interface GoodsDAO {
	/**
	 * ��ǰ ���
	 * @param: GoodsDTO(String goodsId, String goodsName, String goodsDetail, String goodsThumbnail,
	 * 		   int goodsPrice, boolean goodsSale, String goodsDetailImg)
	 * @return: int(��ϵ� ������ ��)
	 * */
	int insert(GoodsDTO goods) throws SQLException;
	
	/**
	 * ��ǰ ����
	 * @param: GoodsDTO(String goodsId, String goodsName, String goodsDetail, int goodsPrice)
	 * @return: int(������ ������ ��)
	 * */
	int update(GoodsDTO goods) throws SQLException;
	
	/**
	 * ��ǰ ����� ����
	 * @param: GoodsDTO(String goodsId, String goodsThumbnail)
	 * @return: int(������ ������ ��)
	 * */
	int updateThumbnail(GoodsDTO goods) throws SQLException;
	
	/**
	 * ��ǰ ���̹��� ����
	 * @param: GoodsDTO(String goodsId, String goodsDetailImg)
	 * @return: int(������ ������ ��)
	 * */
	int updateDetailImg(GoodsDTO goods) throws SQLException;
	
	/**
	 * ��ǰ ����� ����
	 * @param: String goodsId
	 * @return: int(������ ������ ��)
	 * */
	int deleteThumbnail(String goodsId) throws SQLException;
	
	/**
	 * ��ǰ ���̹��� ����
	 * @param: String goodsId
	 * @return: int(������ ������ ��)
	 * */
	int deleteDetailImg(String goodsId) throws SQLException;
	
	/**
	 * ��ǰ ����
	 * : ���� �����ϴ� ���� �ƴ϶� �Ǹ� ���� �÷��� ������ ���� ����Ʈ���� ������ �ʵ��� ó����
	 * @param: GoodsDTO(String goodsId, boolean goodsSale)
	 * @return: int(������ ������ ��)
	 * */
	int delete(GoodsDTO goods) throws SQLException;
	
	/**
	 * ��ü ��ǰ ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<GoodsDTO>(��ü ��ǰ�� ��� �����͸� ������ ��)
	 * */
	List<GoodsDTO> selectAll(String sort) throws SQLException;
	
	/**
	 * �Ǹ� ���� ��ǰ ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<GoodsDTO>(goodsSale�� true�� ��ǰ)
	 * */
	List<GoodsDTO> selectForSale(String sort) throws SQLException;
	
	/**
	 * ��ǰ������ ��ǰ ��ȸ
	 * @param: �̸��� �ش� Ű���尡 ������ üũ�� Ű���带 ����
	 * @return: List<GoodsDTO>(��ǰ�� Ű���尡 ���� ��ǰ)
	 * */
	List<GoodsDTO> selectByKeyword(String keyword) throws SQLException;
	
	/**
	 * ��ǰ�ڵ�� ��ǰ ��ȸ
	 * @param: ��ȸ�� ��ǰ �ڵ�
	 * @return: GoodsDTO(�μ��� ���� ID�� ��ǰ ���̵� ������ ��ǰ)
	 * */
	GoodsDTO selectBy��oodsId(String goodsId) throws SQLException;
	
	
}
