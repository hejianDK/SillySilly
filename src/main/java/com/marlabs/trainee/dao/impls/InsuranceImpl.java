package com.marlabs.trainee.dao.impls;

import com.marlabs.trainee.dao.interfaces.InsuranceDao;
import com.marlabs.trainee.model.Insurance;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rico on 7/21/15.
 */
@Repository("insuranceDao")
public class InsuranceImpl implements InsuranceDao{

    @Override
    public long saveInsurance(Insurance i) {
        return 0;
    }

    @Override
    public void delteInsurance(Insurance i) {

    }

    @Override
    public List<Insurance> getAllInsurances() {
        return null;
    }

    @Override
    public Insurance getInsuranceById(long iId) {
        return null;
    }
}
