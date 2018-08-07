package com.example.jersey.Exeptions;

public class TupleCompareValidateException extends Exception{
	public TupleCompareValidateException() {
		super("not a valid tuple compare rule");
	}
}
