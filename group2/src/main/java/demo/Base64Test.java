package zPicture;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import sun.misc.BASE64Decoder;

import sun.misc.BASE64Encoder;

public class Base64Test

{

    public static void main(String[] args)

    {

        String strImg = GetImageStr();

        System.out.println(strImg);

        GenerateImage(strImg);

    }

    //  base64

    public static String GetImageStr()

    {//  Base64

        String imgFile = "group2/images/demo2.jpeg";//

        InputStream in = null;

        byte[] data = null;

        //

        try

        {

            in = new FileInputStream(imgFile);

            data = new byte[in.available()];

            in.read(data);

            in.close();

        } catch (IOException e)

        {

            e.printStackTrace();

        }

        //  Base64

        BASE64Encoder encoder = new BASE64Encoder();

        return encoder.encode(data);//  Base64

    }


    //base64

    public static boolean GenerateImage(String imgStr)

    {   //  Base64

        if (imgStr == null) //

            return false;

        BASE64Decoder decoder = new BASE64Decoder();

        try

        {

            //Base64

            byte[] b = decoder.decodeBuffer(imgStr);

            for (int i = 0; i < b.length; ++i)

            {

                if (b[i] < 0)

                {//

                    b[i] += 256;

                }

            }

            //  jpeg

            String imgFilePath = "group2/images/demo3.jpeg";//

            OutputStream out = new FileOutputStream(imgFilePath);

            out.write(b);

            out.flush();

            out.close();

            return true;

        } catch (Exception e)

        {

            return false;

        }

    }

}

  
