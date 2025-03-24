package com.example.demo.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Admin;
import com.example.demo.Repository.AdminRepository;
@Service
public class AdminService {
    @Autowired
    AdminRepository repo;
    public List<Admin> getAllAdmins() {
        return repo.findAll();
    }
    public Admin getAdminById(int id) {
        return repo.findById(id).get();
    }
    public void AddAdmin(Admin prod) {
        repo.save(prod);
    }
    public void UpdateAdmin(Admin prod) {
        repo.save(prod);
    }

    public void DeleteAdmin(int id) {
        repo.deleteById(id);
    }
    public Admin getAdminByName(String name) {
        return repo.getAdminByName(name);
    }
    public Admin getAdminByEmail(String email) {
        return repo.getAdminByEmail(email);
    }
    public List<Admin> sort(String field){
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        return repo.findAll(sort);
    }
    public List<Admin> page(int pageSize, int pageNumber) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return repo.findAll(page).getContent();
    } 
    public List<Admin> pagesort(int pageSize, int pageNumber, String field) {
        return repo.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(Sort.Direction.ASC, field)))
                .getContent();
    }
}
