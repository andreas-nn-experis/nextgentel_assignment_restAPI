package com.equipment.equipment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/equipment")
public class EquipmentController {
    private final EquipmentService<Equipment, Integer> equipmentService;

    public EquipmentController(EquipmentService<Equipment, Integer> equipmentService) {
        this.equipmentService = equipmentService;
    }

    // GET
    @Operation(summary = "Get all equipment")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Equipment.class)))
                    }
            )
    })
    @GetMapping
    public ResponseEntity<Collection<Equipment>> findAll() {
        return ResponseEntity.ok(equipmentService.findAll());
    }

    // POST
    @Operation(summary = "'Create' equipment, add to list")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Equipment.class)))
                    }
            )
    })
    @PostMapping
    public ResponseEntity<Equipment> add(Equipment newEquipment) {
        return new ResponseEntity<Equipment>(newEquipment, HttpStatus.CREATED);
    }
}
