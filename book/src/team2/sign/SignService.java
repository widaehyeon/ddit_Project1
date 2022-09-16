package team2.sign;

import team2.join.CustomerVO;

public class SignService {
    private static SignService instance = new SignService();
    public static SignService getInstance() {
        return instance;
    }
    private SignService() {}

    private SignDAO dao = SignDAO.getInstance();

    public SignVO findUser(SignVO vo) {
        return dao.findUser(vo);
    }
    
    public SignVO findManager(SignVO vo) {
        return dao.findManager(vo);
    }
}
