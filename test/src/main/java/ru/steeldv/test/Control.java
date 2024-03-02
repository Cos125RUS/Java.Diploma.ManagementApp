package ru.steeldv.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class Control {
    private final Repo repo;
    @GetMapping
    public List<SomeData> findAll() {
        return repo.findAll();
    }

    @PostMapping
    public SomeData add(SomeData someData){
        return repo.save(someData);
    }
}
