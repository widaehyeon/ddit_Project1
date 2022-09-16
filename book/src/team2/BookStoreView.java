package team2;

import java.util.Scanner;

import team2.book.BookController;
import team2.common.HomeMenu;
import team2.common.ScannerUtil;
import team2.join.CustomerVO;
import team2.join.JoinController;
import team2.sign.SignController;
import team2.sign.SignVO;

public class BookStoreView {
    private static BookStoreView instance = new BookStoreView();
    private BookStoreView() {}
    public static BookStoreView getInstance() {
        return instance;
    }

    private Scanner scanner = ScannerUtil.scanner();

    public int init() {
        System.out.println("이책 어때~ 대출 어때~ 반납 어때~");
        System.out.print(HomeMenu.HOME.getMenuString());
        return scanner.nextInt();
    }

    public int getMenu() {
        return scanner.nextInt();
    }

    public int join(JoinController controller) {
        int number;
        scanner.nextLine();
        System.out.print("아이디: ");
        String id = scanner.nextLine();
        System.out.print("패스워드: ");
        String password = scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("전화번호: ");
        String tel = scanner.nextLine();
        System.out.print("주소: ");
        String address = scanner.nextLine();
        System.out.print("주민등록번호 앞6자리: ");
        String regno1 = scanner.nextLine();
        System.out.print("주민등록번호 뒤7자리: ");
        String regno2 = scanner.nextLine();
        number = controller.join(new CustomerVO(id, password, name, tel, address, regno1, regno2));
        if (number == HomeMenu.HOME.getMenu()) {
            System.out.println("회원가입이 완료되었습니다. 로그인해주세요.");
        } else {
            System.out.print("회원 가입 실패! 다시 회원가입을 하시겠습니까?(y 또는 n을 입력): ");
            String inputFlag = scanner.nextLine();
            if (inputFlag.equalsIgnoreCase("y")) {
                number = HomeMenu.JOIN.getMenu();
            } else {
                number = HomeMenu.HOME.getMenu();
            }
        }
        return number;
    }
    public int login(SignController controller) {
        if(scanner.hasNextLine()) {
        	scanner.nextLine();
        }
    	int number;
        System.out.print("아이디: ");
        String userId = scanner.nextLine();
        System.out.print("패스워드: ");
        String userPw = scanner.nextLine();
        SignVO vo = controller.signIn(new SignVO(userId, userPw));
        if (vo != null) {
            System.out.println(vo.getMemName() + "님 로그인되었습니다.");
            number = HomeMenu.MAIN.getMenu();
        } else {
            System.out.println("로그인 정보가 일치하지 않습니다.");
            number = HomeMenu.HOME.getMenu();
        }
        return number;
    }
    
    public int managerLogin(SignController controller) {
        if(scanner.hasNextLine()) {
        	scanner.nextLine();
        }
    	int number;
        System.out.print("아이디: ");
        String userId = scanner.nextLine();
        System.out.print("패스워드: ");
        String userPw = scanner.nextLine();
        SignVO vo = controller.signInManager(new SignVO(userId, userPw));
        if (vo != null) {
            System.out.println(vo.getMemName() + "님 로그인되었습니다.");
            number = HomeMenu.MAIN.getMenu();
        } else {
            System.out.println("로그인 정보가 일치하지 않습니다.");
            number = HomeMenu.HOME.getMenu();
        }
        return number;
    }


    public int getBookList(BookController controller) {
        controller.selectBookList("").forEach(bookVO -> {
            System.out.printf("%d\t%s\t%s\t%d\n", bookVO.getBookId(), bookVO.getBookName(), bookVO.getPublisher(), bookVO.getPrice());
        });
        return HomeMenu.BOOK.getMenu();
    }

    public int searchBook(BookController controller) {
        // scanner의 nextInt()와 nextLine() 사이의 줄바꿈 특수문자 제거를 해줌
        scanner.nextLine();
        String searchWord = scanner.nextLine();
        controller.selectBookList(searchWord).forEach(bookVO -> {
            System.out.printf("%d\t%s\t%s\t%d\n", bookVO.getBookId(), bookVO.getBookName(), bookVO.getPublisher(), bookVO.getPrice());
        });
        return HomeMenu.BOOK.getMenu();
    }

    public int getMemberInfo(JoinController controller) {
        CustomerVO customer = controller.findCustomer();
        System.out.printf("아이디: %s\n", customer.getMemId());
        System.out.printf("이름: %s\n", customer.getMemName());
        System.out.printf("휴대전화번호: %s\n", customer.getMemTel());
        System.out.printf("주소: %s\n", customer.getMemAdd());
        System.out.printf("생년월일: %s\n", customer.getMemRegno1());
        System.out.printf("등급: %s\n", customer.getMemGrade());
        return HomeMenu.MEMBER.getMenu();
    }

    public int modifyInfo(JoinController controller, HomeMenu menu) {
        scanner.nextLine();
        int resultName = controller.modifyInfo(scanner.nextLine(), menu);
        if (resultName == 1) {
            System.out.println("정상적으로 수정되었습니다.");
        }
        return HomeMenu.MEMBER.getMenu();
    }

    public int changePassword(JoinController controller) {
        scanner.nextLine();
        String newPassword = scanner.nextLine();
        System.out.print("비밀번호 확인을 위해 다시 한번 입력해주세요: ");
        String confirmPassword = scanner.nextLine();
        if (newPassword.equals(confirmPassword)) {
            controller.modifyPassword(confirmPassword);
            System.out.println("비밀번호가 변경되었습니다.");
        } else {
            System.out.println("비밀번호가 일치하지 않습니다. 비밀번호 변경을 취소합니다.");
        }
        return HomeMenu.MEMBER.getMenu();
    }
    
    public int withdrawId(JoinController controller) {
    	scanner.nextLine();
    	String confirmMessage = scanner.nextLine();
    	if(confirmMessage.equals("Y")||confirmMessage.equals("y")) {
    		System.out.println("회원탈퇴가 처리되었습니다.");
    		controller.withdraw("0");
    		return HomeMenu.HOME.getMenu();
    	} else{
    		return HomeMenu.MEMBER.getMenu();
    	}
    }

}
