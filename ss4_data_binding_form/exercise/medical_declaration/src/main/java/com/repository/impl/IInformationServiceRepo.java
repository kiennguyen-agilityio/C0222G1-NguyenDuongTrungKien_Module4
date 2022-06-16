package com.repository.impl;

import com.repository.InformationServiceRepo;

import java.util.ArrayList;
import java.util.List;

public class IInformationServiceRepo implements InformationServiceRepo {

    @Override
    public List<String> vehicle() {
        List<String> vehicle = new ArrayList<>() ;
        vehicle.add("tàu hỏa");
        vehicle.add("xe bus");
        vehicle.add("xe máy");
        vehicle.add("máy bay");
        return vehicle;
    }

    @Override
    public List<String> gender() {
        List<String> gender = new ArrayList<>() ;
        gender.add("nam");
        gender.add("nữ");
        gender.add("khác");
        return gender;
    }

    @Override
    public List<String> nationality() {
        List<String> nationality = new ArrayList<>();
        nationality.add("Việt Nam");
        nationality.add("Campuchia");
        nationality.add("Trung Quốc");
        nationality.add("Mỹ");
        return nationality;
    }

    @Override
    public List<String> year() {
        List<String> year=new ArrayList<>();
        year.add("2011");
        year.add("2012");
        year.add("2013");
        year.add("2014");
        return year;
    }
}
