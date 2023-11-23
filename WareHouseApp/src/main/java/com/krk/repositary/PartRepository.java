package com.krk.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krk.model.Part;

public interface PartRepository extends JpaRepository<Part, Integer>{

}
