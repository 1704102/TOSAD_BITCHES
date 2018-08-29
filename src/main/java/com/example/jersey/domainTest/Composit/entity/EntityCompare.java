package com.example.jersey.domainTest.Composit.entity;

import com.example.jersey.domainTest.Composit.BusinessRuleComposite;
import org.json.JSONObject;

public class EntityCompare implements BusinessRuleComposite {
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
