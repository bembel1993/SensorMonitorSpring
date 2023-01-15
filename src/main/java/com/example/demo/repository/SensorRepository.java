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

    @Query("SELECT s FROM Sensor s WHERE s.names LIKE %:models%")
    List<Sensor> findAllByName(@Param("models") String names);

    @Query("select count(s) from Sensor s")
    int numDeviceEventsWithAlarm ();

    @Query("SELECT s FROM Sensor s WHERE " +
            "s.names LIKE CONCAT('%',:query, '%')" +
            "Or s.models LIKE CONCAT('%', :query, '%')"+
            "Or s.types LIKE CONCAT('%', :query, '%')"+
            "Or s.ranges LIKE CONCAT('%', :query, '%')"+
            "Or s.location LIKE CONCAT('%', :query, '%')"+
            "Or s.description LIKE CONCAT('%', :query, '%')"+
            "Or s.units LIKE CONCAT('%', :query, '%')")
    List<Sensor> searchSensor(String query);
}
