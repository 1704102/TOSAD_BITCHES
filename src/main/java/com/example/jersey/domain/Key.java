package com.example.jersey.domain;


// what will it be. an apple, or a pear. Oh boy
public class Key<T> {
 
  final String identifier;
  final Class<T> type;
 
  public Key( String identifier, Class<T> type ) {
    this.identifier = identifier;
    this.type = type;
  }
}
