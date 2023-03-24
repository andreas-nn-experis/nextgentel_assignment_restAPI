package com.equipment.equipment;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EquipmentServiceImpl {
    private final EquipmentRepository equipmentRepository;

    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }
}