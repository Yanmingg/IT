package com.example.crm.controller;

import com.example.crm.entity.Contact;
import com.example.crm.entity.Task;
import com.example.crm.repository.ContactRepository;
import com.example.crm.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/task")
public class TaskHandler {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/findAll")
    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody Task task){
        Task result = taskRepository.save(task);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findid/{taskid}")
    public Task findId(@PathVariable("taskid") Integer id){
        taskRepository.findById(id);
        return taskRepository.getById(id);
    }

    @GetMapping("/findclose/{userid}")
    public Task findClose(@PathVariable("userid") Integer id){
        taskRepository.findById(id);
        return taskRepository.getById(id);
    }

    @DeleteMapping("/deleteid/{id}")
    public void deleteId(@PathVariable("id") Integer id){
        taskRepository.deleteById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody Task task){
        Task result = taskRepository.save(task);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }

}
