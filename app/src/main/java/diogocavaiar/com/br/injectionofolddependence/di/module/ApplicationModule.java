package diogocavaiar.com.br.injectionofolddependence.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import diogocavaiar.com.br.injectionofolddependence.di.ApplicationContext;
import diogocavaiar.com.br.injectionofolddependence.di.DatabaseInfo;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(final Application app) {
        mApplication = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }

}
