package br.com.cucha.adagalab.service;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

public class ServiceImpl implements Service {

    @Inject
    public ServiceImpl() {}

    @Override
    public JSONObject getJson() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Eduardo");
        return jsonObject;
    }
}
