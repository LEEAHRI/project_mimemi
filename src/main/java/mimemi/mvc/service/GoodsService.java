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
	void insert(GoodsDTO goods) throws SQLException;
	
	/**
	 * ��ǰ ����
	 * @param: GoodsDTO(String goodsId, String goodsName, String goodsDetail, int goodsPrice)
	 * */
	void update(GoodsDTO goods) throws SQLException;
	
	/**
	 * ��ǰ �Ǹ� ���� ����
	 * @param: String goodsId, String goodsSale
	 * */
	void updateForSale(String goodsId, String goodsSale) throws SQLException;
	
	/**
	 * ��ǰ ����� ����
	 * @param: String goodsId, String goodsThumbnail
	 * */
	void updateThumbnail(String goodsId, String goodsThumbnail) throws SQLException;
	
	/**
	 * ��ǰ ���̹��� ����
	 * @param: String goodsId, String goodsDetailImg
	 * */
	void updateDetailImg(String goodsId, String goodsDetailImg) throws SQLException;
	
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
	 * ��ü ��ǰ ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<GoodsDTO>(��ü ��ǰ�� ��� �����͸� ������ ��)
	 * 
	 * �������ݼ�, �������ݼ�
	 * if(String.equals("���� ���ݼ�")){
	 * 	sql = "���� ���ݼ� ���� �ҷ�����... properties..."
	 * }
	 * */
	List<GoodsDTO> selectAll(String sort) throws SQLException;
	
	/**
	 * �Ǹ� ���� ��ǰ ��ȸ
	 * @param: ���� ����� �μ��� �޾� �������� order by�� ��ȭ�� ��
	 * @return: List<GoodsDTO>(goodsSale�� Y�� ��ǰ)
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
	GoodsDTO selectByGoodsId(String goodsId) throws SQLException;
	
	
}
