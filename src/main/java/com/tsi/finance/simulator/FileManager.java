package com.tsi.finance.simulator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luanv
 */
public class FileManager {
    
    public static ArrayList<String> stringReader (String path){ 
        BufferedReader buffRead = null;
        try {
            buffRead = new BufferedReader(new FileReader(path));
            ArrayList<String> text = new ArrayList<>();
            String line = buffRead.readLine();
            while (line != null) {
                text.add(line);
                line = buffRead.readLine();
            }   buffRead.close();
            return text;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                buffRead.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
    
    public static void writer (String path, String text){ 
        BufferedWriter buffWrite = null; 
        try {
            buffWrite = new BufferedWriter(new FileWriter(path));
            buffWrite.append(text);
            buffWrite.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                buffWrite.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
    
    public static void writerAppend (String path, String text){ 
        BufferedWriter buffWrite = null; 
        try {
            buffWrite = new BufferedWriter(new FileWriter(path, true));
            buffWrite.append(text);
            buffWrite.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                buffWrite.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 

}