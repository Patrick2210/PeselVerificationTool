package com.szaruga.peselverificationtool.controller;


import com.szaruga.peselverificationtool.service.NumberPeselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling PESEL verification requests.
 */
@RestController
@RequestMapping("/api")
public class NumberPeselController {

    private final NumberPeselService numberPeselService;

    /**
     * Constructs a new NumberPeselController with the provided NumberPeselService.
     *
     * @param numberPeselService The NumberPeselService to use for PESEL verification.
     */
    @Autowired
    public NumberPeselController(NumberPeselService numberPeselService) {
        this.numberPeselService = numberPeselService;
    }

    /**
     * Handles POST requests to verify the validity of a PESEL number.
     *
     * @param numberPesel The PESEL number to verify.
     * @return ResponseEntity with status 200 if the PESEL number is valid, otherwise 400.
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