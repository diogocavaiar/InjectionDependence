package diogocavaiar.com.br.injectionofolddependence.di.component;

import dagger.Component;
import diogocavaiar.com.br.injectionofolddependence.di.PerActivity;
import diogocavaiar.com.br.injectionofolddependence.di.module.ActivityModule;
import diogocavaiar.com.br.injectionofolddependence.ui.main.MainActivity;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(final MainActivity mainActivity);

}
