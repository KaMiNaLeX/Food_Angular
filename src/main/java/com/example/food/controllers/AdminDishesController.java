package com.example.food.controllers;

import com.example.food.dto.adminDto.DishesDto;
import com.example.food.services.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/admin")
public class AdminDishesController {
    private static String UPLOADED_FOLDER = "D://DOWNLOAD//Универ//III курс//2 сем//ПСКП//курсач//food(2)//src//main//resources//static//images";
    @Autowired
    private DishesService dishesService;

    @PostMapping("/create")
    public DishesDto createDish(@RequestBody DishesDto dishesDto) {
        return dishesService.createDish(dishesDto);
    }


    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "createDishes";
    }
}
