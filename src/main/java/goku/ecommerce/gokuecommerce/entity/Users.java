package goku.ecommerce.gokuecommerce.entity;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="users")
@Data
public class Users implements Serializable {


    @Id
    @Column(name ="id", unique =true, nullable = false)
    public Integer id;

    @Column(name ="name", nullable = false)
    public String name;

    @Column(name ="phone", nullable = false)
    public String phone;

    @Column(name ="adress", nullable = false)
    public String adress;

    @Column(name ="cep", nullable = false)
    public String cep;
}
