package com.equipment.equipment;

import java.util.Collection;

public interface EquipmentService<Equipment, Integer> {
    Collection<Equipment> findAll();
    Equipment add(Equipment entity);
}
