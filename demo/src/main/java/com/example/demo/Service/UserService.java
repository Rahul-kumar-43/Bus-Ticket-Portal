package com.example.demo.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.example.demo.Entity.User;
import com.example.demo.Entity.Booking;
import com.example.demo.Repository.UserRepository;
@Service
public class UserService {
    @Autowired
    UserRepository repo;
    public User saveUser(User user) {
        for (Booking booking : user.getBookings()) {
            booking.setUser(user);
        }
        return repo.save(user);
    }
    public List<User> getAllUsers() {
        return repo.findAll();
    }
    public User getUserById(int id) {
        return repo.findById(id).orElse(null);
    }
    public void updateUser(User user) {
        repo.save(user);
    }
    public void deleteUser(int id) {
        repo.deleteById(id);
    }

    public User getUserByUsername(String username) {
        return repo.getUserByUsername(username);
    }
    public List<User> sort(String field) {
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        return repo.findAll(sort);
    }
    public List<User> page(int pageSize, int pageNumber) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return repo.findAll(page).getContent();
    }
    public List<User> pagesort(int pageSize, int pageNumber, String field) {
        return repo.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(Sort.Direction.ASC, field)))
                .getContent();
    }
}
