package com.liqiang.pumpkin.boot.dao;

import com.liqiang.pumpkin.boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
