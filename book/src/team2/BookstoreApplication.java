package team2;

import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import oracle.jdbc.pool.OracleDataSource;
import team2.join.CustomerVO;

public class BookstoreApplication {
    private static CustomerVO session = new CustomerVO();
    private static JdbcTemplate template = new JdbcTemplate();

    public static void main(String[] args) {
        new Home().initialize();
    }

    public static CustomerVO getSession() {
        return session;
    }
    public static JdbcTemplate getTemplate() {
        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setURL("jdbc:oracle:thin:@112.220.114.130:1521:xe");
            dataSource.setUser("team2_202208S");
            dataSource.setPassword("java");
            template.setDataSource(dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return template;
    }
}
