package goku.ecommerce.gokuecommerce.controller;

import goku.ecommerce.gokuecommerce.entity.Users;
import goku.ecommerce.gokuecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GokuEcommerceController {

    @Autowired
    private UserRepository UserRepository;

    @GetMapping(path = "/teste")
    public String teste() {
        return "Ok";
    }

    @GetMapping(path = "/api/user/{userid}")
    public ResponseEntity getUser (@PathVariable("userid") Integer userid){
        return UserRepository.findById(userid)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/api/user/cep/{cep}")
    public ResponseEntity<Page<Users>> getUserByCep (@PathVariable("cep") String cep){
        Page<Users> UserByCep = UserRepository.findByCep(cep, Pageable.unpaged());
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(UserByCep);
    }

    @PostMapping(path = "/api/users/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Users setUsers(@RequestBody Users users){
        return UserRepository.save(users);
    }

}

