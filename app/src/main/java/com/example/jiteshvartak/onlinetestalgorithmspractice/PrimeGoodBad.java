package com.example.jiteshvartak.onlinetestalgorithmspractice;/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;


class PrimeGoodBad {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
*/
        //Scanner
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        
        int pl[]= {2, 3,5,7,11,13,17,19 , 23};
        
        for (int x = 0; x < T; x++) {
           int H = s.nextInt();
           int M = s.nextInt();
           int S = s.nextInt();
           
           int good = 0;
           int bad = 0;
           
           for(int i = S ; i< 60;i++){
            
                boolean isDiv = false;
                for(int j=0;j<pl.length;j++){
                    
                    if(H % pl[j] ==0 && M % pl[j]==0 && i % pl[j] ==0 ){
                        bad ++;
                        isDiv = true;
                        break;
                    }
                    
                }
                if(!isDiv){
                    good++;
                }
                   
           }
           
       
     
           for(int i = M + 1;i<60;i++){
                   
                   for(int j = 0;j<60;j++){
                       boolean isDiv = false;
                       for(int k = 0;k<pl.length;k++){
                           if(H % pl[k] ==0 && i % pl[k]==0 && j % pl[k] ==0 ){
                               bad ++;
                               isDiv = true;
                               break;
                           }
                       }
                       if(!isDiv){
                           good++;
                       }
                   }
                   
               }
               
               
               for(int i = H + 1;i<24;i++){
                   for(int j=0;j<60;j++){
                       for(int k=0;k<60;k++){
                    	   boolean isDiv = false;
                           for(int l =0;l<pl.length;l++){
                        	   
                        	   if(i % pl[l] ==0 && j % pl[l]==0 && k % pl[l] ==0 ){
                                   bad ++;
                                   isDiv = true;
                                   break;
                               }
                           }
                           if(!isDiv){
                        	   good++;
                           }
                       }
                   }
               }
           
           print(bad +":"+good);
           
           
        }
 
    }
    
    
    
    static void print(String str){
        System.out.println(str);
    }
}
