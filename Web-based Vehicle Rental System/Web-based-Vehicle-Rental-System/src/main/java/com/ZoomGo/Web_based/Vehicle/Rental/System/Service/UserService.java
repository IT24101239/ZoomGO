package com.ZoomGo.Web_based.Vehicle.Rental.System.Service;

import com.ZoomGo.Web_based.Vehicle.Rental.System.Model.User;
import com.ZoomGo.Web_based.Vehicle.Rental.System.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    public User getUserById(int id) {
        return userRepo.findById(id).orElseThrow();
    }
}
