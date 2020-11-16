/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popelos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import popelos.entity.Book;
import popelos.interfaces.ICrudDao;
import popelos.interfaces.IService;

@Service
@Transactional
public class BookService implements IService<Book> {

    @Autowired
    private ICrudDao<Book> bdao;

     @Override
    public List<Book> findAll() {
        return bdao.findAll();
    }

    @Override
    public int create(Book e) {
       int id = (Integer)bdao.add(e);
       return (id);
    }

    @Override
    public void edit(Book e) {
       bdao.update(e);
    }

    @Override
    public String delete(int id) {
       return (bdao.remove(id));
    }

    @Override
    public Book findById(int id) {
       Book book = bdao.findById(id);
       return (book);
    }

}
