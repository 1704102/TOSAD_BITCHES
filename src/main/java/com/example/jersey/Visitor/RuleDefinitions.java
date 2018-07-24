package com.example.jersey.Visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

import com.example.jersey.domain.AttributeRule;
import com.example.jersey.domain.BusinessRuleComponent;
import com.example.jersey.domain.BusinessRuleComposite;
import com.example.jersey.domain.CompareRule;
import com.example.jersey.domain.ConstraintRule;
import com.example.jersey.domain.Key;
import com.example.jersey.domain.Operator;
import com.example.jersey.domain.TableComponent;

//
// This could also be stored in a database where it will be managed. Although the types are very loosely coupled
//

public class RuleDefinitions {
	
	//
	// NOTE: Consider using plsql instead
	//
	
	private final Map
		<Set<Key<? extends BusinessRuleComponent>>, HashMap<String, List<String>> > 
	ruleDefinitions = new HashMap
		< Set<Key<? extends BusinessRuleComponent>>, HashMap<String, List<String>> >();
	
	//
	// what a tedious way of building sql. Isn't there some framework with identical functionality
	// for this mess?
	//
	
	public RuleDefinitions() {
		
		//
		// TODO: the following below:
		// - let class operator determine the insertion
		// - couple table constraint?
		// - NOTE: does confirm() method check exactly how much of each type it has?
		//
		
		final BusinessRuleComponent tablecomp  = new TableComponent("animal");
		final BusinessRuleComponent column 	 = new AttributeRule("cat");
		final BusinessRuleComponent value 	 = new Operator("<");
		final BusinessRuleComponent compare = new CompareRule(5);
		final BusinessRuleComponent constraint = new ConstraintRule("gaurd tower");
		
		Set<Key<? extends BusinessRuleComponent>> base = new HashSet<Key<? extends BusinessRuleComponent>>();
		List<String> baseSql = new ArrayList<String>();
		base.add(tablecomp.getKey());
		baseSql.add(tablecomp.getSql());
		
		//
		// except for modifyRule
		//
		
		Set<Key<? extends BusinessRuleComponent>> base2 = base;
		List<String> base2Sql = baseSql;
		base2.add(column.getKey());
		base2Sql.add(column.getSql());
		
		//
		// only for comparing
		//
		
		Set<Key<? extends BusinessRuleComponent>> compareBase = base2;
		List<String> compareBaseSql = base2Sql;
		compareBase.add(compare.getKey());
		compareBaseSql.add(compare.getSql());
		
		HashMap<String, List<String>> acmpSqlMap = new HashMap<String, List<String>>();
		List<String> acmpSql = compareBaseSql;
		Set<Key<? extends BusinessRuleComponent>> acmp = compareBase;
		acmp.add(value.getKey());
		acmpSql.add(value.getSql());
		acmpSqlMap.put("businessRule", acmpSql);
		
		/*
		Set<Key<? extends BusinessRuleComponent>> tcmp = compareBase;
		tcmp.add(column.getKey());
		
		Set<Key<? extends BusinessRuleComponent>> iecp = compareBase;
		iecp.add(column.getKey());
		iecp.add(tablecomp.getKey());
		
		//
		// missing: primary- and foreign key
		//
		
		//  entity-, attribute- and tuple otherRule
		Set<Key<? extends BusinessRuleComponent>> other = base2;
		other.add(column.getKey());
		other.add(constraint.getKey());
		Map< String, List<String>> otherSql = new HashMap<>();
		
		//
		// ModifyOtherRule
		//
		
		Set<Key<? extends BusinessRuleComponent>> modi = base;
		modi.add(constraint.getKey());
		modi.add(tablecomp.getKey());
		Map< String, List<String>> modiSql = new HashMap<>();
		
		*/
		
		//
		// 6 of 10 can probably be defined
		// ruleDefinitions.put(tcmp, "sqlStatement");
		//
		
		ruleDefinitions.put(acmp, acmpSqlMap);
		System.out.println(this.ruleDefinitions.values());
		
		BusinessRuleComposite acmposite = new BusinessRuleComposite("ACMP");
		
		acmposite.put(column.getKey(), column);
		acmposite.put(value.getKey(), value);
		acmposite.put(compare.getKey(), compare);
		acmposite.put(tablecomp.getKey(), tablecomp);
		
		/*
		
		List<String> statements = this.getComponentStatements(acmposite);
		
		try {
			System.out.println("statements: " + statements.size());
		
		} catch(ExceptionInInitializerError e) {
			e.printStackTrace();
			throw new NullPointerException();
		
		}
		
		*/
		
		//Iterator<String> sqlwithcomp = this.getComponentStatements(acmposite).iterator(); 
		//  Exception in thread "main" java.lang.ExceptionInInitializerError
		// Caused by: java.lang.NullPointerException
		// at com.example.jersey.Visitor.RuleDefinitions.<init>(RuleDefinitions.java:98)
		// at StaticBRTest.<clinit>(StaticBRTest.java:18)
		
		/*
		Iterator<String> sqlwithkey = this.getComponentStatementsWithKey(acmp).iterator();
		
		
		while(sqlwithkey.hasNext()) { // code smell: only works well if both Iterators are the same
			//System.out.println("sqlwithcomp: " + sqlwithcomp.next());
			System.out.println("sqlwithkey: " + sqlwithkey.next());
		}
		*/
		// consider using a nested map for duplicates
//		ruleDefinitions.put(other, otherSql);
		// ruleDefinitions.put(modi, modiSql);
		
		// TODO: make this work at least when in runtime (dont forget type safety )
//		System.out.println("contains acmp" + getRuleMap(acmp));
//		System.out.println("contains acmp" + getRuleMap(tcmp));
//		System.out.println("contains acmp" + getRuleMap(other));
//		System.out.println("contains acmp" + getRuleMap(modi));
		
	}
	
