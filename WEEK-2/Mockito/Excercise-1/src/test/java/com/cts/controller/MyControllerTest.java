package com.cts.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cts.service.MyService;

public class MyControllerTest {
	@Test
    public void testservice() {
		
        MyService mockApi = Mockito.mock(MyService.class);

        when(mockApi.getData()).thenReturn("Mock Data");

        MyController controller = new MyController(mockApi);

        String result = controller.fetchData();
        assertEquals("Mock Data", result);
    }
}
