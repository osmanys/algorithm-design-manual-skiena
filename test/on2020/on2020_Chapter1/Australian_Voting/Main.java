package on2020.on2020_Chapter1.Australian_Voting;

import net.egork.chelper.tester.NewTester;

import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!NewTester.test("test/on2020/on2020_Chapter1/Australian_Voting/Australian Voting.json"))
			Assert.fail();
	}
}
