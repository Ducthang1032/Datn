package com.poly.datn.be.repository;

import com.poly.datn.be.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "select * from tbl_user ua where ua.name = ?1", nativeQuery = true)
    UserEntity findUserByUserName(String username);

    List<UserEntity> findAllByEmailIgnoreCase(String email);

    List<UserEntity> findAllByPhone(String phone);

    UserEntity getUserEntityById(Long id);
}
