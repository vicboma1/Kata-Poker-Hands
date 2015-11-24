package domian.result.api;

import domian.RulesExecutable;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by vicboma on 24/11/15.
 */
public interface Resultable {
    Resultable put(RulesExecutable rule, List<Integer> ruleResult);
    List<Integer> get(RulesExecutable rule);
    Stream<Map.Entry<RulesExecutable, List<Integer>>> stream();

}
