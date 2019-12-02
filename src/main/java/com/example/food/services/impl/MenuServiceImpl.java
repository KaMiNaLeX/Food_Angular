package com.example.food.services.impl;

import com.example.food.dto.adminDto.MenuDto;
import com.example.food.models.Menu;
import com.example.food.repositories.MenuRepository;
import com.example.food.services.MenuService;
import com.example.food.services.ModelMapperService;
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

@Service
public class MenuServiceImpl implements MenuService, ModelMapperService {
    private final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public MenuDto createMenu(MenuDto menuDto) {
        Menu menu = new Menu();
        map(menuDto, menu);
        map(menuRepository.save(menu), menuDto);
        LOGGER.info("Menu create");
        return menuDto;
    }


    @Override
    public List getAllMenu(int page, int size) throws IllegalAccessException {
        Pageable pageable = PageRequest.of(page, size);
        Page<Map<String, Object>> pageDishes = menuRepository.findAllMenu(pageable);
        List<Map<String, Object>> list = pageDishes.getContent();
        List<MenuDto> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            MenuDto MenuDto = new MenuDto();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Field field = null;
                try {
                    field = MenuDto.class.getDeclaredField(entry.getKey());
                } catch (NoSuchFieldException e) {
                    LOGGER.error("getAllMenuDishesParam:NoSuchFieldException");
                }
                field.setAccessible(true);
                field.set(MenuDto, entry.getValue());
            }
            resultList.add(MenuDto);

        }
        return resultList;
    }
}
