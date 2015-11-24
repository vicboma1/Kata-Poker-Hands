package domian.result.impl;

import domian.RulesExecutable;
import domian.result.api.Resultable;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by vicboma on 24/11/15.
 */
public class ResultableImpl implements Resultable {

    private Map<RulesExecutable,List<Integer>> results;
    public static Resultable Create(){
        return new ResultableImpl(new Hashtable<RulesExecutable,List<Integer>>());
    }

    public ResultableImpl(Map<RulesExecutable,List<Integer>> map) {
        this.results = map;
    }

    @Override
    public Resultable put(RulesExecutable rule, List<Integer> ruleResult) {
        this.results.put(rule,ruleResult);
        return this;
    }

    @Override
    public List<Integer> get(RulesExecutable rule) {
        return this.results.get(rule);
    }

    @Override
    public Stream< Map.Entry<RulesExecutable, List<Integer>>> stream(){
        return this.results.entrySet().stream();
    }
}
