package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.AskDTO;

public interface AskBoardDAO {
	/**
	 * 1:1 문의 등록
	 * @param AskDTO(String userId, String askTitle, String askContent, String askAttach,
			String askCategory)
	 * */
	int insertAsk(AskDTO askDTO) throws SQLException;

	/**
	 * 1:1 문의 수정 
	 * @param AskDTO(int askNo, String userId, String askTitle, String askContent, String askAttach,
			String askCategory)
	 * */
	int updateAsk(AskDTO askDTO) throws SQLException;
	
	/**
	 * 1:1 문의 삭제
	 * @param int askNo
	 * */
	int deleteAsk(int askNo) throws SQLException;
	
	/**
	 * 1:1 문의 전체 검색
	 * */
	List<AskDTO> selectAllAsk() throws SQLException;
	
	/**
	 * 1:1 문의 전체 검색(페이지 처리)
	 * @param int pageNo
	 * */
	List<AskDTO> getAskList(int pageNo) throws SQLException;
	
	/**
	 * 1:1 문의 답변 여부 수정 기능
	 * */
	int updateState(int askNo, String state) throws SQLException;
	
}
