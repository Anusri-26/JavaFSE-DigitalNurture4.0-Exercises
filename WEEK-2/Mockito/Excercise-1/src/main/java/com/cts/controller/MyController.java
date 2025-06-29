package com.cts.controller;

import com.cts.service.MyService;

public class MyController {
	private MyService myservice;

    public MyController(MyService myservice) {
        this.myservice = myservice;
    }

    public String fetchData() {
        return myservice.getData();
    }
}
