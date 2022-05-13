package com.example.practice_14.dao;

import com.example.practice_14.controller.Manufacture;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManufactureDAO {
    private static int MANUFACTURES_COUNT;
    private final List<Manufacture> manufactures;

    {
        manufactures = new ArrayList<>();
        manufactures.add(new Manufacture(++MANUFACTURES_COUNT, "Tom", "Little Hangleton, England, Great Britain"));
        manufactures.add(new Manufacture(++MANUFACTURES_COUNT, "Draco", "Wiltshire, England, Great Britain"));
        manufactures.add(new Manufacture(++MANUFACTURES_COUNT, "Sirius", "12 Grimmauld Place, Islington, London, England, Great Britain"));
        manufactures.add(new Manufacture(++MANUFACTURES_COUNT, "Severus", "Cokeworth, England, Great Britain"));
    }

    public List<Manufacture> getAllManufactures() {
        return manufactures;
    }

    public Manufacture getManufacture(int id) {
        return manufactures.stream().filter(manufacture -> manufacture.getId() == id).findAny().orElse(null);
    }

    public Manufacture createManufacture(Manufacture manufacture) {
        manufactures.add(manufacture);
        return manufacture;
    }

    public void deleteManufacture(int id) {
        manufactures.remove(manufactures.stream().filter(manufacture -> manufacture.getId() == id).findAny().orElse(null));
    }
}
