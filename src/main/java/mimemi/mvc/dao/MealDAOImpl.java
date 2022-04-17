package mimemi.mvc.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.List;
import mimemi.mvc.util.DbUtil;
import mimemi.mvc.dto.GoodsDTO;
import mimemi.mvc.dto.MealDTO;

public class MealDAOImpl implements MealDAO {
	
	private Properties proFile = DbUtil.getProFile();
	

	/**
	 * �Ǹ� ���ö� ���
	 * */
	public int mealInsert(MealDTO meal) throws SQLException {
		return 0;
	}
	
	/**
	 * �Ǹ� ���ö� ����
	 * */
	public int mealUpdate(MealDTO meal) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("meal.update");
		// goods.update = update goods set goods_name = ?, goods_detail = ?, goods_thumbnail = ?, goods_price = ?, goods_sale = ?, goods_detail_image = ? where goods_id = ?
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(7, meal.getMealId());
			ps.setString(1, meal.getMealName());
//			ps.setString(2, meal.getMealDetail());
//			ps.setString(3, meal.getGoodsThumbnail());
//			ps.setInt(4, meal.getGoodsPrice());
//			ps.setBoolean(5, meal.isGoodsSale());
//			ps.setString(6,meal.getGoodsDetailImg());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
			
		}
		return result;
	}

	
	/**
	 * �Ǹ� ���ö� �Ǹ� ���� ����
	 * */
	public int mealUpdateForSale(String mealId, String mealSale) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("goods.updateForSale");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, mealSale);
			ps.setString(2, mealId);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
			
		}
		return result;
	}
	
	/**
	 * ��ü ���ö� ��ȸ
	 * */
	public List<MealDTO> mealSelectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MealDTO> list = new ArrayList<MealDTO>();
		String sql = proFile.getProperty("meal.mealSelectAll");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MealDTO meal = new MealDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10).equals("Y"));
				list.add(meal);
			}
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
			
		}
		return list;
	}
	
	/**
	 * �Ǹ� ���� ���ö� ��ȸ
	 * */
	List<MealDTO> mealSelectForSale() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MealDTO> list = new ArrayList<MealDTO>();
		String sql = proFile.getProperty("meal.selectForSale");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				MealDTO meal = new MealDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10).equals("Y"));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
			
		}
		return list;
	}

	@Override
	public int mealUpdateForSale(MealDTO meal) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MealDTO> mealSelectAll(String sort) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MealDTO> mealSelectForSale(String sort) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	

}
