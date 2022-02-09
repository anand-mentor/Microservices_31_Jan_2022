package com.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.entity.one_to_one.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long>{
	
	@Query("SELECT emp FROM EmployeeEntity as emp WHERE emp.profile.experience >= :experience")
	List<EmployeeEntity> findByEmployeeByExperience(double experience);
}
