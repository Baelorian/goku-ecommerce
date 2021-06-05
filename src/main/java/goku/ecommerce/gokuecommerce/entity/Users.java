package goku.ecommerce.gokuecommerce.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
@Data
public class Users implements Serializable {

    @Id
    @Column(name ="id", unique =true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name ="name", nullable = false)
    public String name;

    @Column(name = "document", nullable = false)
    public String document;

    @Column(name ="phone", nullable = false)
    public String phone;

    @Column(name ="adress", nullable = false)
    public String adress;

    @Column(name ="cep", nullable = false)
    public String cep;
}
