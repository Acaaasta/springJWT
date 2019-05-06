package com.nigma.springJWT.entity;

import com.nigma.springJWT.form.SignForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Set;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String hashPassword;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roles;

    public static User from(SignForm signForm){
        User user = new User();
        user.hashPassword = signForm.getPassword();
        user.username = signForm.getUsername();
        return user;
    }
}
