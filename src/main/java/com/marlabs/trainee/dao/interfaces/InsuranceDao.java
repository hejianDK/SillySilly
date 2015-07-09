package com.marlabs.trainee.dao.interfaces;

import com.marlabs.trainee.model.Insurance;

import java.util.List;

/**
 * Created by Rico on 7/3/15.
 */
public interface InsuranceDao {
    public Insurance saveInsurance(Insurance i);
    public void delteInsurance(Insurance i);
    public List<Insurance> getAllInsurances();
}
