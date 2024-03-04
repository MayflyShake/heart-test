package com.example.heart.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;

@Slf4j
@Getter
@Setter
@Entity
@Table(name = "test_order")
public class TestOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "params", columnDefinition = "text")
    private String params;

}
