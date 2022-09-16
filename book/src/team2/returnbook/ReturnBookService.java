package team2.returnbook;

public class ReturnBookService {
	//싱글톤
    private static ReturnBookService instance = new ReturnBookService();
    public static ReturnBookService getInstance() {
        return instance;
    }
    private ReturnBookService() {}

    private ReturnBookDAO dao = ReturnBookDAO.getInstance();

    public ReturnBookVO findBook(ReturnBookVO vo) {
        return dao.findBook(vo);
    }
    public int changeBookOrRent(ReturnBookVO vo) {
        return dao.changeBookOrRent(vo);
    }
    int no = Integer.parseInt(" 대출중인 도서가 아닙니다.");
    
    public int isRentOrNot(ReturnBookVO bookid) {
    	int result = 0;
		switch (result) {
		case 0: 
			result = no;
			break;
		case 1: 
			result = dao.changeBookOrRent(bookid);
			break;
		default:
			break;
		}
    	return result;
    }
}

	
	
