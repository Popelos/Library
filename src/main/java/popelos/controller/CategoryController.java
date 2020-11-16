
package popelos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import popelos.entity.Category;
import popelos.interfaces.IService;

@Controller
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    private IService<Category> service;
    
    @GetMapping
    public String showCategories(Model model){
        List<Category> categories = service.findAll();
        model.addAttribute("categories", categories);
        return "category/list";
    }
    
    @GetMapping(value="/create")
    public String showCategoryForm(Model model){
    model.addAttribute("category", new Category());
    return "category/create";
    }
    
    @PostMapping(value="/create")
    public String createCategory(@ModelAttribute("category") Category category, Model model){
     service.create(category);
     return "redirect:/category";
    }
    
    @GetMapping(value="/delete")
    public String deleteCategory(@RequestParam("id") int id){
        service.delete(id);
        return "redirect:/category";
    }
    
    @GetMapping(value="/edit")
    public String showEditCategoryForm(@RequestParam("id") int id, Model model){
       Category category = service.findById(id);
       model.addAttribute("category", category);
       return "category/edit";
    }
    
    @PostMapping(value="/edit")
    public String editCastomer(@ModelAttribute("category") Category category){
        service.edit(category);
        return "redirect:/category";
    }
}


