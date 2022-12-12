package com.example.NYSC.Controller;

import com.example.NYSC.Entity.Address;
import com.example.NYSC.Entity.Corper;
import com.example.NYSC.Entity.SavinStudentRequest;
import com.example.NYSC.Service.CorperService;
import com.example.NYSC.Service.NyscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.accept.ServletPathExtensionContentNegotiationStrategy;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v7")
public class NyscController {

    @Autowired
    private final NyscService nyscService;
    @Autowired
    CorperService corperService;

    public NyscController(NyscService nyscService) {

        this.nyscService = nyscService;
    }



    @PostMapping("/add/corpMembers")
    public ResponseEntity<?> addCorperDetails(@RequestBody SavinStudentRequest corper){
        Address request = corperService.saveCorperDetails(corper);
        HashMap<String, Object> response = new HashMap<>();


        if(request.getAddressId() > 0){
            response.put("DATA" , "Successful");
        }
        else {
            response.put("DATA" , "Unsuccessful");
        }

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCorperDetails(@RequestBody SavinStudentRequest corper){
        Address address = corperService.updateCorperDetails(corper);
        HashMap<String, Object> update = new HashMap<>();

        return ResponseEntity.ok(update);
    }

    @GetMapping("/corpers")
    public List<Corper> findAllCorper(){
        return nyscService.getDetails();
    }

    @GetMapping("/corper/{id}")
    public Corper findCorperById(@PathVariable Long id){

        return nyscService.getCorperById(id);
    }

    @GetMapping("/corper/callup/{callUpNumber}")
    public Corper findCorperByCallUpNumber(@PathVariable String callUpNumber){
        return nyscService.getCorperByCallUpNumber(callUpNumber);
    }

    @GetMapping("/corper/search")
    public List<Corper> findCorperName(@RequestParam("query") String query){
        return nyscService.findCorperName(query);
    }

    @GetMapping("/corper/years/{startingYear}/{endingYear}")
    public List <Corper> getServiceYearBetween(@PathVariable String startingYear, @PathVariable String endingYear){
        return nyscService.getServiceYearBetween(startingYear,endingYear);
    }

//    @PutMapping("/update")
//    public  Corper updateCorpMember(@RequestBody Corper corper){
//
//        return nyscService.updateCorper(corper);
//    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){

        return nyscService.deleteCorper(id);
    }

//    @PostMapping
//    public String loginDetails(@RequestBody String email, @RequestBody String password ) {
//        if (email == null) {
//
//        } else if (password == null){
//
//        } else {
//
//        }
//        return nyscService.
//    }


}
