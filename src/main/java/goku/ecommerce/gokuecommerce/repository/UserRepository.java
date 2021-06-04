package goku.ecommerce.gokuecommerce.repository;

import goku.ecommerce.gokuecommerce.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <Users,Integer> {

    @Query(value ="SELECT o FROM Users o WHERE o.cep = :cep")
    Page<Users> findByCep(
            @Param(value ="cep") String cep,
            Pageable pageable);



}
