package com.marlabs.trainee.dao.interfaces;

import com.marlabs.trainee.model.Car;

/**
 * Created by Rico on 7/3/15.
 */
public interface CarDao {
    public void addCar(Car car);
    public void deleteCar(Car car);
    public void updateCar(Car car);
    public Car getCarById (long id);
}
