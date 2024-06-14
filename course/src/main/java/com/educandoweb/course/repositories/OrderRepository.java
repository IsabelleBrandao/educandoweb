package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.OrderTable;

public interface OrderRepository extends JpaRepository<OrderTable, Long> {

}