	public String getBusinessRuleStatement(BusinessRuleComposite composite){
		Set<Key<? extends BusinessRuleComponent>> keys = composite.getHashedChildren().keySet();
		Map<String, List<String>> map = getRuleMap(keys);
		List<String> result = map.get("businessRule");
		
		return result.get(0);
	}
	
	public List<String> getComponentStatements(BusinessRuleComposite composite){
		Map<Key<? extends BusinessRuleComponent>, BusinessRuleComponent> children = composite.getHashedChildren();
		Set<Key<? extends BusinessRuleComponent>> entryCompare = children.keySet();
		Map<String, List<String>> map = getRuleMap(entryCompare);
		System.out.println(map);
		
		return map.get("componentStatements");
	}
	
	public List<String> getComponentStatementsWithKey(Set<Key<? extends BusinessRuleComponent>> componenthashset){
		Map<String, List<String>> map = getRuleMap(componenthashset);
		System.out.println(map);
		
		return map.get("componentStatements");
	}
	
	public Map<String, List<String>> getRuleMap(Set<Key<? extends BusinessRuleComponent>> entryCompare){
		Map<String, List<String>> result = null;
		if(entryCompare.isEmpty()) {
			throw new NullPointerException();
		}
		Iterator<Entry<Set<Key<? extends BusinessRuleComponent>>, HashMap<String, List<String>>>> entries = 
				this.ruleDefinitions.entrySet().iterator();
		int count = 0;
		
		while(entries.hasNext()) {
			Set<Key<? extends BusinessRuleComponent>> entrySource = entries.next().getKey();
			System.out.println(  );
			System.out.println( "hasnext: " + entries.hasNext() 
				+ "\t count: " + count + "\t match: " + 
				entryCompare.equals(entrySource) + "\t containsAll: " +
				entryCompare.containsAll(entrySource) + "\t contains: "
			);
			if( entrySource.containsAll(entryCompare) ) {
				System.out.println("comparison succeeded!");
				if(this.ruleDefinitions.get(entrySource) != null) {
					result = this.ruleDefinitions.get(entrySource);
					System.out.println(this.ruleDefinitions.get(entrySource)); /* returns 
					Map<String, List<String>> java.util.Map.get(Object key) */
					
					for (Map.Entry<String, List<String>> entry : result.entrySet()) {
						System.out.println("getRuleMap result entry: " + entry.getValue());
					}
			
					break;
				} else{
				System.out.println("Oh no, ruleDefinitions");
				throw new NoSuchElementException();
				}
			}
			count += 1;
		}
		
		return result;
	}

//		System.out.println(entries.next());
//		System.out.println(entries.next());
//		System.out.println(entries.next());
		// 3.1 find the right sequel statements
		// #.#.1 iterate over each
	
	// NOTE: maybe some setters for ruleDefinitions to use the database 
	// instead and making this class a domain class
	
	// TODO: dynamisch het type controleren (is possible now with type)
	
	/*
	public boolean validateRule( ) {
		// TODO hard coded check 
		// NOTE: how about defining all the rules from a centralized controller?
		List<Key<?>> acmp = new ArrayList<Key<?>>();
		Key<AttributeRule> key1 = new Key<>("column",AttributeRule.class);
		Key<AttributeRule> key2 = new Key<>("operator",AttributeRule.class);
		Key<Operator> key3 = new Key<>("compare",Operator.class);
		acmp.add(key1);
		acmp.add(key2);
		acmp.add(key3);
	
	
		// 3.1 check the components first
		Iterator<BusinessRuleComponent> compositecomps = composite.getChildren().iterator();
		// 3.2
		// - requirements
		// - number of classes need to match

		boolean match = false;
		int requirednumOfMatches = composite.getChildren().size();
		int measuredNumOfMatches = 0;
		while(compositecomps.hasNext()) {
			BusinessRuleComponent componentA = compositecomps.next();
			Class<?> classA = componentA.getClass();
			
			for(BusinessRuleComponent component : acmp) {
				// according to source you can 
				// get the type of Bluecar (subtype) from Car (supertype)
				  
				BusinessRuleComponent classB = composite.getSubtype(); // column? operator? comparison?
				
				if(classA instanceof classB) {
					measuredNumOfMatches += 1;
		
					break;
				}
			}
		}
		// composite doesn't match.
	
	return false;
	}// TODO: "with a strategy" in java
	*/
}
