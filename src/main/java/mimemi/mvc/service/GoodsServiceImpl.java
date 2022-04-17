package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dao.GoodsDAO;
import mimemi.mvc.dao.GoodsDAOImpl;
import mimemi.mvc.dto.GoodsDTO;

public class GoodsServiceImpl implements GoodsService {
	
	
	private GoodsDAO goodsDAO = new GoodsDAOImpl();
	
	/**
	 * ��ü ��ǰ ��ȸ�ϱ� 
	 * public List<GoodsDTO> selectAll(String sort) throws SQLException;
	 */	
	public List<GoodsDTO> goodsSelectAll() throws SQLException {
		List<GoodsDTO> list = goodsDAO.goodsSelectAll();
		if(list.size() == 0 || list.isEmpty()) {
			throw new SQLException("��ǰ�� ������ ���� �˻��� �� �����ϴ�.");
		}
		return list;
	}
	
	/**
	 * �Ǹ� ��ǰ ��ȸ�ϱ� 
	 * �Ǹſ��ΰ� Y�� ��츸 ��ȸ�ϱ� 
	 */
	
	public List<GoodsDTO> goodsSelectForSale() throws SQLException {
		List<GoodsDTO> list = goodsDAO.goodsSelectForSale();
		if(list.size() == 0 || list.isEmpty()) {
			throw new SQLException("��ǰ�� ������ ���� �˻��� �� �����ϴ�.");
		}
		return list;
	}
	
	/**
	 *  ��ǰ �߰��ϱ� 
	 */
	public void goodsInsert(GoodsDTO goods) throws SQLException {
		 int result = goodsDAO.goodsInsert(goods);
		 if(result == 0) throw new SQLException("��ǰ�� ��ϵ��� �ʾҽ��ϴ�");
			
		}
	
	/**
	 * ��ǰ �����ϱ� 
	 */
	public void goodsUpdate(GoodsDTO goods) throws SQLException {
		int result = goodsDAO.goodsUpdate(goods);
		if(result == 0) throw new SQLException("��ǰ�� �������� �ʾҽ��ϴ�");
	}

	/**
	 * ��ǰ �Ǹ� ���� ����
	 */
	public void goodsUpdateForSale(String goodsId, String goodsSale) throws SQLException {
		int result = goodsDAO.goodsUpdateForSale(goodsId, goodsSale);
		if(result == 0) throw new SQLException("��ǰ�� �������� �ʾҽ��ϴ�");
	}

	/**
	 * ��ǰ ����� ����
	 */
	public void goodsUpdateThumbnail(String goodsId, String goodsThumbnail) throws SQLException {
		int result = goodsDAO.goodsUpdateThumbnail(goodsId, goodsThumbnail);
		if (result == 0) throw new SQLException("��ǰ�� �������� �ʾҽ��ϴ�");
	}

	/**
	 * ��ǰ������ ��ǰ ��ȸ
	 */
	public List<GoodsDTO> goodsSelectByKeyword(String keyword) throws SQLException {
		List<GoodsDTO> list = goodsDAO.goodsSelectByKeyword(keyword);
		if(list.size() == 0 || list.isEmpty()) {
			throw new SQLException("��ǰ�� ������ ���� �˻��� �� �����ϴ�.");
		}
		return list;
	}
}

