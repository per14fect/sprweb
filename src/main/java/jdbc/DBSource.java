package jdbc;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;

@Repository
@Slf4j
@Data
public class DBSource {
    @Autowired
    DataSource ds;

    public void test() {
        String sql = "select * from main.sweet";

        try (Connection c = ds.getConnection();
             Statement st = c.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE))
        {
            ResultSet rs = st.executeQuery(sql);



           while(rs.next()) {
               int id = rs.getInt("id");
               log.info("id = {}", id);

               rs.updateString("name", "chocolate");
               rs.updateRow();
           }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }

        try (Connection c = ds.getConnection()) {
            log.info("NEW CONNECTION AUTOCOMMIT IS: {}", c.getAutoCommit());
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

//    @PostConstruct
    public void logInfo() {
        try(Connection c = ds.getConnection()) {
            DatabaseMetaData meta = c.getMetaData();
            log.info("\n");
            log.info("******************* DATABASE METADATA *****************\n");
            log.info("Connection.TRANSACTION_READ_COMMITTED = {}", Connection.TRANSACTION_READ_COMMITTED);
            log.info("TRANSACTION ISOLATION LEVEL = {}\n", meta.getDefaultTransactionIsolation());
            log.info("ResultSet.HOLD_CURSORS_OVER_COMMIT = {}", ResultSet.HOLD_CURSORS_OVER_COMMIT);
            log.info("ResultSet.CLOSE_CURSORS_AT_COMMIT = {}", ResultSet.CLOSE_CURSORS_AT_COMMIT);

            log.info("Default cursor holdability: ", meta.getResultSetHoldability());

            log.info("Supports hold: ", meta.supportsResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT));
            log.info("Supports close: ", meta.supportsResultSetHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT));

            log.info("\n");

            log.info("Supports concur_update: {}", meta.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_UPDATABLE));

            log.info("\n");

            log.info("Supports type_scroll_insensitive: {}",meta.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));

            log.info("\n");

            log.info("Supports type_scroll_sensitive: {}",meta.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));

            log.info("Autocommit: {}", c.getAutoCommit());

            log.info("******************* END DATABASE METADATA *****************\n");

        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }
}
