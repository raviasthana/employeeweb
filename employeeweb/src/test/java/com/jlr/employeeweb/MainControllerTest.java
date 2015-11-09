package com.jlr.employeeweb;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.jlr.employeeweb.controller.MainController;

public class MainControllerTest {

	@Test
	public void testController() {
		MainController controller = new MainController();
		Model model = new ExtendedModelMap();
		Assert.assertEquals("home",controller.home(model));
		
		Object message = model.asMap().get("controllerMessage");
		Assert.assertEquals("This is the message from the controller!",message);
		
	}
}
