package team2.book;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import team2.BookstoreApplication;

public class BookDAO {
    private static BookDAO instance = new BookDAO();
    public static BookDAO getInstance() {
        return instance;
    }
    private BookDAO() {}

    private JdbcTemplate template = BookstoreApplication.getTemplate();

    public List<BookVO> findAll(String searchWord) {
        return template.query("SELECT BOOK_ID, BOOK_NAME, PUBLISHER, PRICE FROM BOOK WHERE BOOK_NAME like '%' || ? || '%'", new BeanPropertyRowMapper<>(BookVO.class), searchWord);
    }

    public BookVO findByBookId(int bookId) {
        return template.queryForObject("SELECT BOOK_ID, BOOK_NAME, PUBLISHER, PRICE FROM BOOK WHERE BOOK_ID = ?", new BeanPropertyRowMapper<>(BookVO.class), bookId);
    }

}
