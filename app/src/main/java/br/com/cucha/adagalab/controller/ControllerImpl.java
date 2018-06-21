package br.com.cucha.adagalab.controller;

import android.util.Log;

import java.util.Calendar;

import javax.inject.Inject;

import br.com.cucha.adagalab.service.Service;

public class ControllerImpl implements Controller {

    String msg = "";

    @Inject
    public ControllerImpl() {
    }

    @Override
    public void doSomething() {

        if(msg.isEmpty()) {
            msg = Calendar.getInstance().getTime().toString();
        }

        Log.d(this.getClass().getName(), msg);
    }
}
