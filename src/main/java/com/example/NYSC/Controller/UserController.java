package com.example.NYSC.Controller;

import com.example.NYSC.Entity.SavinStudentRequest;
import com.example.NYSC.Service.CorperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@Controller
public class UserController {


    @Autowired
    private CorperService corperService;

    @GetMapping("index")
    public String index(){

        return "/user/index";
    }


    @GetMapping("profile")
    public String profile(){

        return "/user/profile";
    }

    @GetMapping("login")
    public String login(){

        return "/user/login";
    }



    @GetMapping("registration")
    public String registration(){

        return "/registration";
    }


    @GetMapping("/save/registration")
    public String saveRegistration(@RequestParam("firstName") String firstName,
                                    @RequestParam("lastName") String lastName,
                                    @RequestParam("stateCode") String stateCode,
                                    @RequestParam("nameOfPpa") String nameOfPpa,
                                   @RequestParam("email") String email,
                                   @RequestParam("password") String password,
                                    @RequestParam("phoneNumber") String phoneNumber,
                                    @RequestParam("callUpNumber") String callUpNumber,
                                    @RequestParam("serviceYear") String serviceYear,
                                    @RequestParam("cdsGroup") String cdsGroup,
                                    @RequestParam("cdsDay") String cdsDay,
                                    @RequestParam("homeAddress") String homeAddress,
                                    @RequestParam("lgAddress") String lgAddress,
                                    @RequestParam("ppaAddress") String ppaAddress

                                    ){


        SavinStudentRequest savinStudentRequest = new SavinStudentRequest();
        savinStudentRequest.setFirstName(firstName);
        savinStudentRequest.setLastName(lastName);
        savinStudentRequest.setPhoneNumber(phoneNumber);
        savinStudentRequest.setCallUpNumber(callUpNumber);
        savinStudentRequest.setCdsDay(cdsDay);
        savinStudentRequest.setPassword(password);
        savinStudentRequest.setEmail(email);
        savinStudentRequest.setCdsGroup(cdsGroup);
        savinStudentRequest.setHomeAddress(homeAddress);
        savinStudentRequest.setLgAddress(lgAddress);
        savinStudentRequest.setPpaAddress(ppaAddress);
        savinStudentRequest.setServiceYear(serviceYear);
        savinStudentRequest.setStateCode(stateCode);
        savinStudentRequest.setNameOfPpa(nameOfPpa);
        corperService.saveCorperDetails(savinStudentRequest);

        return "/registration";
    }



}
