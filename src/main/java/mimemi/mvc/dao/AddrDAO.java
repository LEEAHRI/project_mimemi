package mimemi.mvc.dao;

import java.sql.SQLException;

import mimemi.mvc.dto.AddrDTO;

public interface AddrDAO {
	
	/**
	 * addrName���� select�ؿ��� ���
	 * */
	AddrDTO selectByAddrName(String addrName) throws SQLException;
	
	/**
	 * addrId���� select�ؿ��� ���
	 * */
	AddrDTO selectByAddrId(int addrId) throws SQLException;
}
