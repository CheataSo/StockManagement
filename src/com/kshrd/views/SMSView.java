package com.kshrd.views;

import com.kshrd.Validate.Validate;
import com.kshrd.models.DAO.SMSAccess;
import com.kshrd.models.DAO.SMSReadWrite;
import com.kshrd.models.DTO.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class SMSView {
    LocalDate ld = LocalDate.now();
    static SMSAccess sa = new SMSAccess();
    public static ListProduct listProduct = new ListProduct();
    public static ArrayList<Product> products = new ArrayList<>();
    public void display() throws IOException {

        Font.group();


        Scanner sc = new Scanner(System.in);
            Pagination page = new Pagination();
            System.out.println("Please wait.....");
            SMSReadWrite.readData();
            File path = new File("src\\com\\kshrd\\SMSFile\\SetRow.txt");
            Scanner sr = new Scanner(path);
            page.setRow(sr.nextLine());
            Table tm = new Table(10, BorderStyle.CLASSIC_COMPATIBLE_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
            for (int i = 0; i <= 9; i++) {
                tm.setColumnWidth(i, 5, 10);
            }
            tm.addCell("*)Display");
            tm.addCell("W)rite");
            tm.addCell("R)ead");
            tm.addCell("U)pdate");
            tm.addCell("D)elete");
            tm.addCell("F)irst");
            tm.addCell("P)revious");
            tm.addCell("N)ext");
            tm.addCell("L)ast");
            tm.addCell("S)earch");
            tm.addCell("G)oto");
            tm.addCell("Se)t row");
            tm.addCell("Sa)ve");
            tm.addCell("Ba)ck Up");
            tm.addCell("Re)store");
            tm.addCell("He)lp");
            tm.addCell("E)xit");

            String SMSdata = "src\\com\\kshrd\\SMSFile\\SMSdata.txt";
            String SMSBackUp ="src\\com\\kshrd\\SMSFile\\SMSBackUp.txt";

            while (true) {
                System.out.println("                                      --Menu--");
                System.out.println(tm.render());
                System.out.print("Command --> ");
                String cmd = sc.next();

                switch (cmd) {
                    case "*":
                        System.out.println("                 --List Product--");
                        listProduct.display();
                        break;
                    case "w":
                        sa.write();
                        break;
                    case "r":
                        sa.read();
                        break;
                    case "u":
                        sa.updateAll(products);
                        break;
                    case "d":
                        sa.delete();
                        break;
                    case "f":
                        page.first();
                        break;
                    case "p":
                        page.previouse();
                        break;
                    case "n":
                        page.next();
                        break;
                    case "l":
                        page.last();

                        break;
                    case "s":
                        sa.search(products);
                        break;
                    case "g":
                        page.goTo();
                        break;
                    case "se":
                        String rows;
                        do {
                            System.out.print("How many row you want to set ? :");
                            rows = sc.next();
                        }while (!Validate.isRowValid(rows));
                        page.setRow(rows);
                        break;
                    case "sa":

                        SMSReadWrite.save();
                        System.out.println("save successful");
                        break;
                    case "ba":

                        SMSReadWrite.backUpRestore(SMSdata,SMSBackUp);
                        System.out.println("back up");
                        break;
                    case "re":
                        SMSReadWrite.backUpRestore(SMSBackUp,SMSdata);
                        System.out.println("Restore");
                        break;
                    case "h":
                        sa.help();

                        break;
                    case "#10m":
                        System.out.println("Please Wait Loading.....!");
                        long startTime =System.currentTimeMillis();
                        for(int i=1;i<=10000000;i++){
                            products.add(new Product(i,"coca",4.5,5,ld.toString()));
                        }
                        long endTime = System.currentTimeMillis();
                        long time = (endTime -startTime)/1000;

                        System.out.println("Calculate time : "+time+"sec");
                        System.out.println("Insert successful!!");
                        break;
                    case "#addr":
                        System.out.print("Input number of record : ");
                        int num = sc.nextInt();
                        for (int i=1;i<=num;i++){
                            products.add(new Product(i,"coca",4.5,5,ld.toString()));
                        }
                        System.out.println();
                        System.out.println("Insert successful!!");
                        break;
                    case  "#proId":
                        sa.read();
                        break;
                    case "e":
                        System.out.println("Do you want to save your work? [Y/y] / [N/y] : ");
                        String se = sc.next();
                        if(se.equalsIgnoreCase("y")){
                            SMSReadWrite.save();
                        }
                        else {
                            System.out.println("Good luck...");
                        }
                        System.out.println("++++++++++++++ GOOD BYE! ++++++++++++++");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Input Invalid");

                }
            }
        }
    }



