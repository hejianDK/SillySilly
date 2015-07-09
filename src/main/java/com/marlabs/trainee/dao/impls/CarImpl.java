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
@Repository(value = "CarDao")
@Transactional
public class CarImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    private final Session session = sessionFactory.getCurrentSession();

    @Override
    public Car saveCar(Car car) {
        session.saveOrUpdate(car);
        return car;
    }

    @Override
    public void deleteCar(Car car) {
        session.delete(car);
    }

    @Override
    public Car getCarById(long id) {
        return session.get(Car.class, id);
    }


    @Override
    public List<Car> getAllCars() {
        return sessionFactory.getCurrentSession().createQuery("FROM Car").list();
    }

}
