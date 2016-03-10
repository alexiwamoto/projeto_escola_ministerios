package com.escola.ministerios.controller;

import com.escola.ministerios.domain.Worker;
import com.escola.ministerios.repository.WorkerRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by alexandre on 10/03/16.
 */
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkerController {

  @Inject
  WorkerRepository workerRepository;

  @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public Worker create(@RequestBody Worker worker) {
    return workerRepository.save(new Worker(worker.getName(),
                                            worker.getLastname(),worker.getAddress(),
                                            worker.getEmail1(), worker.getEmail2(),
                                            worker.getPhone1(), worker.getPhone2(),
                                            worker.getService(), worker.getDescription()));
  }

  @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Worker> findAll() {
    final List<Worker> resultList = new ArrayList<>();
    final Iterable<Worker> all = workerRepository.findAll();
    all.forEach(new Consumer<Worker>() {
      @Override
      public void accept(Worker worker) {
        resultList.add(worker);
      }
    });
    return resultList;
  }

  /*@RequestMapping(value = "/drop/{username}", method = RequestMethod.POST)
  public void dropUser(@PathVariable String username) {
    final Iterable<AppUser> all = userRepository.findAll();
    Long id = -1L;
    for(AppUser appUser : all){
      if(appUser.getUsername().equals(username)) id = appUser.getId();
    }
    userRepository.delete(id);
  }*/

}
