package com.kshrd.models.DAO;

import com.kshrd.models.DTO.Product;
import com.kshrd.views.SMSView;
import com.kshrd.Validate.Validate;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class SMSAccess {

     LocalDate ld = LocalDate.now();
     Scanner sc = new Scanner(System.in);
     //Insert Object
        public void write(){
         String pri;
         String qty;
         Table tb = new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
         int id = SMSView.products.size() + 1;
         System.out.print("Product ID : "+ id);
         System.out.println();
         System.out.print("Product's name : ");
         String name = sc.next();
         do {
             System.out.print("Product's Price : ");
             pri = sc.next();
         }while (!Validate.isNumber(pri));
         double price = Double.parseDouble(pri);
         do {
             System.out.print("Product's Qty : ");
             qty = sc.next();
         }while (!Validate.isNumber(qty));
         int quantity = Integer.parseInt(qty);

         System.out.println();
         System.out.println("===Product Information===");
         Product pro = new Product(id,name,price,quantity,ld.toString());
         tb.addCell("ID");
         tb.addCell(pro.getId()+"");
         tb.addCell("Name");
         tb.addCell(pro.getName());
         tb.addCell("Unit Price");
         tb.addCell(pro.getUnitPrice()+"");
         tb.addCell("Qty");
         tb.addCell(pro.getQty()+"");
         tb.addCell("Imported Date");
         tb.addCell(pro.getImportDate()+"");
         System.out.println(tb.render());
         System.out.println();
         System.out.print("Are you sure for add this record ? [Y/y]/[N/n] :");
         String an = sc.next();
         if(an.equalsIgnoreCase("y")||an.equalsIgnoreCase("yes")){
             System.out.println();
             SMSView.products.add(pro);
             System.out.println("Successful inserted!!!");
         }else {
             System.out.println("Canceled !!!");
         }


     }
        public void read(){
            Table tr = new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
            String idr;
            do {
                System.out.print("Read by ID : ");
                idr = sc.next();
            }while (!Validate.isNumber(idr));
                int id = Integer.parseInt(idr);
            boolean isFound = false;
            for(Product product : SMSView.products)
            {
                if (id == product.getId()){
                    tr.addCell("ID");
                    tr.addCell(product.getId() + "");
                    tr.addCell("Name");
                    tr.addCell(product.getName() + "");
                    tr.addCell("Unit Price");
                    tr.addCell(product.getUnitPrice() + "$");
                    tr.addCell("Quantity");
                    tr.addCell(product.getQty() + "");
                    tr.addCell("Import Date");
                    tr.addCell(product.getImportDate() + "");
                    System.out.println(tr.render());
                    isFound = true;
                    break;
                }

            }
            if (isFound == false) {
                System.out.println("Invalid ID !!!");
            }
        }
        public void delete(){
         String idd;
            do {
                System.out.print("Please input ID of Product : ");
                idd = sc.next();
            }while (!Validate.isNumber(idd));
            int id = Integer.parseInt(idd);
            Table tl = new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
            boolean isFound = false;
            for(Product product : SMSView.products)
            {
                if (id == product.getId()){
                    tl.addCell("ID");
                    tl.addCell(product.getId() + "");
                    tl.addCell("Name");
                    tl.addCell(product.getName() + "");
                    tl.addCell("Unit Price");
                    tl.addCell(product.getUnitPrice() + "$");
                    tl.addCell("Quantity");
                    tl.addCell(product.getQty() + "");
                    tl.addCell("Import Date");
                    tl.addCell(product.getImportDate() + "");
                    System.out.println(tl.render());
                    isFound = true;
                    System.out.print("Are you sure want to delete this record ? [Y/y] or [N/n] :");
                    String an = sc.next();

                    if(an.equalsIgnoreCase("y")){
                            SMSView.products.remove(product);
                            System.out.println();
                            System.out.println("Delete Successful");
                            System.out.println();
                    }else {
                        System.out.println();
                        System.out.println("Delete Canceled!!!");
                    }
                    break;
                }

            }
            if (isFound == false) {
                System.out.println("Invalid ID !!!");
            }
        }
        public void updateAll(ArrayList<Product> productList) {
        Table th = new Table(4, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        Table tr = new Table(4, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        CellStyle center = new CellStyle(CellStyle.HorizontalAlign.center);
        int input;

        //Update Menu
        th.addCell("1.updateAll");
        th.addCell("2.name");
        th.addCell("3.price");
        th.addCell("4.Quantity");
        System.out.println(th.render());

        ArrayList<Product> proList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int ch=0;
        do{
            System.out.print("Input option from 1->4 : ");
            input= scan.nextInt();


            if (input == 1 || input == 2 || input == 3 || input == 4) {
                ch = 1;
                String Id;
                do {
                    System.out.print("Please Enter ID : ");
                    Id = scan.next();
                } while (!Validate.isNumber(Id));
                int id = Integer.parseInt(Id);
                boolean verify = false;
                for (Product pro : productList) {
                    if (id == pro.getId()) {
                        String price;
                        String qty;
                        switch (input) {

                            case 1:
                                System.out.print("Enter new name : ");
                                String newName = scan.next();
                                do {
                                    System.out.print("Enter new price : ");
                                    price = scan.next();
                                } while (!Validate.isNumber(price));
                                double newPrice = Double.parseDouble(price);
                                do {
                                    System.out.print("Enter new Quantity : ");
                                    qty = scan.next();
                                } while (!Validate.isNumber(qty));
                                int newQty = Integer.parseInt(qty);
                                pro.setName(newName);
                                pro.setUnitPrice(newPrice);
                                pro.setQty(newQty);
                                proList.add(pro);
                                break;

                            case 2:
                                System.out.print("Enter new name :");
                                String newName1 = scan.next();
                                pro.setName(newName1);
                                proList.add(pro);
                                break;

                            case 3:
                                do {
                                    System.out.print("Enter new price");
                                    price = scan.next();
                                } while (!Validate.isNumber(price));
                                double newPrice1 = Double.parseDouble(price);
                                pro.setUnitPrice(newPrice1);
                                proList.add(pro);

                                break;
                            case 4:
                                do {
                                    System.out.print("Enter new Quantity : ");
                                    qty = scan.next();
                                } while (!Validate.isNumber(qty));
                                int newQty1 = Integer.parseInt(qty);
                                pro.setQty(newQty1);
                                proList.add(pro);

                                break;
                            default:
                                System.err.println("Not found!");
                                break;
                        }
                    }
                }

            }
            else
                System.err.println("Incorrect number!");

        }while(ch==0);
        System.out.println("");
        System.out.println("Update successfully!");
        System.out.println("");
        for(int i=0; i<proList.size(); i++)
        {
            tr.addCell("ID");
            tr.addCell("Product Name");
            tr.addCell("Price");
            tr.addCell("Quantity");
            tr.addCell(proList.get(i).getId()+"");
            tr.addCell(proList.get(i).getName()+"");
            tr.addCell(proList.get(i).getUnitPrice()+"");
            tr.addCell(proList.get(i).getQty()+"");
            System.out.println(tr.render());
        }

    }
        public void help(){

        Table th = new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        CellStyle center = new CellStyle(CellStyle.HorizontalAlign.center);
        th.addCell(" Shortcut",center);
        th.addCell(" Description",center);
        th.addCell(" Press : *");
        th.addCell(" Display all records of product.");
        th.addCell(" Press : w");
        th.addCell(" Add new product.");
        th.addCell(" Press : w ");
        th.addCell(" -> #proname-unitprice-qty : Shortcut for add new product");
        th.addCell(" Press : r");
        th.addCell(" Read content of products.");
        th.addCell(" Press : #proId");
        th.addCell(" Shortcut for read products by Id.");
        th.addCell(" Press : u");
        th.addCell(" Update data.");
        th.addCell(" Press : d");
        th.addCell(" Delete record by ID.");
        th.addCell(" Press : f");
        th.addCell(" Display first page.");
        th.addCell(" Press : p");
        th.addCell(" Display previous page.");
        th.addCell(" Press : n");
        th.addCell(" Display next page.");
        th.addCell(" Press : l");
        th.addCell(" Display last page.");
        th.addCell(" Press : sa");
        th.addCell(" Save record to the file.");
        th.addCell(" Press : s");
        th.addCell(" Search record bu name of products.");
        th.addCell(" Press : se");
        th.addCell(" Set row to display.");
        th.addCell(" Press : ba");
        th.addCell(" Backup data.");
        th.addCell(" Press : re");
        th.addCell(" Restore data.");
        th.addCell(" Press : h");
        th.addCell(" Help page.");
        th.addCell(" Press : #10m");
        th.addCell(" Insert 10 million records");
        th.addCell(" Press : #addr");
        th.addCell(" Insert many records");
        System.out.println(th.render());
    }
        public void search(ArrayList<Product> productList) {
        Table tl = new Table(4, BorderStyle.UNICODE_BOX_DOUBLE_BORDER,ShownBorders.ALL);
        String nameToSearch="";
        System.out.print("Please Enter name you want to search :");
        Scanner sc = new Scanner(System.in);
        nameToSearch = sc.next();
        boolean isFound =false;
        ArrayList<Product> proList= new ArrayList<>();
//		this is how to search related letter in name

        for(Product pro : productList)
        {
            if(pro.getName() != null && pro.getName().contains(nameToSearch))
            {
                isFound = true;
                proList.add(pro);
            }

        }
        if(isFound == true)
        {
            tl.addCell("ID");
            tl.addCell("Product Name");
            tl.addCell("Price");
            tl.addCell("Quantity");
            for(int i=0; i<proList.size(); i++)
            {

                tl.addCell(proList.get(i).getId()+" ");
                tl.addCell(proList.get(i).getName()+" ");
                tl.addCell(proList.get(i).getQty()+" ");
                tl.addCell(proList.get(i).getUnitPrice()+" ");


            }
            System.out.print(tl.render());

            System.out.println();
        }
        else
        {
            System.err.println("Search not found !");
        }
    }




}



