package br.com.cucha.adagalab.service;

import org.json.JSONException;
import org.json.JSONObject;

public interface Service {
    JSONObject getJson() throws JSONException;
}
