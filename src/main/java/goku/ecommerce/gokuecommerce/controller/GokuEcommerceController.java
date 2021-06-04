package goku.ecommerce.gokuecommerce.controller;

import goku.ecommerce.gokuecommerce.entity.Users;
import goku.ecommerce.gokuecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GokuEcommerceController {

    @Autowired
    private UserRepository repo;


    @GetMapping(path = "/teste")
    public String teste() {
        return "Ok";
    }

    @GetMapping(path = "/api/user/{userid}")
    public ResponseEntity getUser (@PathVariable("userid") Integer userid){
        return repo.findById(userid)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/api/users/save")
    public Users setUsers(@RequestBody
                                      Users users){
        return repo.save(users);
//        tratar id nulo
    }

}

