package group2.demo;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.util.Base64;
import java.util.Base64.*;

public class Base64Test {

    public static void main(String[] args) {

        String strImg = GetImageStr();
        System.out.println(strImg);
        GenerateImage(strImg);
    }

    //  base64

    public static String GetImageStr() {//  Base64

        String imgFile = "src/group2/images/demo2.jpeg";//

        InputStream in = null;
        byte[] data = null;

        //
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //  Base64
        return Base64.getEncoder().encodeToString(data);
    }


    //base64

    public static boolean GenerateImage(String imgStr) {   //  Base64

        if (imgStr == null) //
            return false;

        Decoder decoder = Base64.getDecoder();
        try {
            //Base64
            byte[] b = decoder.decode(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//
                    b[i] += 256;
                }
            }
            //  jpeg
            String imgFilePath = "src/group2/images/demo3.jpeg";//
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

  
