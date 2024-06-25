package com.krk.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.krk.model.WhUserType;
public interface WhUserTypeRepositary extends JpaRepository<WhUserType,Integer> {
	@Query("SELECT COUNT(userEmail) FROM WhUserType WHERE userEmail=:email")
	Integer getWhUserEmailCount(String email);
    @Query("SELECT id,userCode FROM WhUserType WHERE userType=:userType")
	List<Object[]> getWhUserTypeByUserType(String userType);
}
