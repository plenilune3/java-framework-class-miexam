package kr.ac.jejunu.userdao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JejuJdbcTemplate extends JdbcTemplate {

    public JejuJdbcTemplate(DataSource dataSource) {
        super(dataSource);
    }

    public Long insert(String sql, Object[] params) {
        KeyHolder keyholder = new GeneratedKeyHolder();
        update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                for (int i = 0; i < params.length; i++)
                    preparedStatement.setObject(i + 1, params[i]);
                return preparedStatement;
            }
        }, keyholder);
        return keyholder.getKey().longValue();
    }
}