package com.marlabs.trainee.dao.interfaces;

import com.marlabs.trainee.model.Claim;

import java.util.List;

/**
 * Created by Rico on 7/1/15.
 */
public interface ClaimDao {
    public Claim saveClaim(Claim c);
    public void deleteClaim(Claim c);
    public List<Claim> getAllClaims();
}
