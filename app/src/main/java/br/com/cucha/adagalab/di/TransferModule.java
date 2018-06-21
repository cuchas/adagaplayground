package br.com.cucha.adagalab.di;

import br.com.cucha.adagalab.controller.Controller;
import br.com.cucha.adagalab.controller.ControllerImpl;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

@Module
public class TransferModule {
    @Provides
    @TransferScope
    Controller provideController(ControllerImpl controller) {
        return controller;
    }
}
