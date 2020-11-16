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
import popelos.entity.Author;
import popelos.entity.Book;
import popelos.entity.Category;
import popelos.interfaces.IService;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IService<Book> bookService;
    @Autowired
    private IService<Author> authorService;
    @Autowired
    private IService<Category> categoryService;
    
    
    @ModelAttribute("authors")
    public List<Author> getAuthors(){
        return authorService.findAll();
    }
    @ModelAttribute("categories")
    public List<Category> getCategories(){
        return categoryService.findAll();
    }

    @GetMapping
    public String showBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping(value = "/create")
    public String showCreateBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/create";
    }

    @PostMapping(value = "/create")
    public String createBook(@ModelAttribute("book") Book book) {
        bookService.create(book);
        return "redirect:/book";
    }
    
    @GetMapping(value="/edit")
    public String showBookEditForm(@RequestParam("id") int id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book", book);        
        return "book/edit";
    }
    
    @PostMapping(value = "/edit")
    public String editBook(@ModelAttribute("book") Book book){
        bookService.edit(book);        
        return "redirect:/book";
    }
    
    @GetMapping(value = "/delete")
    public String deleteBook(@RequestParam("id") int id){
        bookService.delete(id);
        return "redirect:/book";
    }
}

