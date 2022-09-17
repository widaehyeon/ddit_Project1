package team2.book;

import java.util.List;

import team2.join.CustomerVO;

public class BookService {
    private static BookService instance = new BookService();
    public static BookService getInstance() {
        return instance;
    }
    private BookService() {}

    private BookDAO dao = BookDAO.getInstance();

    public List<BookVO> findAllTitle(String searchWord) {
        return dao.findAllTitle(searchWord);
    }
    public List<BookVO> findAllAuthor(String searchWord) {
    	return dao.findAllAuthor(searchWord);
    }
    
    public List<BookVO> findSearch(String searchWord) {
    	return dao.findSearch(searchWord);
    }
    

    public BookVO findByBookId(int bookId) {
        return dao.findByBookId(bookId);
    }
    
    public BookVO findRecAll(int searchWord) {
        return dao.findRecAll(searchWord);
    }
    
    public int bookAdd(BookVO vo) {
        return dao.bookAdd(vo);
    }

}
