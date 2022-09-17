package team2.book;

import java.util.List;

import team2.BookstoreApplication;
import team2.common.HomeMenu;

public class BookController {
    private static BookController instance = new BookController();
    public static BookController getInstance() {
        return instance;
    }
    private BookController() {}

    private BookService service = BookService.getInstance();
    private BookVO sessionBook = BookstoreApplication.getSessionBook();

    public List<BookVO> selectBookListTitle(String searchWord) {
        return service.findAllTitle(searchWord);
    }
    
    public List<BookVO> selectBookListAuthor(String searchWord) {
    	return service.findAllAuthor(searchWord);
    }
    
    public List<BookVO> selectBookSearch(String searchWord) {
    	return service.findSearch(searchWord);
    }

    public BookVO selectRecBookList(int searchWord) {
        return service.findRecAll(searchWord);
    }    
    
    public int bookAdd(BookVO vo) {
        try {
            if (service.bookAdd(vo) == 1) {
                return HomeMenu.BOOKMANAGE.getMenu();
            }
        } catch (Exception e) {
            System.out.println("알수 없는 오류가 발생하였습니다");
            return HomeMenu.BOOKMANAGE.getMenu();
        }
        return HomeMenu.HOME.getMenu();
    }
}
