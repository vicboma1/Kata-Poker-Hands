package domian.rules.impl;

import domian.RulesExecutable;
import domian.rules.api.Rules;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by vicboma on 24/11/15.
 */
public class RulesImpl implements Rules {
    private Set<RulesExecutable> setIterator;

    public static Rules Create(){
        return new RulesImpl(new HashSet());
    }

    public RulesImpl(Set<RulesExecutable> setIterator) {
        this.setIterator = setIterator;
    }

    @Override
    public RulesImpl add(RulesExecutable rule){
        this.setIterator.add(rule);
        return this;
    }

    @Override
    public Stream<RulesExecutable> get(){
        return this.setIterator.stream();
    }
}

