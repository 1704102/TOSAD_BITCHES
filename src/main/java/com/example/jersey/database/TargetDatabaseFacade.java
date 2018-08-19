package com.example.jersey.database;
import org.json.JSONObject;
import com.example.jersey.database.Target.*;
import com.example.jersey.domainTest.Composit.util.*;

import java.util.ArrayList;

public class TargetDatabaseFacade {
    public ArrayList<ArrayList<String>> getForeignkeys(){
        ForeignkeyDao f = new ForeignkeyDao();
        ArrayList<ArrayList<String>> e= f.getforeignkeys();
        return e;
    }
    public void createInterEntityRule(String foreignkeys,String table1, String table2, String column1, String column2, String operator, String brname){
        InterentityruleDAO d =new InterentityruleDAO();
        d.makeRule(table1,table2,column1,column2,operator,brname,foreignkeys);


        }


    }
