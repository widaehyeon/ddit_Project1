package team2.returnbook;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import team2.BookstoreApplication;

public class ReturnBookDAO {
    private static ReturnBookDAO instance = new ReturnBookDAO();
    public static ReturnBookDAO getInstance() {
    	return instance;
	}
     
    private ReturnBookDAO() {}
    
    private JdbcTemplate template = BookstoreApplication.getTemplate();

    public ReturnBookVO findBook(ReturnBookVO vo) {
    	//1행 가져오기
    	return template.queryForObject("SELECT BOOKID FROM BOOK WHERE BOOKID = ? ", new BeanPropertyRowMapper<>(ReturnBookVO.class), vo.getBookId()); 
    }

    public int changeBookOrRent(ReturnBookVO vo) {
        return template.update("UPDATE BOOK SET BOOK_OR_RENT = 0 WHERE BOOKID = ? ",vo.getBookId());
    }
}
