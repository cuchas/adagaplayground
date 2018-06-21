package br.com.cucha.adagalab.di;

import javax.inject.Singleton;

import br.com.cucha.adagalab.ui.MainActivity;
import dagger.Component;

@Singleton
@Component(modules = { GlobalModule.class })
public interface GlobalComponent {
    TransferComponent.Builder transfer();

//    TransferComponent transfer();

    void inject(MainActivity activity);
}
