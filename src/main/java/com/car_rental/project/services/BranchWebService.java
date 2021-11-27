package com.car_rental.project.services;

import com.car_rental.project.model.Branch;

import java.util.List;

public interface BranchWebService {
    List<Branch> getAllBranch();
    void saveBranch(Branch branch);
    Branch getBranchById(long id);
    void deleteBranchByID(long id);


}

