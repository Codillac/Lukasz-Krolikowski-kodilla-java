package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {
   public ArrayList<Integer> exterminate(ArrayList<Integer> numbers){
       Iterator<Integer> iterator = numbers.iterator();

       while(iterator.hasNext()){
           int currentNumber = iterator.next();
           if(currentNumber % 2 != 0){
               iterator.remove();
           }
       }

       return numbers;
    }
}
