package domian.rules.api;

import domian.RulesExecutable;
import domian.rules.impl.RulesImpl;

import java.util.stream.Stream;

/**
 * Created by vicboma on 24/11/15.
 */
public interface Rules {
    RulesImpl add(RulesExecutable rule);
    Stream<RulesExecutable> get();
}
