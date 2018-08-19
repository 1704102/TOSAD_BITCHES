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
}
