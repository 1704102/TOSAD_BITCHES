import com.example.jersey.Visitor.DefineBusinessRule;
import com.example.jersey.domain.AttributeRule;
import com.example.jersey.domain.BusinessRuleComposite;
import com.example.jersey.domain.CompareRule;
import com.example.jersey.domain.Key;
import com.example.jersey.domain.Operator;


public class StaticBRTest {
	
	
	public static void main(String args[]) {
		
		BusinessRuleComposite acmp = new BusinessRuleComposite("ACMP");
		
		AttributeRule attributecomponent = new AttributeRule("5");
		Operator operatorcomponent = new Operator(">");
		CompareRule comparecomponent = new CompareRule("4");
		
		Key<AttributeRule> key1 = new Key<>("attribute",AttributeRule.class);
		Key<Operator> key2 = new Key<>("operator",Operator.class);
		Key<CompareRule> key3 = new Key<>("compare",CompareRule.class);
		
		acmp.put(key1, attributecomponent);
		acmp.put(key2, operatorcomponent);
		acmp.put(key3, comparecomponent);

		// Let's see if this is indeed 
		System.out.println(acmp.getSubtype(key1));// true
		System.out.println(acmp.getSubtype(key2) instanceof Operator); // true
		System.out.println(acmp.getSubtype(key3) instanceof CompareRule); // true
		
		
		DefineBusinessRule mediator = new DefineBusinessRule();
		
		
		// TODO: missing functionality
		// - a composite key
		// - instantiating Keys is duplicated code
		Key<AttributeRule> key4 = new Key<>("attribute",AttributeRule.class);
		Key<Operator> key5 = new Key<>("operator",Operator.class);
		Key<CompareRule> key6 = new Key<>("compare", CompareRule.class); // NOTE: key can be part of the key
		
		BusinessRuleComposite comp = mediator.defineAttributeCompareRule("numofseats","<","10");
		
		// Let's see if this is indeed 
		System.out.println(comp.getSubtype(key4));// null
		System.out.println(comp.getSubtype(key5) instanceof Operator); // false
		System.out.println(comp.getSubtype(key6) instanceof CompareRule); // false
		// true true true means it is a attribute compareRule
		
	}
}
