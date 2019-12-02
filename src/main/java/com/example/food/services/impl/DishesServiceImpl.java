package com.example.food.services.impl;

import com.example.food.dto.adminDto.DishesDto;
import com.example.food.dto.clientDto.DishMenuDto;
import com.example.food.models.Dishes;
import com.example.food.repositories.DishRepository;
import com.example.food.services.DishesService;
import com.example.food.services.ModelMapperService;
import com.example.food.services.helpers.DbFieldsParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DishesServiceImpl implements DishesService, ModelMapperService {
    private final Logger LOGGER = LoggerFactory.getLogger(DishesServiceImpl.class);
    @Autowired
    private DishRepository dishRepository;

    @Override
    public List getAllDishes(int page, int size) throws IllegalAccessException {
        Pageable pageable = PageRequest.of(page, size);
        Page<Map<String, Object>> pageDishes = dishRepository.findAllDishes(pageable);
        List<Map<String, Object>> list = pageDishes.getContent();
        List<DishesDto> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            DishesDto dishesDto = new DishesDto();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Field field = null;

                try {
                    if (DbFieldsParser.getDtoFieldFromDb(entry.getKey()) == null) {
                        field = DishesDto.class.
                                getDeclaredField(entry.getKey());
                    } else {
                        field = DishesDto.class.
                                getDeclaredField(DbFieldsParser.getDtoFieldFromDb(entry.getKey()));
                    }

                } catch (NoSuchFieldException e) {
                    continue;
                }
                field.setAccessible(true);
                field.set(dishesDto, entry.getValue());
            }
            resultList.add(dishesDto);

        }
        return resultList;
    }

    @Override
    public List findAllDishesMenu(int page, int size) throws IllegalAccessException {
        Pageable pageable = PageRequest.of(page, size);
        Page<Map<String, Object>> pageDishes = dishRepository.findAllDishesMenu(pageable);
        List<Map<String, Object>> list = pageDishes.getContent();
        List<DishMenuDto> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            DishMenuDto dishMenuDto = new DishMenuDto();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Field field = null;
                try {
                    if (DbFieldsParser.getDtoFieldFromDb(entry.getKey()) == null) {
                        field = DishMenuDto.class.
                                getDeclaredField(entry.getKey());
                    } else {
                        field = DishMenuDto.class.
                                getDeclaredField(DbFieldsParser.getDtoFieldFromDb(entry.getKey()));
                    }

                } catch (NoSuchFieldException e) {
                    continue;
                }
                field.setAccessible(true);
                field.set(dishMenuDto, entry.getValue());
            }
            resultList.add(dishMenuDto);

        }
        return resultList;
    }

    @Override
    public DishesDto createDish(DishesDto dishesDto) {
        Dishes dishes = new Dishes();
        map(dishesDto, dishes);
        map((dishRepository.save(dishes)), dishesDto);
        LOGGER.info("Dish create");
        return dishesDto;
    }

    @Override
    public DishesDto getDishById(Long id) {
        Optional<Dishes> optionalDishes = dishRepository.findById(id);
        if (optionalDishes.isPresent()) {
            DishesDto dishesDto = new DishesDto();
            map(optionalDishes.get(), dishesDto);
            return dishesDto;
        }
        return null;
    }

    @Override
    public List getAllDishesByCategory(String category) {
        List<DishMenuDto> dishMenuDtoList = new ArrayList<>();
        map(dishRepository.getByCategory(category), dishMenuDtoList);
        return dishMenuDtoList;
    }

    @Override
    public DishMenuDto ById(Long id) {
        DishMenuDto dishMenuDto = new DishMenuDto();
        map(dishRepository.ById(id), dishMenuDto);
        return dishMenuDto;
    }
}
