package goku.ecommerce.gokuecommerce.service;


import goku.ecommerce.gokuecommerce.entity.Users;
import goku.ecommerce.gokuecommerce.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@Service
@Slf4j
public class GokuEcommerceService {

    @Autowired
    private UserRepository UserRepository;


    public Users FindDuplicity(Users user){
        String aseas = UserRepository.findDocumentDuplicity(user.getDocument());
            log.info("FindDuplicity(): User: {}", user);
            if (!aseas.isEmpty()){
                log.error("FindDuplicity(): Document Duplicity {}", aseas);
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This document has already been registered");
            }
        return user;
    }

}
