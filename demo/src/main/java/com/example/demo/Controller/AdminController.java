package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Admin;
import com.example.demo.Service.AdminService;

@RestController
public class AdminController {

    @Autowired
    AdminService service;

    @GetMapping("/admin")
    public List<Admin>getAllAdmins() {
        return service.getAllAdmins();
    }

    @GetMapping("/admin/{id}")
    public String getAdminById(int id) {
        return service.getAdminById(id).toString();
    }

    @PostMapping("/admin")
    public void AddAdmin(@RequestBody Admin admin) {
        service.AddAdmin(admin);
    }

    @PutMapping("/admin")
    public void UpdateAdmin(@RequestBody Admin admin) {
        service.UpdateAdmin(admin);
    }

    @DeleteMapping("/admin/{id}")
    public void DeleteAdmin(int id) {
        service.DeleteAdmin(id);
    }

    @GetMapping("/admin/name/{name}")
    public ResponseEntity<Admin> getAdminByName(@PathVariable String name) {
        Admin admin = service.getAdminByName(name);
        if (admin == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(admin);
    }

    @GetMapping("/admin/email/{email}")
    public ResponseEntity<Admin> getAdminByEmail(@PathVariable String email) {
        Admin admin = service.getAdminByEmail(email);
        if (admin == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(admin);
    }




    @GetMapping("/admin/sortby/{field}")
    public List<Admin> sortAdmins(@PathVariable String field) {
        return service.sort(field);
    }
    @GetMapping("/admin/{offset}/{pagesize}")
    public List<Admin> pageAdmins(@PathVariable int offset, @PathVariable int pagesize) {
        return service.page(offset,pagesize);
    }
    @GetMapping("/admin/{offset}/{pagesize}/{field}")
    public List<Admin> pagesortAdmins(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field) {
        return service.pagesort(offset,pagesize,field);
    }

}
