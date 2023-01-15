package com.example.demo.dao;

import com.example.demo.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorDao {
    public List<Sensor> findAll();

    public Sensor findById(int id);

    public int deleteById(int id);

    void saveSensor(Sensor sensor);

    public List<Sensor> searchByName(String searchName);

    public int save(Sensor sensor);

    public Sensor update(Sensor sensor);

    public List<Sensor> searchSensor(String query);

}
