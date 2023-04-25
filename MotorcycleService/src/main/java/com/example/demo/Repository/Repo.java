package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Pojo;

public interface Repo extends JpaRepository<Pojo, Integer>
{

}