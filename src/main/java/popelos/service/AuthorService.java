/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popelos.service;

import popelos.interfaces.IService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import popelos.entity.Author;
import popelos.interfaces.ICrudDao;

@Service
@Transactional
public class AuthorService implements IService<Author>{
    
    @Autowired
    private ICrudDao<Author> adao;

    @Override
    public List<Author> findAll() {
        return adao.findAll();
    }

    @Override
    public int create(Author e) {
       int id = (Integer)adao.add(e);
       return (id);
    }

    @Override
    public void edit(Author e) {
       adao.update(e);
    }

    @Override
    public String delete(int id) {
       return (adao.remove(id));
    }

    @Override
    public Author findById(int id) {
       Author author = adao.findById(id);
       return (author);
    }
    
}
