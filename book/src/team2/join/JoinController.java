package team2.join;

import team2.BookstoreApplication;
import team2.common.HomeMenu;

public class JoinController {
    private static JoinController instance = new JoinController();
    public static JoinController getInstance() {
        return instance;
    }
    private JoinController() {}

    private JoinService service = JoinService.getInstance();
    private CustomerVO session = BookstoreApplication.getSession();

    public JoinController(JoinService service) {
        this.service = service;
    }

    public CustomerVO findCustomer() {
        return service.findCustomer(session.getMemId());
    }

    public int join(CustomerVO vo) {
        try {
            if (service.join(vo) == 1) {
                return HomeMenu.HOME.getMenu();
            }
        } catch (Exception e) {
            System.out.println("알수 없는 오류가 발생하였습니다");
            return HomeMenu.JOIN.getMenu();
        }
        return HomeMenu.HOME.getMenu();
    }
    public int modifyInfo(String modifyData, HomeMenu menu) {
        CustomerVO vo = new CustomerVO();
        vo.setMemId(session.getMemId());
        switch (menu) {
            case MODIFY_ADDRESS:
                vo.setMemAdd(modifyData);
                break;
            case MODIFY_PHONE:
                vo.setMemTel(modifyData);
                break;
        }
        return service.modifyInfo(vo, menu);
    }
    public int modifyPassword(String password) {
        CustomerVO vo = new CustomerVO();
        vo.setMemId(session.getMemId());
        vo.setMemPass(password);
        return service.modifyPassword(vo);
    }
    
    public int withdraw(String memState) {
        CustomerVO vo = new CustomerVO();
        vo.setMemId(session.getMemId());
        vo.setMemState(memState);
        return service.withdraw(vo);
    }
}
