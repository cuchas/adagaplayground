package br.com.cucha.adagalab.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

import br.com.cucha.adagalab.R;
import br.com.cucha.adagalab.service.Service;
import br.com.cucha.adagalab.di.DaggerGlobalComponent;
import br.com.cucha.adagalab.di.GlobalComponent;

public class MainActivity extends AppCompatActivity {

    private final static String SOME_FRAG = "SOME_FRAG", ANOTHER_FRAG = "ANOTHER_FRAG";

    @Inject
    Service service;

    private GlobalComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        component = DaggerGlobalComponent.create();

        component.inject(this);

        setup();
    }

    public GlobalComponent getComponent() {
        return component;
    }

    private void setup() {
        try {
            JSONObject json = service.getJson();
            Toast.makeText(this, json.getString("name"), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        findViewById(R.id.someButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag(SOME_FRAG);

                if(fragment != null && fragment.isAdded()) {
                    return;
                }

                if(fragment == null) {
                    fragment = new SomeFragment();
                }

                replace(fragment, SOME_FRAG);
            }
        });

        findViewById(R.id.anotherButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag(ANOTHER_FRAG);

                if(fragment != null && fragment.isAdded()) {
                    return;
                }

                if(fragment == null) {
                    fragment = new AnotherFragment();
                }

                replace(fragment, ANOTHER_FRAG);
            }
        });
    }

    void replace(Fragment fragment, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contentFrame, fragment, tag);
        transaction.commit();
    }
}
