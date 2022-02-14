package com.sunglowsys.rest;

import com.sunglowsys.domain.HotelInventory;
import com.sunglowsys.rest.util.BadRequestException;
import com.sunglowsys.service.HotelInventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HotelInventoryResource {

    private final Logger log = LoggerFactory.getLogger(HotelInventoryResource.class);

    private final HotelInventoryService hotelInventoryService;

    public HotelInventoryResource(HotelInventoryService hotelInventoryService) {
        this.hotelInventoryService = hotelInventoryService;
    }

    @PostMapping("/hotel-inventories")
    public ResponseEntity<HotelInventory> createHotelInventory(@RequestBody HotelInventory hotelInventory) throws URISyntaxException {
        log.debug("REST request to create HotelInventory : {}", hotelInventory);
        if (hotelInventory.getId() != null) {
            throw new BadRequestException("id should be null in create api call");
        }
        HotelInventory result = hotelInventoryService.save(hotelInventory);
        return ResponseEntity
                .created(new URI("/api/hotel-inventories" + result.getId()))
                .body(result);
    }

    @PutMapping("/hotel-inventories")
    public ResponseEntity<HotelInventory> updateHotelInventory(@RequestBody HotelInventory hotelInventory) {
        log.debug("REST request to update HotelInventory : {}", hotelInventory);
        if (hotelInventory.getId() == null) {
            throw new BadRequestException("id should not be null in update api call");
        }
        HotelInventory result = hotelInventoryService.save(hotelInventory);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/hotel-inventories")
    public ResponseEntity<List<HotelInventory>> getHotelInventories(Pageable pageable) {
        log.debug("REST request to get HotelInventories : {}", pageable.toString());
        Page<HotelInventory> result = hotelInventoryService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(result.getContent());
    }

    @GetMapping("/hotel-inventories/{id}")
    public ResponseEntity<HotelInventory> getHotelInventory(@PathVariable Long id) {
        log.debug("REST request to get HotelInventory : {}", id);
        Optional<HotelInventory> result = hotelInventoryService.findById(id);
        return ResponseEntity
                .ok()
                .body(result.get());
    }

    @GetMapping("/_search/hotel-inventories")
    public ResponseEntity<List<HotelInventory>> searchHotelInventories(@RequestParam Integer searchText) {
        log.debug("REST request to search HotelInventory : {}", searchText);
        List<HotelInventory> result = hotelInventoryService.search(searchText);
        return ResponseEntity
                .ok()
                .body(result);
    }
}
