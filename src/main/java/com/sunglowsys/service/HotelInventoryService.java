package com.sunglowsys.service;

import com.sunglowsys.domain.HotelInventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface HotelInventoryService {

    HotelInventory save(HotelInventory hotelInventory);

    HotelInventory update(HotelInventory hotelInventory);

    Page<HotelInventory> findAll(Pageable pageable);

    Optional<HotelInventory> findById(Long id);

    List<HotelInventory> search(Integer searchText);

    void delete(Long id);
}
