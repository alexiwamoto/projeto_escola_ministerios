package com.escola.ministerios.controller;

import com.escola.ministerios.repository.UserRepository;
import com.escola.ministerios.domain.AppUser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {

    @Inject
    UserRepository userRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello there !";
    }

    @RequestMapping(value = "/userpo" /*{username}*/, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public AppUser create(/*@PathVariable String username*/@RequestBody AppUser user) {
        return userRepository.save(new AppUser(user.getUsername()));
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AppUser> findAll() {
        final List<AppUser> resultList = new ArrayList<>();
        final Iterable<AppUser> all = userRepository.findAll();
        all.forEach(new Consumer<AppUser>() {
            @Override
            public void accept(AppUser appUser) {
                resultList.add(appUser);
            }
        });
        return resultList;
    }

  @RequestMapping(value = "/drop/{username}", method = RequestMethod.POST)
  public void dropUser(@PathVariable String username) {
    final Iterable<AppUser> all = userRepository.findAll();
    Long id = -1L;
    for(AppUser appUser : all){
      if(appUser.getUsername().equals(username)) id = appUser.getId();
    }
    userRepository.delete(id);
  }

}
