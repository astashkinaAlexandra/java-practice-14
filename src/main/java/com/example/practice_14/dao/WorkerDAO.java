package com.example.practice_14.dao;

import com.example.practice_14.controller.Worker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkerDAO {
    private static int WORKERS_COUNT;
    private final List<Worker> workers;

    {
        workers = new ArrayList<>();
        workers.add(new Worker(++WORKERS_COUNT, "Tom", "Riddle", "Marvolo"));
        workers.add(new Worker(++WORKERS_COUNT, "Draco", "Malfoy", "Lucius"));
        workers.add(new Worker(++WORKERS_COUNT, "Sirius", "Black", "Orion"));
        workers.add(new Worker(++WORKERS_COUNT, "Severus", "Snape", "Tobias"));
    }

    public List<Worker> getAllWorkers() {
        return workers;
    }

    public Worker getWorker(int id) {
        return workers.stream().filter(worker -> worker.getId() == id).findAny().orElse(null);
    }

    public Worker createWorker(Worker worker) {
        worker.setId(++WORKERS_COUNT);
        workers.add(worker);
        return worker;
    }

    public void deleteWorker(int id) {
        workers.remove(workers.stream().filter(worker -> worker.getId() == id).findAny().orElse(null));
    }
}
