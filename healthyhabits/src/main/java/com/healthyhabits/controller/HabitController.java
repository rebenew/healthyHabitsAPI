package com.healthyhabits.controller;

import com.healthyhabits.dto.HabitDTO;
import com.healthyhabits.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitController {
    @Autowired
    private HabitService habitService;

    @PostMapping
    public ResponseEntity<HabitDTO> createHabit(@RequestBody @Valid HabitDTO habitDTO) {
        HabitDTO created = habitService.createHabit(habitDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<HabitDTO>> getAllHabits() {
        return ResponseEntity.ok(habitService.getAllHabits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitDTO> getHabitById(@PathVariable Long id) {
        return habitService.getHabitById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HabitDTO> updateHabit(@PathVariable Long id, @RequestBody @Valid HabitDTO habitDTO) {
        return habitService.updateHabit(id, habitDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabit(@PathVariable Long id) {
        if (habitService.deleteHabit(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} 