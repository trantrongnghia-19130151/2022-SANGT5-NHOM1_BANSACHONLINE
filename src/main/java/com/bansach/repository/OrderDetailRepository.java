package com.bansach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bansach.entities.OrderDetail;
@Repository
public interface OrderDetailRepository  extends JpaRepository<OrderDetail, Integer>{

}
