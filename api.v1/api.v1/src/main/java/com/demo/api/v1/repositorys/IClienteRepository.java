package com.demo.api.v1.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.api.v1.entitys.ClienteEntity;

@Repository
public interface IClienteRepository extends JpaRepository<ClienteEntity,Integer>{

}
