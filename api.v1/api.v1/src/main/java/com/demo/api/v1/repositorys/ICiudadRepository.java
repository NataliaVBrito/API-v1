package com.demo.api.v1.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.api.v1.entitys.CiudadEntity;

@Repository
public interface ICiudadRepository extends JpaRepository<CiudadEntity,Integer>{

}
