package com.example.demo.service;

import com.example.demo.dao.SensorDao;
import com.example.demo.model.Sensor;
import com.example.demo.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private SensorDao sensorDao;

    public void save(Sensor sensor){
        sensorRepository.save(sensor);
    }

    public void update(Sensor sensor){
        sensorDao.update(sensor);
    }

    public List<Sensor> findSensorByName(String model){
        List<Sensor> sensors = sensorRepository.findAllByName(model);
        return sensors;
    }

    public List<Sensor> searchByName(String searchName) {

        List<Sensor> sensorList = sensorDao.searchByName(searchName);

        return sensorList;
    }

    public List<Sensor> searchSensor(String query){
        List<Sensor> sensors = sensorDao.searchSensor(query);
        return sensors;
    }

}
