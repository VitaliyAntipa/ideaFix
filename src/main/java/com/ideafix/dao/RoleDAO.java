package com.ideafix.dao;

import com.ideafix.model.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleDAO extends JpaRepository<Role, Long>{

}
