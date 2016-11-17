/* Filename: ExtraCreditPSA3.java 
* Created by: Nick Lin, cs8a and Robert Tso, cs8a
* Date: 10/20/2016
*/ 
public class ExtraCreditPSA3
{
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args) 
    { 
       Picture copy= new Picture(FileChooser.pickAFile());
       copy.explore();
       copy.extraCreditFilter(1.2);
       copy.explore();
    } 
}