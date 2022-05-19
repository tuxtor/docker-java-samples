package com.vorozco.controller;

import com.vorozco.model.AdmBook;
import com.vorozco.repository.AdmBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/books")
public class AdmBookController {
    private AdmBookRepository admBookRepository;

    @Autowired
    public AdmBookController(AdmBookRepository admBookRepository) {
        this.admBookRepository = admBookRepository;
    }

    @GetMapping
    public Iterable<AdmBook> getAll() {
        return admBookRepository.findAll();
    }

    @GetMapping("/{id}")
    public AdmBook getById(@PathVariable Long id) {
        return admBookRepository.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AdmBook create(@RequestBody AdmBook book) {
        return admBookRepository.save(book);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AdmBook update(@PathVariable Long id, @RequestBody AdmBook book) {
        return admBookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        admBookRepository.deleteById(id);
    }


}
