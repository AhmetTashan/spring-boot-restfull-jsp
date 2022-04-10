package cc.tashan.api;

import cc.tashan.dto.DeleteDto;
import cc.tashan.dto.TodoCreateDto;
import cc.tashan.dto.TodoUpdateDto;
import cc.tashan.model.Todos;
import cc.tashan.service.TodoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@Api(value = "Todo API")
public class TodoApi {

    @Autowired
    private TodoService todoService;

    @GetMapping("/list")
    @ApiOperation(value = "Tüm todo listesini getirir")
    public ResponseEntity<List<Todos>> list() {
        List<Todos> todos = todoService.getAll();
        return ResponseEntity.ok().body(todos);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Todo getirir")
    public ResponseEntity<Todos> get(@ApiParam @PathVariable("id") Long id) {
        Todos todo = todoService.getById(id);
        return ResponseEntity.ok().body(todo);
    }

    @PostMapping("/")
    @ApiOperation(value = "Todo ekler")
    public ResponseEntity<Todos> save(@ApiParam @RequestBody TodoCreateDto todo) {
        Todos savedTodo = todoService.create(todo);
        return ResponseEntity.ok().body(savedTodo);
    }

    @PutMapping("/")
    @ApiOperation(value = "Todo günceller")
    public ResponseEntity<Todos> update(@ApiParam @RequestBody TodoUpdateDto todo) {
        Todos updatedTodo = todoService.update(todo);
        return ResponseEntity.ok().body(updatedTodo);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Todo siler")
    public ResponseEntity<Void> delete(@ApiParam @RequestBody DeleteDto delete) {
        todoService.delete(delete);
        return ResponseEntity.ok().build();
    }
}
