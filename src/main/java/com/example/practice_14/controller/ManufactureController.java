package com.example.practice_14.controller;

import com.example.practice_14.dao.ManufactureDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufactures")
public class ManufactureController {

    private final ManufactureDAO manufactureDAO;

    @Autowired
    public ManufactureController(ManufactureDAO manufactureDAO) {
        this.manufactureDAO = manufactureDAO;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Manufacture> getAllManufactures() {
        return manufactureDAO.getAllManufactures();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Manufacture getManufacture(@PathVariable int id) {
        return manufactureDAO.getManufacture(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Manufacture createManufacture(@RequestBody Manufacture manufacture) {
        return manufactureDAO.createManufacture(manufacture);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteManufacture(@PathVariable int id){
        manufactureDAO.deleteManufacture(id);
    }
}
