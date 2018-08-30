package com.example.jersey.domainTest.Composit;

import org.json.JSONObject;

import java.util.ArrayList;

public interface BusinessRuleComposite {
    String getName();
    boolean validate();
    JSONObject getComposite();

}
