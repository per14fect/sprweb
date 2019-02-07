package jdbc;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import model.Sweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import service.Mapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@Slf4j
@Repository
public class DBSource {
    @Autowired
    DataSource ds;

    @Autowired
    Map<String, Mapper> map;

    public List<Sweet> sweets() {
        List<Sweet> list = new ArrayList<>();

        try(Connection c = ds.getConnection(); Statement st = c.createStatement()) {
            String sql = "select * from main.sweet";
            ResultSet rs = st.executeQuery(sql);
            list = (List<Sweet>) map.get("sweetMapper").mapList(rs);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }

        return list;
    }
}