package com.example.heart.dao;

import com.example.heart.pojo.TestOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestOrderDao extends JpaRepository<TestOrder, Integer> {
}
