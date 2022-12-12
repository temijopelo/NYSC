package com.example.NYSC.Service;

import com.example.NYSC.Entity.Corper;
import com.example.NYSC.Repository.NyscRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NyscService {

    private final NyscRepository nyscRepository;

    public NyscService(NyscRepository nyscRepository) {
        this.nyscRepository = nyscRepository;
    }

    public String deleteCorper(Long id) {
        nyscRepository.deleteById(id);
        return "Corp member deleted " + id;
    }

    public Corper saveCorperDetails (Corper corper){
            return nyscRepository.save(corper);
    }

    public List<Corper> getDetails (){

        return nyscRepository.findAll();
    }

    public Corper getCorperById(Long id){

        return nyscRepository.findById(id).orElse(null);
    }

    public Corper getCorperByCallUpNumber(String callUpNumber){
        return nyscRepository.findByCallUpNumber(callUpNumber);
    }

    public List<Corper> findCorperName(String query) {
        return nyscRepository.searchCorpMembers(query);
    }

    public Corper updateCorper(Corper corper) {
        Corper existingCorper = nyscRepository.findById((Long) corper.getId()).orElseThrow(() -> new RuntimeException (String.format("No Id is found")));
        existingCorper.setFirstName(corper.getFirstName());
        existingCorper.setLastName(corper.getLastName());
        existingCorper.setStateCode(corper.getStateCode());
        existingCorper.setNameOfPpa(corper.getNameOfPpa());
        existingCorper.setCallUpNumber(corper.getCallUpNumber());
        existingCorper.setServiceYear((corper.getServiceYear()));
        existingCorper.setEmail((corper.getEmail()));
        existingCorper.setPhoneNumber((corper.getPhoneNumber()));
        return nyscRepository.save(existingCorper);
    }


    public List<Corper> getServiceYearBetween(String startingYear, String endingYear) {
        return nyscRepository.findByServiceYearBetween(startingYear,endingYear);
    }
}
