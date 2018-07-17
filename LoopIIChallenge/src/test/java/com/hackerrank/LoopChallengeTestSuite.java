package com.hackerrank;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoopChallengeFeature.class,
        QueryShould.class,
        SerieShould.class,
        SerieOutputRepositoryShould.class,
        SerieOutputPrinterShould.class
})
public class LoopChallengeTestSuite {
}
