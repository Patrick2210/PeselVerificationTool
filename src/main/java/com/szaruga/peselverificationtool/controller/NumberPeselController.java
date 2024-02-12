package com.szaruga.peselverificationtool.controller;


import com.szaruga.peselverificationtool.service.NumberPeselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NumberPeselController {

    private final NumberPeselService numberPeselService;

    @Autowired
    public NumberPeselController(NumberPeselService numberPeselService) {
        this.numberPeselService = numberPeselService;
    }

    /**
     * Verify pesel is valid
     *
     * @param numberPesel pesel number
     * @return response status 200 if peselNumber is valid, otherwise 400
     */
    @PostMapping("/verify-pesel")
    public ResponseEntity<Void> verifyPeselNumber(@RequestBody String numberPesel) {
        if (numberPeselService.verifyPesel(numberPesel)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}