package com;

import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File fRead=new File("score.txt");
        File fWrite=new File("scoreAnalysis.txt");
        try{
            Writer out=new FileWriter(fWrite,true);
            BufferedWriter bufferWrite=new BufferedWriter(out);
            Reader in=new FileReader(fRead);
            BufferedReader bufferRead=new BufferedReader(in);
            String str=null;
            while((str=bufferRead.readLine())!=null){
                double totalScore=Fenxi.getTotalScore(str);
                str=str+"总分："+totalScore;
                System.out.println(str);
                bufferWrite.write(str);
                bufferWrite.newLine();
            }
            bufferRead.close();
            bufferWrite.close();
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
    }
}




class Fenxi {

    public static double getTotalScore(String s) {
        Scanner scanner=new Scanner(s);
        scanner.useDelimiter("[^0123456789.]+");
        double totalScore=0;
        while(scanner.hasNext()){
            try{
                double score=scanner.nextDouble();
                totalScore=totalScore+score;
            }
            catch(InputMismatchException exp){
                String t=scanner.next();
            }
        }
        return totalScore;
    }

}


