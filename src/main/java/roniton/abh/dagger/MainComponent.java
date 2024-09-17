package roniton.abh.dagger;

import dagger.BindsInstance;
import dagger.Component;
import roniton.abh.App;
import roniton.abh.Routes;

import javax.inject.Singleton;

@Component(modules = {
    MainModule.class,
    HttpModule.class,
})
@Singleton
public interface MainComponent {

    Routes routes();

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder mainApp(App app);

        MainComponent build();
    }
}
