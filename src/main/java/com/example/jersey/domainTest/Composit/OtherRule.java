package com.example.jersey.domainTest.Composit;

import java.util.ArrayList;

public class OtherRule implements BusinessRuleComposite {

    @Override
    public String getRuleCode(String name) {
        return null;
    }

    @Override
    public ArrayList<String> getRuleDefine() {
        return null;
    }

    @Override
    public ArrayList<String> getRuleAlter() {
        return null;
    }


    @Override
    public String getName() {
        return null;
    }

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
}
