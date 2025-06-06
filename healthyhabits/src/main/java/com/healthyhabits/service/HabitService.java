package com.healthyhabits.service;

import com.healthyhabits.dto.HabitDTO;
import com.healthyhabits.model.Habit;
import com.healthyhabits.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HabitService {
    @Autowired
    private HabitRepository habitRepository;

    private HabitDTO toDTO(Habit habit) {
        return new HabitDTO(habit.getId(), habit.getNombre(), habit.getTipo(), habit.getFrecuencia(), habit.getObjetivo());
    }

    private Habit toEntity(HabitDTO dto) {
        Habit habit = new Habit(dto.getNombre(), dto.getTipo(), dto.getFrecuencia(), dto.getObjetivo());
        habit.setId(dto.getId());
        return habit;
    }

    public HabitDTO createHabit(HabitDTO habitDTO) {
        Habit habit = toEntity(habitDTO);
        Habit saved = habitRepository.save(habit);
        return toDTO(saved);
    }

    public List<HabitDTO> getAllHabits() {
        return habitRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<HabitDTO> getHabitById(Long id) {
        return habitRepository.findById(id).map(this::toDTO);
    }

    public Optional<HabitDTO> updateHabit(Long id, HabitDTO habitDTO) {
        return habitRepository.findById(id).map(habit -> {
            habit.setNombre(habitDTO.getNombre());
            habit.setTipo(habitDTO.getTipo());
            habit.setFrecuencia(habitDTO.getFrecuencia());
            habit.setObjetivo(habitDTO.getObjetivo());
            return toDTO(habitRepository.save(habit));
        });
    }

    public boolean deleteHabit(Long id) {
        if (habitRepository.existsById(id)) {
            habitRepository.deleteById(id);
            return true;
        }
        return false;
    }
} 