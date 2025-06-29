package com.cts.controller;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cts.service.MyService;

public class MyControllerTest {
	@Test
    public void testservice() {
		
        MyService mockApi = Mockito.mock(MyService.class);

        MyController controller = new MyController(mockApi);

        controller.fetchData();

        verify(mockApi).getData();
    }
}
