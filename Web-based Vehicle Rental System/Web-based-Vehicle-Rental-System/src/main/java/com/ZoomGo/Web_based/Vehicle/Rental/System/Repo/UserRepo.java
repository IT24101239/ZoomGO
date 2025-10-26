package com.ZoomGo.Web_based.Vehicle.Rental.System.Repo;

import com.ZoomGo.Web_based.Vehicle.Rental.System.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
