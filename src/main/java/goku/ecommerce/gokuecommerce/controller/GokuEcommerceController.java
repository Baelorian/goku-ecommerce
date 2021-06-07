package goku.ecommerce.gokuecommerce.controller;

import goku.ecommerce.gokuecommerce.entity.Users;
import goku.ecommerce.gokuecommerce.repository.UserRepository;
import goku.ecommerce.gokuecommerce.service.GokuEcommerceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
    public ResponseEntity getUser (@RequestHeader(value = "authorization") String token,
                                   @PathVariable("userid") Integer userid){
        boolean isValid = GokuEcommerceService.authenticate(token);
            return UserRepository.findById(userid)
                    .map(record -> ResponseEntity.ok().body(record))
                    .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/api/user/cep/{cep}")
    @Cacheable("UserByCep")
    public ResponseEntity<List<Users>> getUserByCep (@RequestHeader(value = "authorization") String token,
                                                     @PathVariable("cep") String cep){
        boolean isValid = GokuEcommerceService.authenticate(token);
        List<Users> UserByCep = UserRepository.findByCep(cep);
        return ResponseEntity.status(HttpStatus.OK).body(UserByCep);
    }


    @GetMapping(path = "/api/login")
    public ResponseEntity<Boolean> Login(@RequestHeader(value = "authorization") String token,
                                         @RequestParam String identifier,
                                         @RequestParam String password){
        boolean isValid = GokuEcommerceService.authenticate(token);
        GokuEcommerceService.Login(identifier,password);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostMapping(path = "/api/users/save")
    public ResponseEntity<Users>  setUsers(@RequestHeader(value = "authorization") String token,
                                           @RequestBody Users users){
        boolean isValid = GokuEcommerceService.authenticate(token);
        GokuEcommerceService.FindDuplicityAndInvalid(users);
        UserRepository.save(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }

}

