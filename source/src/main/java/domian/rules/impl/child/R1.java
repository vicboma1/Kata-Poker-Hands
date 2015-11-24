package domian.rules.impl.child;

import domian.RulesExecutable;
import domian.cards.api.Card;
import domian.helper.api.HelperCard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by vicboma on 24/11/15.
 */
public class R1 implements RulesExecutable {

    public static R1 Create(){
        return new R1();
    }

    public R1() {
    }

    @Override
    public List<Integer> execute(List<Card> black, List<Card> white, HelperCard helperCard) {
            final List<Integer> results = new ArrayList();
            IntStream.range(0,black.size())
                    .boxed()
                    .forEach(index -> {

                        final Card cardBlack = black.get(index);
                        final String strNumBlack = cardBlack.num();
                        Integer numBlack = helperCard.num(strNumBlack);

                        final Card cardWhite = white.get(index);
                        final String strNumWhite = cardWhite.num();
                        Integer numWhite = helperCard.num(strNumWhite);

                        // si es igual
                        if(numBlack == numWhite)
                            results.add(index , 0);
                        // si es menor
                        else if(numBlack >= numWhite)
                            results.add(index , 1);
                        //si es mayor
                        //if(numBlack < numWhite)
                        else results.add(index , -1);

                    });

            return results;
    }
}
