package com.kshrd.Validate;

import com.kshrd.views.ListProduct;
import com.kshrd.views.SMSView;

public class Validate {
    public static boolean isNumber(String number){
        try{
            double num = Integer.valueOf(number);
            if(num>0){
                return true;
            } else {
                System.out.println("Number must be greater than 0");
                return false;
            }

        }catch (Exception e){
            System.out.println("Please input number...!");
            return false;
        }
    }
    public static  boolean isRowValid(String number){
        try {
            int row = Integer.parseInt(number);
            if(SMSView.products.size()==0){
                System.out.println("No record yet! Please input some records before set row.");
                return true;
            }
            if(row> SMSView.products.size()){
                System.out.println("Number of row can not be greater than Total Record "+SMSView.products.size());
                return false;
            }
            if(row<=0){
                System.out.println("Number of row mush > 0 ");
                return false;
            }

        }catch (Exception e){
            System.out.println("Input invalid");
            return false;
        }
        return true;
    }
    public static  boolean isPageValid(String number){
        try {
          int page = Integer.parseInt(number);
          if(page<1){
              System.out.println("Page sould be greater than 0");
              return false;
          }
          if(page> ListProduct.totalPage){
              System.out.println("There are only "+ListProduct.totalPage+ " pages");
              return false;
          }
        }catch (Exception e){
            System.out.println("Input invalid");
            return false;
        }
        return true;
    }
}
