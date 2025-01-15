package com.example.moattravel2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel2.entity.House;

//JpaRepository is an interface provided by Spring Data JPA
//JpaRepository<エンティティのクラス型、主キーのデータ型>
public interface HouseRepository extends JpaRepository<House, Integer> {
	//Page is a generic type provided by Spring Data
	//and it contains the House entity data
	public Page<House> findByNameLike(String keyword, Pageable pageable);
	public Page<House> findByNameLikeOrAddressLike(String nameKeyword, String addressKeyword, Pageable pageable);
	public Page<House> findByAddressLike(String area, Pageable pageable);
	public Page<House> findByPriceLessThanEqual(Integer price, Pageable pageable);
 
}
