package com.example.demo.repository;

import com.example.demo.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends CrudRepository<Sensor, Integer> {

    Sensor findSensorById(int id);


    @Modifying
    @Query("update Sensor s SET s.models = :models WHERE s.id = :id")
    public void updateSensortUsingQueryAnnotation(@Param("models") String studentName, @Param("id") int id);

    @Query("SELECT COUNT(s) FROM Sensor s WHERE s.names=:names")
    long aMethodNameOrSomething(@Param("names") String name);
}
