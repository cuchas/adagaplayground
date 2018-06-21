package br.com.cucha.adagalab.di;

import br.com.cucha.adagalab.ui.AnotherFragment;
import br.com.cucha.adagalab.ui.SomeFragment;
import dagger.Reusable;
import dagger.Subcomponent;

@TransferScope
@Subcomponent(modules = TransferModule.class)
public interface TransferComponent {
    void inject(SomeFragment someFragment);

    void inject(AnotherFragment anotherFragment);

    @Subcomponent.Builder
    interface Builder {
        //        Builder transferModule(TransferModule module);
        TransferComponent build();
    }
}
