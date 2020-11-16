package popelos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import popelos.entity.Category;
import popelos.interfaces.ICrudDao;
import popelos.interfaces.IService;

@Service
@Transactional
public class CategoryService implements IService<Category> {

    @Autowired
    private ICrudDao<Category> cdao;

    @Override
    public List<Category> findAll() {
        return cdao.findAll();
    }

    @Override
    public int create(Category e) {
        int id = (Integer) cdao.add(e);
        return (id);
    }

    @Override
    public void edit(Category e) {
        cdao.update(e);
    }

    @Override
    public String delete(int id) {
        return (cdao.remove(id));
    }

    @Override
    public Category findById(int id) {
        Category category = cdao.findById(id);
        return (category);
    }
}
