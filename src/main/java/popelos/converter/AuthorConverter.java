/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popelos.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import popelos.entity.Author;
import popelos.interfaces.IService;

@Component
public class AuthorConverter implements Converter<String, Author>{

    @Autowired
    private IService<Author> service;
    
    @Override
    public Author convert(String s) {
      int id = Integer.parseInt(s);
      Author author = service.findById(id);
      return author;
    }
    
}
