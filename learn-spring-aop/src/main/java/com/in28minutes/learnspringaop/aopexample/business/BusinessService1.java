package com.in28minutes.learnspringaop.aopexample.business;

import com.in28minutes.learnspringaop.aopexample.data.DataService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {
    DataService1 dataService1;
    Logger logger = LoggerFactory.getLogger(getClass());
    public BusinessService1(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }

    public int calculateMax(){
        int [] data = dataService1.retrieveData();

//        throw new RuntimeException("My error!");
        return Arrays.stream(data).max().orElse(0);
    }

    public int calculateMin() {
        int[] data = dataService1.retrieveData();
        return Arrays.stream(data).min().orElse(0);
    }
}
