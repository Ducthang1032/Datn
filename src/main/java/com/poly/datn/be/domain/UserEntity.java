package com.poly.datn.be.domain;

import com.poly.datn.be.dto.UserRegisterDTO;
import com.poly.datn.be.enums.RoleAccount;
import com.poly.datn.be.enums.UserStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Table(name = "tbl_user")
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email = StringUtils.EMPTY; //Default is empty

    @Column(name = "phone")
    private String phone = StringUtils.EMPTY; //Default is empty

    @Column(name = "address")
    private String address = StringUtils.EMPTY; //Default is empty

    @Column(name = "password")
    private String password = StringUtils.EMPTY; //Default is empty

    @Column(name = "role")
    private String role;

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "status")
    private String status = UserStatus.ACTIVE.getValue(); //Default is active

    public UserEntity(UserRegisterDTO registerDTO) {
        this.name = StringUtils.trimToEmpty(registerDTO.getName());
        this.email = StringUtils.lowerCase(registerDTO.getEmail());
        this.phone = registerDTO.getPhone();
        this.password = registerDTO.getPassword();
        this.role = RoleAccount.USER.getName();
    }
}
