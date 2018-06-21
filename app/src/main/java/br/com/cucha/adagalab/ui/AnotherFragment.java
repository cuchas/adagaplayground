package br.com.cucha.adagalab.ui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import br.com.cucha.adagalab.controller.Controller;
import br.com.cucha.adagalab.R;
import br.com.cucha.adagalab.di.TransferModule;
import br.com.cucha.adagalab.service.Service;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnotherFragment extends Fragment {

    @Inject
    Controller controller;

    @Inject
    Service service;

    public AnotherFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivity activity = (MainActivity) getActivity();

        activity.getComponent()
                .transfer()
                .build()
                .inject(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_another, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        controller.doSomething();
    }
}
