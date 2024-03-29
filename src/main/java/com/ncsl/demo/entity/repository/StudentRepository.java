package com.ncsl.demo.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ncsl.demo.entity.*;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query("select s from Student s where s.name=?1")
	Student findByName(String name);
}
