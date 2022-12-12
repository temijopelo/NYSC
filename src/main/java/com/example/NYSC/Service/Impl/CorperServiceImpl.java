package com.example.NYSC.Service.Impl;

import com.example.NYSC.Entity.Address;
import com.example.NYSC.Entity.CommunityDevelopmentService;
import com.example.NYSC.Entity.Corper;
import com.example.NYSC.Entity.SavinStudentRequest;
import com.example.NYSC.Repository.AddressRepository;
import com.example.NYSC.Repository.CommunityDevelopmentServiceRepository;
import com.example.NYSC.Repository.NyscRepository;
import com.example.NYSC.Service.CorperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CorperServiceImpl implements CorperService {

    @Autowired
    NyscRepository nyscRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public CorperServiceImpl(NyscRepository nyscRepository, AddressRepository addressRepository, CommunityDevelopmentServiceRepository communityDevelopmentServiceRepository) {
        this.nyscRepository = nyscRepository;
        this.addressRepository = addressRepository;
        this.communityDevelopmentServiceRepository = communityDevelopmentServiceRepository;
    }

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CommunityDevelopmentServiceRepository communityDevelopmentServiceRepository;
    @Override
    public Address saveCorperDetails(SavinStudentRequest request) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Corper corperData = new Corper();
        corperData.setFirstName(request.getFirstName());
        corperData.setLastName(request.getLastName());
        corperData.setEmail(request.getEmail());
        corperData.setPhoneNumber(request.getPhoneNumber());
        corperData.setPassword(passwordEncoder.encode(request.getPassword()));
        corperData.setCallUpNumber(request.getCallUpNumber());
        corperData.setNameOfPpa(request.getNameOfPpa());
        corperData.setStateCode(request.getStateCode());
        corperData.setServiceYear(request.getServiceYear());
        nyscRepository.save(corperData);


        Address corperAddress = new Address();
        corperAddress.setLgAddress(request.getLgAddress());
        corperAddress.setHomeAddress(request.getHomeAddress());
        corperAddress.setPpaAddress(request.getPpaAddress());
        corperAddress.setCorper(corperData);
        addressRepository.save(corperAddress);


        CommunityDevelopmentService cdsData = new CommunityDevelopmentService();
        cdsData.setCdsDay(request.getCdsDay());
        cdsData.setCdsGroup(request.getCdsGroup());
        cdsData.setCorpers(corperData);
        communityDevelopmentServiceRepository.save(cdsData);
        return corperAddress;

    }

    @Override
    public Address updateCorperDetails(SavinStudentRequest update) {


        Corper existingCorpers = new Corper();
        nyscRepository.findById(update.getId()).orElseThrow(() -> new RuntimeException (String.format("No Id is found")));
        existingCorpers.setFirstName(update.getFirstName() == null? existingCorpers.getFirstName() : update.getFirstName());
        existingCorpers.setLastName(update.getLastName() == null? existingCorpers.getLastName() : update.getLastName());
        existingCorpers.setEmail(update.getEmail() == null? existingCorpers.getEmail() : update.getEmail());
        existingCorpers.setPassword(update.getPassword() == null? existingCorpers.getPassword() : update.getPassword());
        existingCorpers.setPhoneNumber(update.getPhoneNumber() == null? existingCorpers.getPhoneNumber() : update.getPhoneNumber());
        existingCorpers.setCallUpNumber(update.getCallUpNumber() == null? existingCorpers.getCallUpNumber() : update.getCallUpNumber());
        existingCorpers.setNameOfPpa(update.getNameOfPpa() == null? existingCorpers.getNameOfPpa() : update.getNameOfPpa());
        existingCorpers.setStateCode(update.getStateCode() == null? existingCorpers.getStateCode() : update.getStateCode());
        existingCorpers.setServiceYear(update.getServiceYear() == null? existingCorpers.getServiceYear() : update.getNameOfPpa());
        nyscRepository.save(existingCorpers);
        Address existingAddress = new Address();
        existingAddress.setLgAddress(update.getLgAddress() == null? existingAddress.getLgAddress() : update.getLgAddress());
        existingAddress.setHomeAddress(update.getHomeAddress() == null? existingAddress.getHomeAddress() : update.getHomeAddress());
        existingAddress.setPpaAddress(update.getPpaAddress() == null? existingAddress.getPpaAddress() : update.getPpaAddress());
        addressRepository.save(existingAddress);
        CommunityDevelopmentService existingCds = new CommunityDevelopmentService();
        existingCds.setCdsGroup(update.getCdsGroup() == null? existingCds.getCdsGroup() : update.getCdsGroup());
        existingCds.setCdsDay(update.getCdsDay() == null? existingCds.getCdsDay() : update.getCdsDay());
        communityDevelopmentServiceRepository.save(existingCds);
        return existingAddress;


        
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Corper corper = nyscRepository.findByEmail(email);
            if (corper == null){
                throw new UsernameNotFoundException("Invalid Username or password.");
            }

        return new org.springframework.security.core.userdetails.User(
                corper.getEmail(), corper.getPassword(), new ArrayList<>());
    }

//    private Collection<? extends GrantedAuthority> getAuthorities(String role_user) {
//        return null;
//    }


    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
