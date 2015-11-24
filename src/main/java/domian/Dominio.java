package domian;

import domian.rules.api.Rules;
import domian.cards.api.Card;
import domian.helper.api.HelperCard;
import domian.result.api.Resultable;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by vicboma on 24/11/15.
 */
public class Dominio{
    private Rules rules;
    private List<Card> black;
    private List<Card> white;
    private HelperCard helperCard;
    private Resultable resultable;


    public Dominio(Resultable resultable, Rules rules, List<Card> black, List<Card> white, HelperCard helperCard) {
        this.rules = rules;
        this.black = black;
        this.white = white;
        this.helperCard = helperCard;
        this.resultable = resultable;
    }

    public Resultable execute(){
        final Stream<RulesExecutable> executableStream = this.rules.get();

        executableStream.forEach(rule -> {
            final List<Integer> results = rule.execute(this.black,this.white, this.helperCard);
            this.resultable.put(rule,results);
        });

        return this.resultable;
    }
}
