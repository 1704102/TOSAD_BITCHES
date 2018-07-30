import java.util.Set;

import com.example.jersey.Visitor.RuleDefinitions;
import com.example.jersey.domain.AttributeRule;
import com.example.jersey.domain.BusinessRuleComponent;
import com.example.jersey.domain.BusinessRuleComposite;
import com.example.jersey.domain.CompareRule;
import com.example.jersey.domain.Key;
import com.example.jersey.domain.Operator;
import com.example.jersey.domain.TableComponent;


public class StaticBRTest {
	private static final RuleDefinitions ruleDefinitions = new RuleDefinitions();
	
	public static void main(String args[]) {
		
		// attribute compare rule 1
		BusinessRuleComposite acmp = new BusinessRuleComposite("ACMP");
		
		AttributeRule attributeComponent = new AttributeRule("5");
		Operator operatorComponent = new Operator(">");
		CompareRule compareComponent = new CompareRule(4);
		TableComponent tableComponent = new TableComponent("car");
		
		Key<AttributeRule> key1 = new Key<>("attribute", AttributeRule.class);
		Key<Operator> key2 = new Key<>("operator", Operator.class);
		Key<CompareRule> key3 = new Key<>("compare", CompareRule.class);
		Key<TableComponent> key4 = new Key<>("table", TableComponent.class);
		
		acmp.put(key1, attributeComponent);
		acmp.put(key2, operatorComponent);
		acmp.put(key3, compareComponent);
		acmp.put(key4, tableComponent);
		
		// attribute compare rule2
		BusinessRuleComposite acmp2 = new BusinessRuleComposite("ACMP");
		
		AttributeRule attributeComponent2 = new AttributeRule("5");
		Operator operatorComponent2 = new Operator(">");
		CompareRule compareComponent2 = new CompareRule(4);

		acmp2.put(key1, attributeComponent2);
		acmp2.put(key2, operatorComponent2);
		acmp2.put(key3, compareComponent2);
		
		// lets see if comparing with test ##1 works
		System.out.println(acmp.confirm(acmp.getHashedChildren().keySet()) );
		System.out.println(acmp.confirm(acmp.getHashedChildren().keySet()) );
		
		// test ##2
		// lets see if key composition works
		// 1 retrieve key
		Set<Key<? extends BusinessRuleComponent>> acmpkey = acmp.getHashedChildren().keySet();
		// 2 get the type (at runtime generic types are implemented by erasure)
		/*
		Iterator<String> sqlwithcomp = ruleDefinitions.getComponentStatements(acmp).iterator(); 
		Iterator<String> sqlwithkey = ruleDefinitions.getComponentStatementsWithKey(acmpkey).iterator();
		while(sqlwithcomp.hasNext()) { // code smell: only works well if both Iterators are the same
			System.out.println("sqlwithcomp: " + sqlwithcomp.next());
			System.out.println("sqlwithkey: " + sqlwithkey.next());
		}
		//  Exception in thread "main" java.lang.ExceptionInInitializerError
		// Caused by: java.lang.NullPointerException
		// at com.example.jersey.Visitor.RuleDefinitions.<init>(RuleDefinitions.java:98)
		// at StaticBRTest.<clinit>(StaticBRTest.java:18)
		 *
		 */

		// Monday!!
//		Iterator<
//			Map.Entry<Set<Key<? extends BusinessRuleComponent>>, 
//			Map<String, List<String>>>> 
//		entries = 
//				sqlMap.iterator();
		
		
		// Lets see if creating and searching rule definitions ##3 works
		//System.out.println("what now?" + ruleDefinitions.getComponentStatements(acmp));
		//List<String> sql = ruleDefinitions.getComponentStatements(composite);
		
		/*
		// 3.1. retrieve the stored sequel statements from ...
		Iterator<String> sqlIter = ruleDefinitions.getComponentStatements(composite).iterator();
		// NOTE: only applicable for the following types:
		// > attribute- and tuple compareRule
		for (Map.Entry<Key<?>, Object> entry : composite.getHashedChildren().entrySet()){
			ruleDefinitions.getComponentStatements(composite).iterator()
			String componentStatement = sqlIter.next();
			BusinessRuleComponent component = (BusinessRuleComponent) entry.getValue();
			System.out.println(componentStatement);
			System.out.println("type: " + component.getComponentName());
			System.out.println("sqlStatement: " + componentStatement);
//			if ( !saveComponent(component,componentStatement) ) {
//				System.out.println("oops!: step 1 didn't go as expected");
//				break;
//			}
		};
		*/
	}
}
