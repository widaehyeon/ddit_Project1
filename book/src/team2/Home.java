package team2;

import team2.book.BookController;
import team2.common.HomeMenu;
import team2.common.MenuNotFoundException;
import team2.join.JoinController;
import team2.sign.SignController;

public class Home {
    private JoinController joinController = JoinController.getInstance();
    private BookController bookController = BookController.getInstance();
    private SignController signController = SignController.getInstance();

    private BookStoreView view = BookStoreView.getInstance();

    public void initialize() {
        home(view.init());
    }
    private void home(int number) {
        loop:
        while (true) {
            try {
                HomeMenu menu = HomeMenu.findMenu(number);
                System.out.print(menu.getMenuString());
                switch (menu) {
                    case HOME:
                    case MAIN:
                    case MAINMANAGER:
                    case BOOKMANAGE:
                    case MEMBER:
                    case BOOK_SEARCH:
                    case BOOK:
                    case CUSTOMER_MODIFY_INFO:
                        number = view.getMenu();
                        break;
                    case JOIN:
                        number = view.join(joinController);
                        break;
                    case LOGIN_MEMBER:
                        number = view.login(signController);
                        break;
                    case LOGIN_MANAGER:
                        number = view.managerLogin(signController);
                        break;    
                    case LOGOUT:
                        number = signController.signOut();
                        break;
                    case BOOKADD:
                    	number = view.bookAdd(bookController);
                    case BOOK_LIST:
                        number = view.getBookList(bookController);
                        break;
                    case BOOKSEARCH:
                        number = view.getBookSearch(bookController);
                        break;    
                    case SEARCH_TITLE:
                        number = view.searchBookTitle(bookController);
                        break;
                    case SEARCH_AUTHOR:
                    	number = view.searchBookAuthor(bookController);
                    	break;
                    case MEMBER_INFO:
                        number = view.getMemberInfo(joinController);
                        break;
                    case MODIFY_ADDRESS:
                //  case BOOKMODIFY:
                    case MODIFY_PHONE:
                        number = view.modifyInfo(joinController, menu);
                        break;
                    case MODIFY_PASSWORD:
                        number = view.changePassword(joinController);
                        break;
                    case MEMBER_WITHDRAW:
                    	number = view.withdrawId(joinController);
                    	break;
                    case RECBOOKMANAGE:
                        number = view.recBookManage(bookController);
                    case QUIT:
                        break loop;
                }
            } catch (MenuNotFoundException e) {
                System.out.println(e.getMessage());
                System.out.print(HomeMenu.HOME.getMenuString());
            }
            System.out.println();
        }
    }
}