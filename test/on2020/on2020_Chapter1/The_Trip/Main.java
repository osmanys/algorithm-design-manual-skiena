package on2020.on2020_Chapter1.The_Trip;

import net.egork.chelper.tester.NewTester;

import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!NewTester.test("test/on2020/on2020_Chapter1/The_Trip/The Trip.json"))
			Assert.fail();
	}
}
