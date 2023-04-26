package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Details;

public interface Repo extends JpaRepository<Details,Integer>
{

}
