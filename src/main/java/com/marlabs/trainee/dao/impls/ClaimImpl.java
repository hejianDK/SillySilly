package com.marlabs.trainee.dao.impls;

import com.marlabs.trainee.dao.interfaces.ClaimDao;
import com.marlabs.trainee.model.Claim;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rico on 7/5/15.
 */
@Repository("claimDao")

public class ClaimImpl implements ClaimDao {

    @Override
    public long saveClaim(Claim c) {
        return 0;
    }

    @Override
    public void deleteClaim(Claim c) {

    }

    @Override
    public List<Claim> getAllClaims() {
        return null;
    }

    @Override
    public Claim getClaimById(long cid) {
        return null;
    }

}
