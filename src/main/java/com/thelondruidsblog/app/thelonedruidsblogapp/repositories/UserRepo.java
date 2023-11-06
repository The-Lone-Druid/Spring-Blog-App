package com.thelondruidsblog.app.thelonedruidsblogapp.repositories;

import com.thelondruidsblog.app.thelonedruidsblogapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> { }
