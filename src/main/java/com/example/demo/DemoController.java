package com.example.demo;

import de.huxhorn.sulky.ulid.ULID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final PersonRepository repository;

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String get() {
        return "Hello World!";
    }

    @GetMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonEntity insert(@RequestParam Long age) {
        PersonEntity build = PersonEntity.builder()
                .age(age)
                .nome(new ULID().nextULID())
                .build();
        PersonEntity save = repository.save(build);
        return save;
    }

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonEntity> getByAge(@RequestParam Long age, @RequestParam(defaultValue = "5") int size) {
        return repository.findByAge(age, PageRequest.of(0, size));
    }

}
