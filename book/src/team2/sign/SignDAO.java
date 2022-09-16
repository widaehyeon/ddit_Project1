package team2.sign;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import team2.BookstoreApplication;

public class SignDAO {
    private static SignDAO instance = new SignDAO();
    public static SignDAO getInstance() {
        return instance;
    }
    private SignDAO() {}

    private JdbcTemplate template = BookstoreApplication.getTemplate();

    public SignVO findUser(SignVO vo) {
        try {
            return template.queryForObject("SELECT MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADD, MEM_REGNO1, MEM_REGNO2, MEM_STATE, MEM_GRADE FROM MEMBER WHERE MEM_ID = ? AND MEM_PASS = ? AND MEM_STATE = '1'", new BeanPropertyRowMapper<>(SignVO.class), vo.getMemId(), vo.getMemPass());
        } catch (DataAccessException e) {
            return null;
        }
    }
    
    public SignVO findManager(SignVO vo) {
        try {
            return template.queryForObject("SELECT MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADD, MEM_REGNO1, MEM_REGNO2, MEM_STATE, MEM_GRADE FROM MEMBER WHERE MEM_ID = ? AND MEM_PASS = ? AND MEM_STATE = '1' AND MEM_GRADE = '사서'", new BeanPropertyRowMapper<>(SignVO.class), vo.getMemId(), vo.getMemPass());
        } catch (DataAccessException e) {
            return null;
        }
    }
}
