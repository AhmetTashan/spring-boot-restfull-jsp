package cc.tashan.controller;

import cc.tashan.dto.TodoCreateDto;
import cc.tashan.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping({"/", "/todos"})
    public String index(Model model) {

        model.addAttribute("todos", todoService.getAll());

        return "index";
    }

    @PostMapping("/add")
    public String add(@RequestBody TodoCreateDto todoCreateDto) {
        todoService.create(todoCreateDto);
        return "redirect:/";
    }
}
