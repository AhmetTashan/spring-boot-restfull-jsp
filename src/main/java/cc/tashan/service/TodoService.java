package cc.tashan.service;

import cc.tashan.dto.DeleteDto;
import cc.tashan.dto.TodoCreateDto;
import cc.tashan.dto.TodoUpdateDto;
import cc.tashan.model.Todos;
import cc.tashan.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todos> getAll() {
        List<Todos> todos = todoRepository.findAll();
        return todos;
    }

    public Todos getById(Long id) {
        Todos todo = todoRepository.findById(id).orElse(null);
        return todo;
    }

    public Todos create(TodoCreateDto todoCreateDto) {
        Todos todo = new Todos();
        todo.setContent(todoCreateDto.getContent());
        todo.setUserId(todoCreateDto.getUserId());
        todo.setCreatedAt(todoCreateDto.getCreatedAt());
        todo = todoRepository.save(todo);
        // TODO: toString() daha sonra silinecek
        System.out.println(todo.toString());

        return todo;
    }

    public Todos update(TodoUpdateDto todoUpdateDto) {
        Todos todo = getById(todoUpdateDto.getId());

        if (todo == null) {
            return null;
        }

        todo.setId(todoUpdateDto.getId());
        todo.setContent(todoUpdateDto.getContent());
        todo.setUpdatedAt(todoUpdateDto.getUpdatedAt());
        todo = todoRepository.save(todo);
        // TODO: toString() daha sonra silinecek
        System.out.println(todo.toString());

        return todo;
    }

    public boolean delete(DeleteDto deleteDto) {
        Todos todo = getById(deleteDto.getId());

        if (todo == null) {
            return false;
        }

        todo.setDeletedAt(deleteDto.getDeletedAt());
        // TODO: toString() daha sonra silinecek
        System.out.println(todo.toString());

        todoRepository.delete(todo);
        return true;
    }
}
