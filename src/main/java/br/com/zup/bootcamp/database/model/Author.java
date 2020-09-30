package br.com.zup.bootcamp.database.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "author")
public class Author implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 400)
    private String description;

    @CreationTimestamp
    @Column(nullable = false, name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar creationDate;

    public Author(){}

    public Author(@NotBlank String name, @NotBlank @Email String email, @NotBlank @Length(max = 400) String description){
        this.name = name;
        this.email = email;
        this.description = description;
    }
}
