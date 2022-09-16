package team2.sign;

import team2.BookstoreApplication;
import team2.common.HomeMenu;
import team2.join.CustomerVO;

public class SignController {
    private static SignController instance = new SignController();
    public static SignController getInstance() {
        return instance;
    }
    private SignController() {}

    private SignService service = SignService.getInstance();

    private CustomerVO session = BookstoreApplication.getSession();

    public SignVO signIn(SignVO vo) {
        SignVO custom = service.findUser(vo);
        if (custom == null) {
            return null;
        }
        session.setMemId(custom.getMemId());
        session.setMemName(custom.getMemName());
        return custom;
    }
    
    public SignVO signInManager(SignVO vo) {
        SignVO custom = service.findManager(vo);
        if (custom == null) {
            return null;
        }
        session.setMemId(custom.getMemId());
        session.setMemName(custom.getMemName());
        return custom;
    }
    
    public int signOut() {
        // 세션 초기화
        session.invalidate();
        return HomeMenu.HOME.getMenu();
    }

}
