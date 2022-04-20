package mimemi.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import mimemi.mvc.dto.ManagerDTO;
import mimemi.mvc.dto.UserDTO;
import mimemi.mvc.util.DbUtil;

public class ManagerDAOImpl implements ManagerDAO {
	private Properties proFile = new Properties();
	/**
	 * dbQuery.properties �ε��� Properties ��ü�� ����
	 * */
	public ManagerDAOImpl() {
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ManagerDTO loginManager(String managerId, String managerPwd) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
				
		String sql = "select * from managers where manager_id=? and manager_pwd=?";
		ManagerDTO managerDTO = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, managerId);
			ps.setString(2, managerPwd);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				managerDTO = new ManagerDTO(rs.getString(1), rs.getString(3));
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return managerDTO;
	}
}
