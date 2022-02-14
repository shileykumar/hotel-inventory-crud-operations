package com.sunglowsys.service;

import com.sunglowsys.domain.HotelInventory;
import com.sunglowsys.repository.HotelInventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HotelInventoryServiceImpl implements HotelInventoryService {

    private final Logger log = LoggerFactory.getLogger(HotelInventoryServiceImpl.class);

    private final HotelInventoryRepository hotelInventoryRepository;

    public HotelInventoryServiceImpl(HotelInventoryRepository hotelInventoryRepository) {
        this.hotelInventoryRepository = hotelInventoryRepository;
    }

    @Override
    public HotelInventory save(HotelInventory hotelInventory) {
        log.debug("request to save HotelInventory : {}", hotelInventory);
        return hotelInventoryRepository.save(hotelInventory);
    }

    @Override
    public HotelInventory update(HotelInventory hotelInventory) {
        log.debug("request to save HotelInventory : {}", hotelInventory);
        return hotelInventoryRepository.save(hotelInventory);
    }

    @Override
    public Page<HotelInventory> findAll(Pageable pageable) {
        log.debug("request to save HotelInventory : {}", pageable.toString());
        return hotelInventoryRepository.findAll(pageable);
    }

    @Override
    public Optional<HotelInventory> findById(Long id) {
        log.debug("request to save HotelInventory : {}", id);
        return hotelInventoryRepository.findById(id);
    }

    @Override
    public List<HotelInventory> search(Integer searchText) {
        log.debug("request to save HotelInventory : {}", searchText);
        return hotelInventoryRepository.search(searchText);
    }

    @Override
    public void delete(Long id) {
        log.debug("request to save HotelInventory : {}", id);
        hotelInventoryRepository.deleteById(id);
    }
}
