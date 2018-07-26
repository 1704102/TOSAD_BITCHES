package com.example.jersey.domainTest.Composit;

import org.json.JSONObject;

import java.util.ArrayList;

public class OtherRule implements BusinessRuleComposite {

    @Override
    public String getRuleCode(String name) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public JSONObject getComposite() {
        return null;
    }

}
