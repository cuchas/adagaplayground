package br.com.cucha.adagalab.di;

import javax.inject.Singleton;

import br.com.cucha.adagalab.service.Service;
import br.com.cucha.adagalab.service.ServiceImpl;
import dagger.Module;
import dagger.Provides;

@Module(subcomponents = TransferComponent.class)
public class GlobalModule {
    @Provides
    @Singleton
    public Service provideService(ServiceImpl service) {
        return service;
    }
}
