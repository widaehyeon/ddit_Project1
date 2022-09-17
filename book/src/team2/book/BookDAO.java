package team2.book;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import team2.BookstoreApplication;
import team2.join.CustomerVO;

public class BookDAO {
    private static BookDAO instance = new BookDAO();
    public static BookDAO getInstance() {
        return instance;
    }
    private BookDAO() {}

    private JdbcTemplate template = BookstoreApplication.getTemplate();

    public List<BookVO> findAllTitle(String searchWord) {
        return template.query("SELECT BOOK_ID, BOOK_NAME, BOOK_AUTHOR, BOOK_PUB, BOOK_YEAR FROM BOOK WHERE BOOK_NAME like '%' || ? || '%'", new BeanPropertyRowMapper<>(BookVO.class), searchWord);
    }
    public List<BookVO> findAllAuthor(String searchWord) {
    	return template.query("SELECT BOOK_ID, BOOK_NAME, BOOK_AUTHOR, BOOK_PUB, BOOK_YEAR FROM BOOK WHERE BOOK_AUTHOR like '%' || ? || '%'", new BeanPropertyRowMapper<>(BookVO.class), searchWord);
    }
    public List<BookVO> findSearch(String searchWord) {
    	return template.query("SELECT BOOK_ID, BOOK_NAME, BOOK_AUTHOR, BOOK_PUB, BOOK_YEAR FROM BOOK WHERE BOOK_AUTHOR like '%' || ? || '%'", new BeanPropertyRowMapper<>(BookVO.class), searchWord);
    }

    public BookVO findByBookId(int bookId) {
        return template.queryForObject("SELECT BOOK_ID, BOOK_NAME, BOOK_AUTHOR, BOOK_PUB, BOOK_YEAR FROM BOOK WHERE BOOK_ID = ?", new BeanPropertyRowMapper<>(BookVO.class), bookId);
    }
    
    public BookVO recBookManage(int bookId) {
        return template.queryForObject("INSERT INTO REC(REC_ID, BOOK_ID, REC_DATE) VALUES((SELECT NVL(MAX(REC_ID)+1, 300001) FROM REC), ?, SYSDATE)", new BeanPropertyRowMapper<>(BookVO.class), bookId);
    }
    
    public BookVO findRecAll(int searchWord) {
        return template.queryForObject("SELECT BOOK_ID, BOOK_NAME, BOOK_AUTHOR, BOOK_PUB, BOOK_YEAR, BOOK_OR_REN, BOOK_OR_DEL, BOOK_OUTDATE FROM BOOK WHERE BOOK_ID = ? ", new BeanPropertyRowMapper<>(BookVO.class), searchWord);
      }
    
    public int bookAdd(BookVO vo) {
        return template.update("INSERT INTO BOOK (BOOK_ID, BOOK_NAME, BOOK_AUTHOR, BOOK_PUB, BOOK_YEAR) VALUES (book_id_seq.nextval, ?, ?, ?, ?)", vo.getBookName(),vo.getBookAuthor(), vo.getBookPub(), vo.getBookYear());
    }
}
