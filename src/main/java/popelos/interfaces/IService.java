
package popelos.interfaces;

import java.util.List;


public interface IService<E> {
    
    
    List<E> findAll();
    int create(E e);
    void edit(E e);
    String delete(int id);
    E findById(int id);
}
