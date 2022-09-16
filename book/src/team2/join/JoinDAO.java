package team2.join;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import team2.BookstoreApplication;

public class JoinDAO {
    private static JoinDAO instance = new JoinDAO();
    public static JoinDAO getInstance() {
        return instance;
    }
    private JoinDAO() {}

    private JdbcTemplate template = BookstoreApplication.getTemplate();

    public CustomerVO findCustomer(String memId) {
        return template.queryForObject("SELECT MEM_ID, MEM_NAME, MEM_TEL, MEM_ADD, MEM_REGNO1, MEM_GRADE FROM MEMBER WHERE MEM_ID = ?", new BeanPropertyRowMapper<>(CustomerVO.class), memId);
    }

    public int join(CustomerVO vo) {
        return template.update("INSERT INTO MEMBER (MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADD, MEM_REGNO1, MEM_REGNO2) VALUES (?, ?, ?, ?, ?, ?, ?)", vo.getMemId(), vo.getMemPass(), vo.getMemName(), vo.getMemTel(), vo.getMemAdd(), vo.getMemRegno1(), vo.getMemRegno2());
    }

    public int modifyName(CustomerVO vo) {
        return template.update("UPDATE CUSTOMER SET NAME = ? WHERE CUST_ID = ?", vo.getMemName(), vo.getMemId());
    }

    public int modifyAddress(CustomerVO vo) {
        return template.update("UPDATE MEMBER SET MEM_ADD = ? WHERE MEM_ID = ?", vo.getMemAdd(), vo.getMemId());
    }

    public int modifyPhone(CustomerVO vo) {
        return template.update("UPDATE MEMBER SET MEM_TEL = ? WHERE MEM_ID = ?", vo.getMemTel(), vo.getMemId());
    }

    public int modifyPassword(CustomerVO vo) {
        return template.update("UPDATE MEMBER SET MEM_PASS = ? WHERE MEM_ID = ?", vo.getMemPass(), vo.getMemId());
    }
    
    public int withdraw(CustomerVO vo) {
        return template.update("UPDATE MEMBER SET MEM_STATE = ? WHERE MEM_ID = ?", vo.getMemState(), vo.getMemId());
    }
}
