
package popelos.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import popelos.entity.Category;

@Repository
public class CategoryDao extends SuperDao<Category>{

    @Override
    public List<Category> findAll() {
       return super.findAll("Category.findAll");
    }

    @Override
    public String remove(int id) {
      return super.remove(id,"Category.removeById");
    }

    @Override
    public Category findById(int id) {
      return super.findById(id,"Category.findById");
    }
    

 
}
