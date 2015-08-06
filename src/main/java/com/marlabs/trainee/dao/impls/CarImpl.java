package com.marlabs.trainee.dao.impls;

import com.marlabs.trainee.dao.interfaces.CarDao;
import com.marlabs.trainee.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rico on 7/3/15.
 */

@Repository("carDao")
public class CarImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long saveCar(Car car) {
        return (long) sessionFactory.getCurrentSession().save(car);

    }

    @Override
    public void deleteCar(Car car) {
        sessionFactory.getCurrentSession().delete(car);
    }

    @Override
    public Car getCarById(long id) {
        return (Car)sessionFactory.getCurrentSession().get(Car.class, id);
    }


    @Override
    public List<Car> getAllCars() {
        return sessionFactory.getCurrentSession().createQuery("FROM Car").list();
    }

}
