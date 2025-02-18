package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

      @Autowired
      UserService service;


      @GetMapping
      public List<User> getUser() {
          return service.getAllUsers();
      } 

      @GetMapping("/{id}")
        public User getUserById(@PathVariable int id) {
            return service.getUserById(id);
        }

      @PostMapping
        public void AddUser(@RequestBody User user) {
            service.AddUser(user);
        }

      @PutMapping("/{id}")
        public void UpdateUser(@RequestBody User user) {
            service.UpdateUser(user);
        } 

        @DeleteMapping("/{id}")
        public void DeleteUser(@PathVariable int id) {
            service.DeleteUser(id);
        }
        @PostMapping("/addUsers")
        public List<User> AddUsers(@RequestBody List<User> users) {
            return service.AddUsers(users);
        }

        @GetMapping("/sortBy/{field}")
        public List<User> sortUsers(@PathVariable String field) {
            return service.sort(field);
        }

        @GetMapping("/{offset}/{pagesize}")
        public List<User> getUsers(@PathVariable int offset, @PathVariable int pagesize) {
            return service.page(pagesize, offset);
        }

        @GetMapping("/{offset}/{pagesize}/{field}")
        public List<User> pageSortingUsers(@PathVariable int offset, @PathVariable int pagesize,@PathVariable String field) {
            return service.pagesort(pagesize, offset, field);
        }

}
