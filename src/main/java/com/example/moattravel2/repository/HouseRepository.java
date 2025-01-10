package com.example.moattravel2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel2.entity.House;

//JpaRepository<エンティティのクラス型、主キーのデータ型>
public interface HouseRepository extends JpaRepository<House, Integer> {
	

}
