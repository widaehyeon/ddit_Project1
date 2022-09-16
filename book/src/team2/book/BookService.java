package team2.book;

import java.util.List;

public class BookService {
    private static BookService instance = new BookService();
    public static BookService getInstance() {
        return instance;
    }
    private BookService() {}

    private BookDAO dao = BookDAO.getInstance();

    public List<BookVO> findAll(String searchWord) {
        return dao.findAll(searchWord);
    }

    public BookVO findByBookId(int bookId) {
        return dao.findByBookId(bookId);
    }

}
