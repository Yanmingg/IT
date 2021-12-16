package com.example.crm.controller;

import com.example.crm.entity.Task;
import com.example.crm.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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


    @GetMapping("/finduser/{userid}")
    public List<Task> findUser(@PathVariable("userid") Integer id){
        List<Task> taskList = taskRepository.findAll();
        List<Task> taskList1 = new ArrayList<>();
        for (Task task: taskList){
            if(task.getUserId() == id){
                taskList1.add(task);
            }
        }
        return taskList1;
    }



    @GetMapping("/findclose/{userid}")
    public Task findClose(@PathVariable("userid") Integer id){
        List<Task> taskList = taskRepository.findAll();
        List<Task> taskList1 = new ArrayList<>();
        for (Task task: taskList){
            if(task.getUserId() == id && task.getCompleted() == false){
                taskList1.add(task);
            }
        }
        if(taskList1.isEmpty()){
            return null;
        }
        Task smallestTask = taskList1.get(0);
        for (Task task:taskList1){
            if(smallestTask.getTime().compareTo(task.getTime()) < 0){
                smallestTask = task;
            }
        }
        System.out.println(smallestTask.getTime());
        return smallestTask;
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
