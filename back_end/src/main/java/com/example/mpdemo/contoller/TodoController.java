package com.example.mpdemo.contoller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mpdemo.entity.TodoItem;
import com.example.mpdemo.mapper.TodosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TodoController {
    @Autowired
    private TodosMapper todosMapper;
    @GetMapping("/hello")
    public String hello(){
        return "Hello, Todolist？";
    }
    @GetMapping("/getAllTodos")
    public List getAllTodos(){
        List<TodoItem> list = todosMapper.selectList(null);
//        System.out.println(list);
        return list;
    }

    @PostMapping("/addTodos")
    public String addTodos(@RequestBody TodoItem todoItem){
        int res = todosMapper.insert(todoItem);
        System.out.println(todoItem);
        if(res>0)
            return res+" Insertion Succeeded!";
        else
            return "Insertion Failed!";
    }

    @PostMapping("/deleteTodos")
    public String deleteTodos(@RequestBody TodoItem todoItem){
        int res = todosMapper.deleteById(todoItem.getId());
        if(res>0)
            return res+" Deletion Succeeded!";
        else
            return "Deletion Failed!";
    }

    @PostMapping("/updateTodos")
    public String updateTodos(@RequestBody TodoItem todoItem){
        TodoItem old = todosMapper.selectById(todoItem.getId());
        todoItem.setDone(!old.isDone());
        int res = todosMapper.updateById(todoItem);
        if(res>0)
            return res+"Updation Succeeded!";
        else
            return "Updation Failed!";
    }

    @PostMapping("/updateAllTodos")
    public String updateAllTodos(@RequestBody TodoItem todoItem){
        int success=0;
        boolean done = todoItem.isDone();
        List<TodoItem> list = todosMapper.selectList(null);
        for(TodoItem i:list){
            i.setDone(done);
            success+=todosMapper.updateById(i);
        }
        return success+" Updation Succeeded! "+(list.size()-success)+" Updation Failed!";
    }
    @GetMapping("/deleteAllDoneTodos")
    public String deleteAllDoneTodos(){
        int success = 0;
        QueryWrapper<TodoItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("done",true);
        List<TodoItem> list  = todosMapper.selectList(queryWrapper);
        for(TodoItem i:list)
            success+=todosMapper.deleteById(i.getId());
        return success+" Deletion Succeeded! "+(list.size()-success)+" Deletion Failed!";
    }
}
