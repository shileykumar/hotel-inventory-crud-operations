package com.sunglowsys.repository;

import com.sunglowsys.domain.HotelInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface HotelInventoryRepository extends JpaRepository<HotelInventory, Long> {

    @Query("from HotelInventory hotInv where hotInv.totalInventory = searchText " +
            " or hotInv.hotelId = searchText or hotInv.roomTypeId = searchText ")
    List<HotelInventory> search(@RequestParam("searchText") Integer searchText);
}
