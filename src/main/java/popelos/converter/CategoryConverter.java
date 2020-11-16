/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popelos.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import popelos.entity.Category;
import popelos.interfaces.IService;

@Component
public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    private IService<Category> service;

    @Override
    public Category convert(String s) {
        int id = Integer.parseInt(s);
        Category category = service.findById(id);
        return category;
    }

}
