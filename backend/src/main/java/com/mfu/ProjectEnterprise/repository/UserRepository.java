package com.mfu.ProjectEnterprise.repository;

import com.mfu.ProjectEnterprise.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findById(long id);
}