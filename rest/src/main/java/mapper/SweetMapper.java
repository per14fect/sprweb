package mapper;

import lombok.extern.slf4j.Slf4j;
import model.Sweet;
import org.springframework.stereotype.Repository;
import service.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class SweetMapper implements Mapper<Sweet> {

    @Override
    public Sweet map(ResultSet rs) {
        return null;
    }

    @Override
    public List<Sweet> mapList(ResultSet rs) {
        List<Sweet> list = new ArrayList<>();
        try {
            while (rs.next()) {
                Sweet s = new Sweet();
                s.setId(rs.getLong(1));
                s.setName(rs.getString(2));
                s.setCount(rs.getInt(3));
                s.setPrice(rs.getBigDecimal(4));
                list.add(s);
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }

        return list;
    }
}