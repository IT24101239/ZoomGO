package com.ZoomGo.Web_based.Vehicle.Rental.System.Repo;

import com.ZoomGo.Web_based.Vehicle.Rental.System.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
    Admin findByName(String name);
}
