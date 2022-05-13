package com.example.practice_14.controller;

import com.example.practice_14.dao.WorkerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerDAO workerDAO;

    @Autowired
    public WorkerController(WorkerDAO workerDAO) {
        this.workerDAO = workerDAO;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Worker> getAllWorkers() {
        return workerDAO.getAllWorkers();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Worker createWorker(@PathVariable("id") int id) {
        return workerDAO.getWorker(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Worker createWorker(@RequestBody Worker worker) {
        return workerDAO.createWorker(worker);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteWorker(@PathVariable int id) {
        workerDAO.deleteWorker(id);
    }
}

