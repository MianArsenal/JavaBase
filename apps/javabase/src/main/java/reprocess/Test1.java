package reprocess;

import java.util.*;
import java.io.*;

public class Test1 {
    /****** START SET/GET METHOD, DO NOT MODIFY *****/
    protected String in_var = "";
    protected String out_var = "";
    public String getin_var() {
        return in_var;
    }
    public void setin_var(String val) {
        in_var = val;
    }
    public String getout_var() {
        return out_var;
    }
    public void setout_var(String val) {
        out_var = val;
    }
    /****** END SET/GET METHOD, DO NOT MODIFY *****/
    public Test1() {
    }
    public void invoke() throws Exception {
/* Available Variables: DO NOT MODIFY
	In  : String in_var
	Out : String out_var
* Available Variables: DO NOT MODIFY *****/

        out_var=in_var.replaceFirst(" xmlns.*\\.xsd\"", "");
        out_var=out_var.replaceFirst("xmlns=\"http://www.cargosmart.com/bl/coscon/image\"", "");

        if(out_var.indexOf("SenderID>IRIS4</")>-1 && out_var.indexOf("<ns2:BillOfLadingImage")>-1){
            out_var = out_var.replaceAll("<ns2:", "(((((");
            out_var = out_var.replaceAll("</ns2:", ")))))");
            out_var = out_var.replaceAll("<", "<ns2:");
            out_var = out_var.replaceAll("<ns2:/", "</ns2:");
            out_var = out_var.replaceAll("\\(\\(\\(\\(\\(", "<");
            out_var = out_var.replaceAll("\\)\\)\\)\\)\\)", "</");
            out_var = out_var.replaceFirst(" xmlns:ns2=\"http://www.cargosmart.com/bl/coscon/image\"", " xmlns:ns2=\"http://www.cargosmart.com/common\"");
            out_var = out_var.replaceFirst(" xmlns=\"http://www.cargosmart.com/common\"", " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
        }

    }
}
