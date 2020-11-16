
package popelos.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import popelos.entity.Book;

@Repository
public class BookDao extends SuperDao<Book>{

    @Override
    public List<Book> findAll() {
      return super.findAll("Book.findAll");
    }

    @Override
    public String remove(int id) {
        return super.remove(id,"Book.removeById");
    }

    @Override
    public Book findById(int id) {
      return super.findById(id,"Book.findById");
    }
    
}
