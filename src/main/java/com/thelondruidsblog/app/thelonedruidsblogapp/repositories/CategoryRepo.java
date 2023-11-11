package com.thelondruidsblog.app.thelonedruidsblogapp.repositories;

import com.thelondruidsblog.app.thelonedruidsblogapp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
