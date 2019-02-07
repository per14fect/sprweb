package service;

import java.sql.ResultSet;
import java.util.List;

public interface Mapper<T> {
    T map(ResultSet rs);

    List<T> mapList(ResultSet rs);
}
