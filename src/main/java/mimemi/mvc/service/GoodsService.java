package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.GoodsDTO;

public interface GoodsService {
	/**
	 * ��ǰ ���
	 * @param: GoodsDTO(String goodsId, String goodsName, String goodsDetail, String goodsThumbnail,
	 * 		   int goodsPrice, boolean goodsSale, String goodsDetailImg)
	 * */
	void insert(GoodsDTO goods) throws SQLException;
	
	/**
	 * ��ǰ ����
	 * @param: GoodsDTO(String goodsId, String goodsName, String goodsDetail, int goodsPrice)
	 * */
	void update(GoodsDTO goods) throws SQLException;
	
	/**
	 * ��ǰ ����� ����
	 * @param: GoodsDTO(String goodsId, String goodsThumbnail)
	 * */
	void updateThumbnail(GoodsDTO goods) throws SQLException;
	
	/**
	 * ��ǰ ���̹��� ����
	 * @param: GoodsDTO(String goodsId, String goodsDetailImg)
	 * */
	void updateDetailImg(GoodsDTO goods) throws SQLException;
	
	/**
	 * ��ǰ ����� ����
	 * @param: String goodsId
	 * */
	void deleteThumbnail(String goodsId) throws SQLException;
	
	/**
	 * ��ǰ ���̹��� ����
	 * @param: String goodsId
	 * */
	void deleteDetailImg(String goodsId) throws SQLException;
	
	/**
	 * ��ǰ ����
	 * : ���� �����ϴ� ���� �ƴ϶� �Ǹ� ���� �÷��� ������ ���� ����Ʈ���� ������ �ʵ��� ó����
	 * @param: GoodsDTO(String goodsId, boolean goodsSale)
	 * */
	void delete(GoodsDTO goods) throws SQLException;
	
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
