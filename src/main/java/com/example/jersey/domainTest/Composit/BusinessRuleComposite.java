package com.example.jersey.domainTest.Composit;

import java.util.ArrayList;

public interface BusinessRuleComposite {

    String getRuleCode(String name);
    ArrayList<String> getRuleDefine();
    ArrayList<String> getRuleAlter();
    String getName();

}
