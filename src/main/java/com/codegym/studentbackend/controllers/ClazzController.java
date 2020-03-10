package com.codegym.studentbackend.controllers;

import com.codegym.studentbackend.models.Class;
import com.codegym.studentbackend.services.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @GetMapping("/class")
    public ResponseEntity<List<Class>> getAllClass() {
        List<Class> classList = clazzService.getAllClass();
        return new ResponseEntity<>(classList, HttpStatus.OK);
    }

    @GetMapping("/class/{id}")
    public ResponseEntity<Class> findClassById(@PathVariable("id") Long id) {
        Class clazz = clazzService.findClassById(id);
        if (clazz == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clazz, HttpStatus.OK);
    }

    @DeleteMapping("/class/{id}")
    public ResponseEntity<Class> deleteClass(@PathVariable("id") Long id) {
        Class clazz = clazzService.findClassById(id);
        if (clazz == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        clazzService.deleteClass(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}