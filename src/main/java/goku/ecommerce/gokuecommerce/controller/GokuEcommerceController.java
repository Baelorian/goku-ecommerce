package goku.ecommerce.gokuecommerce.controller;

import goku.ecommerce.gokuecommerce.entity.Users;
import goku.ecommerce.gokuecommerce.repository.UserRepository;
import goku.ecommerce.gokuecommerce.service.GokuEcommerceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class GokuEcommerceController {

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private GokuEcommerceService GokuEcommerceService;

    @GetMapping(path = "/teste")
    @Cacheable("teste")
    public String teste() {
        log.info("OK");
        return "Ok";
    }

    @GetMapping(path = "/api/user/{userid}")
    @Cacheable("getUser")
    public ResponseEntity getUser (@PathVariable("userid") Integer userid){
        return UserRepository.findById(userid)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/api/user/cep/{cep}")
    @Cacheable("UserByCep")
    public ResponseEntity<List<Users>> getUserByCep (@PathVariable("cep") String cep){
        List<Users> UserByCep = UserRepository.findByCep(cep);
        return ResponseEntity.status(HttpStatus.OK).body(UserByCep);
    }

    @PostMapping(path = "/api/users/save")
    public ResponseEntity<Users>  setUsers(@RequestBody Users users){
        GokuEcommerceService.FindDuplicityAndInvalid(users);
        UserRepository.save(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }

}

