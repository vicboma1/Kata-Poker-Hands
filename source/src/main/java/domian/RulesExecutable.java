package domian;

import domian.cards.api.Card;
import domian.helper.api.HelperCard;

import java.util.List;

/**
 * Created by vicboma on 24/11/15.
 */
public interface RulesExecutable {
    List<Integer> execute(List<Card> black, List<Card> white, HelperCard helperCard) ;
}
