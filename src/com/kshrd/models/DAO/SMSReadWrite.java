package com.kshrd.models.DAO;

import com.kshrd.models.DTO.Product;
import com.kshrd.views.SMSView;

import java.io.*;
import java.util.ArrayList;

public class SMSReadWrite {
    static  String path ="src\\com\\kshrd\\SMSFile\\SMSdata.txt";
    public static void readData(){

        FileInputStream fileInputStream  = null;
        try {
            fileInputStream = new FileInputStream(path);
            BufferedInputStream bufferedInputStream= new BufferedInputStream(fileInputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);


            long start = System.nanoTime();


                SMSView.products= (ArrayList<Product>)objectInputStream.readObject();



            System.out.println("Loading spend : " + (System.nanoTime()-start)/1000_000_000 + " sec ");


            objectInputStream.close();
            bufferedInputStream.close();
            fileInputStream.close();


        } catch (FileNotFoundException e) {
            System.out.println("Empty File!!");
        } catch (IOException e) {
            System.out.println("Empty Data!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public static void save(){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
            long s=System.nanoTime();
            objectOutputStream.writeObject(SMSView.products);



            System.out.println("Write : "+(System.nanoTime()-s)/1000_000_000 + " millisecond");

            objectOutputStream.close();
            bufferedOutputStream.close();
            fileOutputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void backUpRestore(String from,String to) {

        FileOutputStream fileOutputStream = null;
        try {

            FileInputStream fileInputStream = null;
            ArrayList<Product> products = null;


            fileInputStream = new FileInputStream(from);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);


            fileOutputStream = new FileOutputStream(to);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

            double start1 = System.nanoTime();

            objectOutputStream.writeObject((ArrayList<Product>) objectInputStream.readObject());


            System.out.println("=> Back up spent  : " + (System.nanoTime() - start1) / 1000000000 + " seconds");

            objectInputStream.close();
            objectOutputStream.close();
            bufferedInputStream.close();
            bufferedOutputStream.close();
            fileInputStream.close();
            fileOutputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
