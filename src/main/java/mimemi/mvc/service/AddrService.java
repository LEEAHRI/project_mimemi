package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.AddrDTO;

public interface AddrService {
	
	/**
	 * addrName���� select�ؿ��� ���
	 * */
	AddrDTO selectByAddrName(String addrName) throws SQLException;
	
	/**
	 * addrId���� select�ؿ��� ���
	 * */
	AddrDTO selectByAddrId(int addrId) throws SQLException;

	List<AddrDTO> selectByUserId(String userId) throws SQLException;
}
