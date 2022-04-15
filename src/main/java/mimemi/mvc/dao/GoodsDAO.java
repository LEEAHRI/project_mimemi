package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.GoodsDTO;

public interface GoodsDAO {
	/**
	 * ��ǰ ���
	 * @param: GoodsDTO(String goodsId, String goodsName, String goodsDetail, String goodsThumbnail,
	 * 		   int goodsPrice, String goodsDetailImg)
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
	 * ��ǰ �Ǹ� ���� ����
	 * @param: String goodsId, String goodsSale
	 * @return: int(������ ������ ��)
	 * */
	int updateForSale(String goodsId, String goodsSale) throws SQLException;
	
	/**
	 * ��ǰ ����� ����
	 * @param: String goodsId, String goodsThumbnail
	 * @return: int(������ ������ ��)
	 * */
	int updateThumbnail(String goodsId, String goodsThumbnail) throws SQLException;
	
	/**
	 * ��ǰ ���̹��� ����
	 * @param: String goodsId, String goodsDetailImg
	 * @return: int(������ ������ ��)
	 * */
	int updateDetailImg(String goodsId, String goodsDetailImg) throws SQLException;
	
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
