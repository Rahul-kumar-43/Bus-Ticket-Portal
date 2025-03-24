package com.example.demo.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Bus;
import com.example.demo.Repository.BusRepository;
@Service
public class BusService {
    @Autowired
    private BusRepository repo;
    public Bus getBusById(long id) {
        return repo.findById(id).get();
    }
    public List<Bus> getAllBuses() {
        return repo.findAll();
    }
    public void addBus(Bus bus) {
        repo.save(bus);
    }
    public void deleteAllBuses() {
        repo.deleteAll();
    }
    public void updateBus(Bus bus) {
        repo.save(bus);
    }
    public Bus getBusByRoute(String route) {
        return repo.getBusByRoute(route);
    }
    public void deleteBusById(long id) {
        repo.deleteById(id);
    }
    public List<Bus>sort(String field){
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        return repo.findAll(sort);
    }
    public List<Bus> page(int pageSize, int pageNumber) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return repo.findAll(page).getContent();   
    }
    public List<Bus> pagesort(int pageSize, int pageNumber, String field) {
        return repo.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(Sort.Direction.ASC, field)))
                .getContent();
    }
}