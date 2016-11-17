/* Filename: Picture.java 
* Created by: Nick Lin, cs8a and Robert Tso, cs8a
* Date: 10/20/2016
*/ 

/*--------PROGRAM DESCRIPTION----------
 subtractColor: makes a red, blue, green color darker. the first number, darkens the red, 
 the second darkens green, and the third darkens blue
 complement:creates the opposite color of a picture from a point to another point
 on a picture
 grayscale: creates black and white version of a picture from a point to another point
 on a picture
 myFilter: creates a greenish yellow version of the opposite color of a picture from a point
 to another point on a picture
 extraCreditFilter:makes picture more colorful
 */

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
   /*
    * Method Header goes here (see writeup)
    */
public void subtractColor(int rSub, int gSub, int bSub)
    {
      Pixel [] pixelArray=this.getPixels();
      int value=0;
      for (Pixel pixelObj:pixelArray)
           {
             value=pixelObj.getRed();
             value=value-rSub;
             pixelObj.setRed(value);
             value=pixelObj.getGreen();
             value=value-gSub;
             pixelObj.setGreen(value);
             value=pixelObj.getBlue();
             value=value-bSub;
             pixelObj.setBlue(value);
           }
    }
  

   /*
    * Method Header goes here (see writeup)
    */
public void complement(int start, int end)
    {
      Pixel [] pixelArray=this.getPixels();
      Pixel pixel=null;
      int value=0;
      int index=start;
      while (index<end)
           {
             pixel=pixelArray[index];
             value=pixel.getRed();
             value=255-value;
             pixel.setRed(value);
             value=pixel.getGreen();
             value=255-value;
             pixel.setGreen(value);
             value=pixel.getBlue();
             value=255-value;
             pixel.setBlue(value);
             index=index+1;
           }
    }

   /*
    * Method Header goes here (see writeup)
    */
public void grayscale(int start, int end)
    {
      Pixel [] pixelArray=this.getPixels();
      Pixel pixel=null;
      int value=0;
      int index=start;
      while (index<end)
           {
             pixel=pixelArray[index];
             //get grayscale value
             value=(pixel.getRed()+pixel.getBlue()+pixel.getGreen())/3;            
             pixel.setRed(value);
             pixel.setGreen(value);
             pixel.setBlue(value);
             index=index+1;
           }
    }
    

    /*
     * Method Header goes here (see writeup)
     * green scales the negative of a picture
     */
public void myFilter(int start, int end)
     {
      Pixel [] pixelArray=this.getPixels();
      Pixel pixel=null;
      int value=0;
      int index=start;
      while (index<end)
           {
             pixel=pixelArray[index];
             value=pixel.getRed();
             value=(int)((255-value)*(double)1.5);
             pixel.setRed(value);
             value=pixel.getGreen();
             value=(int)((255-value)*(double)1.7);
             pixel.setGreen(value);
             value=pixel.getBlue();
             value=(int)((255-value)*(double)0.5);
             pixel.setBlue(value);
             index=index+1;
           }
     }
     //extraCredit Filter
public void extraCreditFilter(double percent)
    {
      Pixel [] pixelArray=this.getPixels();
      int gl=0;
      //get average gray level value of entire picture
      for (Pixel pixelObj:pixelArray)
           {
             int r=pixelObj.getRed();
             int g=pixelObj.getGreen();
             int b=pixelObj.getBlue();
             gl=r+g+b+gl;
           }   
       gl=gl/(3*pixelArray.length);
      
      //values that are above the gray level are scaled up and  
      //values below the gray level are scaled down
      for (Pixel pixelObj:pixelArray)
           {
             int r=pixelObj.getRed();
             int g=pixelObj.getGreen();
             int b=pixelObj.getBlue();
             //red
             if(r>gl){
             r=(int)(r*percent);
             pixelObj.setRed(r);
             } 
             else {
             r=(int)(r/percent);
             pixelObj.setRed(r);
             }
             //green
             if(g>gl){
             g=(int)(g*percent);
             pixelObj.setGreen(g);
             } 
             else {
             g=(int)(g/percent);
             pixelObj.setGreen(g);
             //blue
             if(b>gl){
             b=(int)(b*percent);
             pixelObj.setBlue(b);
             } 
             else {
             b=(int)(b/percent);
             pixelObj.setBlue(b);
             }
             }
             
           }
    }
} // this } is the end of class Picture, put all new methods before this
 
