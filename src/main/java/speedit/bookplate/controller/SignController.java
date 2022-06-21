package speedit.bookplate.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import speedit.bookplate.dto.result.SingleResult;
import speedit.bookplate.service.ResponseService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


//@Api(tags = {"1. Managing User Authentication "})
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
@Validated
public class SignController {

    @Autowired
    private ResponseService responseService;

    @GetMapping(value = "/hello")
    public SingleResult<String> join() {
        return responseService.getSingleResult("Hello");
    }
}
