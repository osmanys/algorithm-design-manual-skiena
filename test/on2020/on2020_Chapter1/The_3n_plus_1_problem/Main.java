package on2020.on2020_Chapter1.The_3n_plus_1_problem;

import net.egork.chelper.tester.NewTester;

import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!NewTester.test("test/on2020/on2020_Chapter1/The_3n_plus_1_problem/The 3n plus 1 problem.json"))
			Assert.fail();
	}
}
