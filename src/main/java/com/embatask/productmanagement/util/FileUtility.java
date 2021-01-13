package com.embatask.productmanagement.util;

public class FileUtility {
    public static String getFileExtension(String file){
        String extension = "";
        if(file!=null){
            int pos = file.lastIndexOf(".");
            if (pos>0){
                extension = file.substring(pos);
            }
        }
        return  extension;
    }
}
