package com.petukhovsky.jvaluer;

import java.io.InputStream;

/**
 * Created by Arthur on 12/20/2015.
 */
public class Estimator {

    Checker checker;

    public Estimator(Checker checker) {
        this.checker = checker;
    }

    public TestVerdict estimate(InputStream in, InputStream answer, InputStream out, RunInfo info) {
        if (info.getRunVerdict() != RunVerdict.SUCCESS)
            return new TestVerdict(null, info, info.getRunVerdict().getText());
        if (out == null)
            return new TestVerdict(null, info, "Presentation Error");
        CheckResult result = checker.check(in, answer, out);
        return new TestVerdict(result, info, result.isCorrect ? "Accepted" : "Wrong answer");
    }
}
