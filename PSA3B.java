/* Filename: PSA3B.java 
* Created by: Nick Lin, cs8a and Robert Tso, cs8a
* Date: 10/20/2016
*/ 
public class PSA3B
{
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args) 
    { 
       Picture copy= new Picture(FileChooser.pickAFile());
       int height=copy.getHeight();
       int width=copy.getWidth();
       copy.explore();
  
       
       /*subtractColor
        copy.subtractColor(50,150,200);
        copy.explore();
        */
      
       /*complement
       copy.complement(0,height*width/3);
       copy.explore();
        */
       
       /*grayscale
        copy.grayscale((height*width/3),(height*width*2/3));
        copy.explore();
        */
       
       /*myFilter
        copy.myFilter(height*width*2/3,height*width);
        copy.explore();
      */
       
       //tricolor
       /* copy.complement(0,height*width/3);
        copy.grayscale((height*width/3),(height*width*2/3));
        copy.myFilter(height*width*2/3,height*width);
        copy.explore();
       */
    } 
}

