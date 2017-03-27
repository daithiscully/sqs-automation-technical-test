package utilities;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class Retry implements TestRule {

    private int retryCount;

    public Retry(int retryCount) {
        this.retryCount = retryCount;
    }

    @Override
    public Statement apply(Statement statement, Description description) {
        return statement(statement, description);
    }

    private Statement statement(final Statement base, final Description description) {
        return new Statement() {
            @Override
        public void evaluate() throws Throwable {
                Throwable throwable = null;
                for (int i = 0; i < retryCount; i++) {
                    try {
                        base.evaluate();
                        return;
                    } catch (Throwable e) {
                        throwable = e;
                        System.out.println("Run " + (i + 1) + " failed!");
                    }
                }
                System.out.println("Giving up after " + retryCount + " attempts at the test");
                throw throwable;
            }
        };
    }
}
