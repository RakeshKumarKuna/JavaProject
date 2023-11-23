package com.krk.repositary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.krk.model.WhUserType;
public interface WhUserTypeRepositary extends JpaRepository<WhUserType,Integer> {
	@Query("SELECT COUNT(userEmail) FROM WhUserType WHERE userEmail=:email")
	Integer getWhUserEmailCount(String email);

}
