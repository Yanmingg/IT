package com.example.crm.controller;

import com.example.crm.entity.Contact;
import com.example.crm.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/contact")
public class ContactHandler {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/findAll")
    public List<Contact> findAll(){
        return contactRepository.findAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody Contact contact){
        Contact result = contactRepository.save(contact);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findid/{contactid}")
    public Contact findId(@PathVariable("contactid") Integer id){
        contactRepository.findById(id);
        return contactRepository.getById(id);
    }

    @GetMapping("/findname/{Name}")
    public List<Contact> findUser(@PathVariable("Name") String name){
        List<Contact> contactList = contactRepository.findAll();
        List<Contact> contactList1 = new ArrayList<>();
        for (Contact contact: contactList){
            if(contact.getName().toLowerCase().contains(name.toLowerCase())){
                contactList1.add(contact);
            }
        }
        return contactList1;
    }

    @GetMapping("/finduser/{Userid}")
    public List<Contact> findUser(@PathVariable("Userid") Integer id){
        List<Contact> contactList = contactRepository.findAll();
        List<Contact> contactList1 = new ArrayList<>();
        for (Contact contact: contactList){
            if(contact.getUserId() == id){
                contactList1.add(contact);
            }
        }
        return contactList1;
    }

    @DeleteMapping("/deleteid/{id}")
    public void deleteId(@PathVariable("id") Integer id){
        contactRepository.deleteById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody Contact contact){
        Contact result = contactRepository.save(contact);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }
}
