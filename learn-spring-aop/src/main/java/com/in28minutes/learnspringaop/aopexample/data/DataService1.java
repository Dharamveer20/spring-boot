package com.in28minutes.learnspringaop.aopexample.data;

import com.in28minutes.learnspringaop.aopexample.business.BusinessService1;
import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {
    //     Assume this function is retrieving data from database.
    public int [] retrieveData(){
        return new int[] {11,22,33,44,55};
    }


}
