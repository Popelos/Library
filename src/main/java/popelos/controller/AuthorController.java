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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import popelos.entity.Author;
import popelos.interfaces.IService;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private IService<Author> service;
    
    @GetMapping
    public String showAuthors(Model model){
        List<Author> authors = service.findAll();
        model.addAttribute("authors",authors);
        return "author/list";
    }
    
    
    @GetMapping(value="/create")
    public String showAuthorForm(Model model){
        model.addAttribute("author", new Author());
        return "author/create";
    }
    
    @PostMapping(value ="/create")
    public String createAuthor(@ModelAttribute("author") Author author, RedirectAttributes ra){
       int id = service.create(author);
       String msg = "Author successfully create with id:"+id;
       ra.addFlashAttribute("msg", msg);
        return "redirect:/author";
    }
    
    @GetMapping(value="/edit")
    public String showAuthorEditForm(@RequestParam("id") int id,Model model){
        Author author = service.findById(id);
        model.addAttribute("author", author);
        return "author/edit";
    }
    
    @PostMapping(value="/edid")
    public String editAuthor(@ModelAttribute("author") Author author){
        service.edit(author);
        return "redirect:/author";
    }
    
    @GetMapping(value="/delete")
    public String deleteAuthor(@RequestParam("id") int id){
        service.delete(id);        
        return "redirect:/author";
    }
    
}
