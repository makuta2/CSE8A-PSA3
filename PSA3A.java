/* Filename: PSA3A.java 
* Created by: Nick Lin, cs8a and Robert Tso, cs8a
* Date: 10/20/2016
*/ 
public class PSA3A
{
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args) 
    { 
       Picture copy= new Picture(FileChooser.pickAFile());
       copy.explore();
       copy.subtractColor(55,0,23);
       copy.explore();
    } 
}

