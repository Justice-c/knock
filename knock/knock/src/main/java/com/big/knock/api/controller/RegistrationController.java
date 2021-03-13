package com.big.knock.api.controller;

import com.big.knock.domain.dal.entity.RegistrationRequest;
import com.big.knock.domain.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/knock/registration/")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping(path = "/adduser")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
