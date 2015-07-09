package com.marlabs.trainee.dao.impls;

import com.marlabs.trainee.dao.interfaces.ClaimDao;
import com.marlabs.trainee.model.Claim;

import java.util.List;

/**
 * Created by Rico on 7/5/15.
 */
public class ClaimImpl implements ClaimDao {
    @Override
    public Claim saveClaim(Claim c) {
        return c;
    }

    @Override
    public void deleteClaim(Claim c) {

    }

    @Override
    public List<Claim> getAllClaims() {
        return null;
    }

}
