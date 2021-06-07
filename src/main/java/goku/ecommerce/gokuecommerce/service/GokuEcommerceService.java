package goku.ecommerce.gokuecommerce.service;


import goku.ecommerce.gokuecommerce.constants.constants;
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


    public Users FindDuplicityAndInvalid(Users user) {
        String document = UserRepository.findDocumentDuplicity(user.getDocument());
        log.info("FindDuplicityAndInvalid(): User: {}", user);
        if (document != null) {
            log.error("FindDuplicityAndInvalid(): Document Duplicity {}", document);
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This document has already been registered");
        }
        if (user.getDocument().length() != 11 && user.getDocument().length() != 14) {
            //TODO: ADIÇÃO DE UMA API PARA VALIDAÇÃO DE CPF E CNPJ REAL
            log.error("FindDuplicityAndInvalid(): Invalid Document {}", user.getDocument());
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This document is not valid");
        }

        return user;
    }


    public boolean authenticate(String token) {
        //TODO: IMPLEMENTAR JWT PARA CRIPTOGRAFIA DO HEADER COM A AUTENTICAÇÃO
        log.info("authenticate() - START: autentication code is {}",token);
        if (token.equals(constants.autentication)) {
            log.error("authenticate(): Invalid Autentication");
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid Autentication");
        }
        return true;
    }

    public boolean Login(String identfier, String password){
        //TODO: IMPLEMENTAR JWT PARA CRIPTOGRAFIA DOS PATH COM LOGIN E SENHA DO USUARIO
    log.info("Login() - START: user document is {}",identfier);
    String login = UserRepository.Login(identfier, password);
     if (!login.equals(identfier)){
         log.error("authenticate(): Invalid Login");
         throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Login ou senha incorreto");
     }
     else {
         log.info("authenticate() - END:");
         return true;
     }
    }

}
