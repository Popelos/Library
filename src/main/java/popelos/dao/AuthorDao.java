
package popelos.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import popelos.entity.Author;

@Repository
public class AuthorDao extends SuperDao<Author>{

    @Override
    public List<Author> findAll() {
     return super.findAll("Author.findAll");
    }

  @Override
    public String remove(int id) {
        return super.remove(id, "Author.removeById");
    }

    @Override
    public Author findById(int id) {
        return super.findById(id, "Author.findById");
    }
    
    
}
