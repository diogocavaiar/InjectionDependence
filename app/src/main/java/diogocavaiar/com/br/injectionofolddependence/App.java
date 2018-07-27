package diogocavaiar.com.br.injectionofolddependence;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import diogocavaiar.com.br.injectionofolddependence.data.DataManager;
import diogocavaiar.com.br.injectionofolddependence.di.component.ApplicationComponent;
import diogocavaiar.com.br.injectionofolddependence.di.component.DaggerApplicationComponent;
import diogocavaiar.com.br.injectionofolddependence.di.module.ApplicationModule;


public class App extends Application {

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }

}
