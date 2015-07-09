package com.marlabs.trainee.dao.interfaces;

import com.marlabs.trainee.model.Car;

import java.util.List;

/**
 * Created by Rico on 7/3/15.
 */
public interface CarDao {
    public Car saveCar(Car car);

    public void deleteCar(Car car);

    public Car getCarById(long id);

    public List<Car> getAllCars();
}
