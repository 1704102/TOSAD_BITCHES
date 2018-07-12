package com.example.jersey.rest;

import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLWriter;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.ArrayList;

@Path("rules")
public class BusinessruleSet1{
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String businessRules(){
        //code to get backend for now unknown
        ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
        int x = 0;
        while (x <10){
            System.out.println(x);
            ArrayList<String> a = new ArrayList();
            a.add("s");
            a.add("a");
            a.add("d");
            a.add("b");
            a.add("e");
            array.add(a);
            x++;
        }
        String s = "";
        s = ""+ "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>Values</title>\n" +
                "\t<link rel=\"stylesheet\" href=\"/css/style.css\">\n" +
                "\t<script type=\"text/javascript\" src=\"js/BR.js\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id = \"sidebar\">\n" +
                "\tHyperlinks komen hier\n" +
                "</div>\n" +
                "<div id = \"topbar\"><div id= \"topbar2\">Select tabel</div></div>\n" +
                "<div id = \"mainBody\">\n" +
                "\n" +
                "\t<div id = \"postbody\">\n";

        s= s+ "<table id = \"tabstyle\"> <tr> <th id = \"wr20\">rule number</th ><th >table</th><th id = \"wr20\">Column</th><th id = \"wr20\">value</th><th id = \"wr20\">operator</th>";
            for(ArrayList<String> a : array){
                s = s+ "<tr>";
                for(String v : a){
                    s = s + "<td>" + v + "</td>";
                }
                s= s+ "</tr>";
            }
        s = s + "</table>";

         s = s + "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</body>\n" +
                "\n" +
                "</html>";


        return s;
    }


}
