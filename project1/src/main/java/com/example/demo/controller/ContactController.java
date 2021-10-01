package com.example.demo.controller;


import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MarkerHub
 * @since 2021-09-30
 */
@RestController
public class ContactController {
    @Autowired
    ContactService  contactService;

    @CrossOrigin
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public Object index(){
        ArrayList<Contact> list = new ArrayList<>();
        int i = 1;
        while(contactService.getById(i) != null) {
            Contact contact = contactService.getById(i);
            list.add(contact);
            i++;
        }
        return list;
    }

    @RequestMapping(value = "/contact/{contactId}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("contactId") Integer contactId){
        contactService.removeById(contactId);
    }

    @RequestMapping(value = "/contact/addclient", method = RequestMethod.POST)
    public void postObject(Contact contact){
        contactService.save(contact);
    }

}
