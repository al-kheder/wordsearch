package io.learnproject.wordsearchapi.controllers;


import io.learnproject.wordsearchapi.services.WordGridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController("/")
public class WordSearchController {

    @Autowired
    WordGridService wordGridService;

    @GetMapping("wordgrid")
    public String creatWordGrid(@RequestParam int gridSize,@RequestParam String wordList) {

        List<String > words= Arrays.asList(wordList.split("-"));
        char[][] grid = wordGridService.generateGrid(gridSize, words);
        String gridToString = "";

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                gridToString += grid[i][j] + " ";
            }
            gridToString += "\r\n";
        }
        return gridToString;
    }

}
