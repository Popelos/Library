package popelos.interfaces;

import java.io.Serializable;
import java.util.List;

public interface ICrudDao<E> {

    List<E> findAll();
    Serializable add(E e);
    String remove(int kwdikos);
    void update(E e);
    E findById(int id);

}
