//package ru.steeldv.library.service;
//
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public class ManagementServiceImpl<T, R extends JpaRepository<T, Long>> implements ManagementService<T>{
//    @Autowired
//    protected R repo;
//
//    @Override
//    public List<T> findAll() {
//        return repo.findAll();
//    }
//
//    @Override
//    public T add(T entity) {
//        return repo.save(entity);
//    }
//
//    @Override
//    public T findById(Long id) {
//        return repo.findById(id).get();
//    }
//
//    @Override
//    public T update(T entity, Long id) {
//        return repo.save(entity);
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        repo.deleteById(id);
//    }
//}
