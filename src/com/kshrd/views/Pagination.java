package com.kshrd.views;

import com.kshrd.Validate.Validate;

import java.util.Scanner;


public class Pagination {
    ListProduct lp = new ListProduct();
    Scanner sc = new Scanner(System.in);
    static int row=1 ;
    void first(){
        ListProduct.CurrentPage = 0;
        ListProduct.page = 1;
        lp.display();
    }

    void previouse(){
        ListProduct.page--;
        if(ListProduct.page<1){
            ListProduct.CurrentPage = SMSView.products.size()-ListProduct.numberOfRow;
            ListProduct.page = SMSView.products.size()/ListProduct.numberOfRow;
            lp.display();
        }else {
            ListProduct.CurrentPage-=ListProduct.numberOfRow;
            lp.display();
        }
    }

    void next(){
        try {
            ListProduct.CurrentPage += ListProduct.numberOfRow;
            if (ListProduct.CurrentPage >= SMSView.products.size()) {
                ListProduct.CurrentPage = 0;
                ListProduct.page = 1;
                lp.display();
            } else {
                ListProduct.page += 1;
                lp.display();
            }
        }catch (Exception e){
            last();
        }

    }

    void last(){
        if(SMSView.products.size()%ListProduct.numberOfRow==0) {
            ListProduct.CurrentPage = SMSView.products.size()-ListProduct.numberOfRow;
            ListProduct.page = SMSView.products.size() / ListProduct.numberOfRow;
            lp.display();
        }else {
            int numRow = ListProduct.numberOfRow;
            ListProduct.CurrentPage = SMSView.products.size() - (SMSView.products.size()%numRow);
            ListProduct.numberOfRow = SMSView.products.size() - ListProduct.CurrentPage;
            ListProduct.page = ListProduct.totalPage;
            lp.display();
            ListProduct.numberOfRow = row;

        }
    }
     void goTo(){
        String goTo;
        do {
            System.out.print("Wish page do you want to go : ");
            goTo = sc.next();
        }while (!Validate.isPageValid(goTo));
        int Goto = Integer.parseInt(goTo);
        ListProduct.CurrentPage = (ListProduct.numberOfRow * Goto)-ListProduct.numberOfRow;
        ListProduct.page = Goto;
        lp.display();

    }
    void setRow(){
        String rows;
        do {
            System.out.print("How many row you want to set ? :");
            rows = sc.next();
        }while (!Validate.isRowValid(rows));
            row = Integer.parseInt(rows);
            if(SMSView.products.size()%row==0) {
                ListProduct.numberOfRow = row;
            }else {
                ListProduct.numberOfRow = row;
                ListProduct.totalPage = (SMSView.products.size() / ListProduct.numberOfRow)+1;
            }
    }

}
