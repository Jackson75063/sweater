package ua.jackson.sweater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.jackson.sweater.domain.Role;
import ua.jackson.sweater.domain.User;
import ua.jackson.sweater.repository.UserRepo;

import java.util.Collections;
import java.util.Map;


@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){

        return "registration";
    }


    @PostMapping("/registration")
    public String addUser(User user, Map<String,Object> model){

        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null){
            model.put("message","User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }

}