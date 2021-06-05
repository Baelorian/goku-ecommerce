package goku.ecommerce.gokuecommerce.repository;

import goku.ecommerce.gokuecommerce.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <Users, Integer> {

    @Query(value ="SELECT o FROM Users o WHERE o.cep = :cep")
    List<Users> findByCep(
            @Param(value ="cep") String cep);

    @Query(value ="SELECT o.document FROM Users o WHERE o.document = :document")
    String findDocumentDuplicity(
                    @Param(value = "document") String document);


}
