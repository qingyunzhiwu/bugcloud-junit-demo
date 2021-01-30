package com.bugcloud.junit.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bugcloud.junit.core.BugCloudRunner;
import com.bugcloud.junit.core.annotation.PushReport;

@RunWith(BugCloudRunner.class)
@PushReport(appKey = "6585667c-6f18-4c4f-b809-3be1de3b3ca7", appSecret = "fce8d3b5-6c9b-4a49-a50b-ad519630c898", pusher = "yu",handler="张三")
public class BugCloudRunnerTest {

	@Test
	public void testRuleTrue() {
		Assert.assertTrue(true);
	}

	@Test
	public void testRuleFalse() {
		Assert.assertTrue(false);
	}
}
