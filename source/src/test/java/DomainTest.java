import domian.Dominio;
import domian.RulesExecutable;
import domian.cards.api.Card;
import domian.cards.impl.CardImpl;
import domian.helper.api.HelperCard;
import domian.helper.impl.HelperCardImpl;
import domian.result.api.Resultable;
import domian.result.impl.ResultableImpl;
import domian.rules.api.Rules;
import domian.rules.impl.RulesImpl;
import domian.rules.impl.child.R1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by vicboma on 24/11/15.
 */
public class DomainTest {

    private Dominio dominio;
    private Resultable resultable;
    private HelperCard helperCard;
    private Rules rules;
    private List<Card> black;
    private List<Card> white;

    private List<Card> createBlack() {
        return new ArrayList(Arrays.asList(
                CardImpl.Create("2","H"),
                CardImpl.Create("3","D"),
                CardImpl.Create("5","S"),
                CardImpl.Create("9","C"),
                CardImpl.Create("K","D")
        )
        );
    }

    private List<Card> createWhite() {
        return new ArrayList(){
            {
                add(CardImpl.Create("2","C"));
                add(CardImpl.Create("3","H"));
                add(CardImpl.Create("4","S"));
                add(CardImpl.Create("8","C"));
                add(CardImpl.Create("A","H"));

            }
        };
    }

    @Before
    public void setUp() throws Exception {
        black = createBlack();
        white = createWhite();
        rules = RulesImpl.Create();
        helperCard = HelperCardImpl.Create();
        resultable = ResultableImpl.Create();

        dominio = new Dominio(resultable,rules,black,white,helperCard);
    }

    private Map<RulesExecutable,List<Integer>> testCmpNunExpected(RulesExecutable rules) {
        return new Hashtable() {
            {
                put(rules, new ArrayList() {
                            {
                                add(new Integer(0));
                                add(new Integer(0));
                                add(new Integer(1));
                                add(new Integer(1));
                                add(new Integer(-1));
                            }
                        }
                );
            }
        };
    }

    @Test
    public void testCmpNum() throws Exception {
        final R1 rule = R1.Create();
        final Map<RulesExecutable,List<Integer>> cmpExpected = testCmpNunExpected(rule);

        rules.add(rule);
        final Resultable resultable = dominio.execute();

        resultable.stream().forEach(rulesListEntry -> {
            final RulesExecutable key = rulesListEntry.getKey();
            final List<Integer> resultRules = rulesListEntry.getValue();
            final List<Integer> resultExpecteds = cmpExpected.get(key);

            IntStream.range(0,resultExpecteds.size())
                    .boxed()
                    .forEach(index -> {
                        final Integer resultExpected = resultExpecteds.get(index);
                        final Integer resultRule = resultRules.get(index);
                        Assert.assertEquals(resultExpected,resultRule);
                    });
        });
    }

}
