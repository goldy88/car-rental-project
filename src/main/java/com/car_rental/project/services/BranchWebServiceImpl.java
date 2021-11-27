package com.car_rental.project.services;

import com.car_rental.project.model.Branch;
import com.car_rental.project.repository.BranchRepository;
import com.car_rental.project.repository.RentalOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchWebServiceImpl implements BranchWebService {

    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private RentalOfficeRepository rentalOfficeRepository;

    @Override
    public List < Branch > getAllBranch() {
        return branchRepository.findAll();
    }

    @Override
    public void saveBranch(Branch branch) {
        branch.setIdRentalOffice(rentalOfficeRepository.getById(1L));
        this.branchRepository.save(branch);

    }

    @Override
    public Branch getBranchById(long id) {
        Optional<Branch> optional = branchRepository.findById(id);
        Branch branch = null;
        if (optional.isPresent()){
            branch=optional.get();
        }else {
            throw new RuntimeException(" branch not found for id :: " + id);
        }
        return branch;

    }

    @Override
    public void deleteBranchByID(long id) {
        this.branchRepository.deleteById(id);
    }

}
