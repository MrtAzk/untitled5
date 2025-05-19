package DAO;

import java.sql.SQLException;
import java.util.List;

public interface BASEDAO<T>{

    void  save(T t) throws SQLException;

    T findById(Long id );

    List<T> findAll();

    void update(T t);

    void  delete(long id );
}
