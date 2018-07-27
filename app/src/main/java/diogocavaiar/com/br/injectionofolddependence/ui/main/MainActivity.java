package diogocavaiar.com.br.injectionofolddependence.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;

import javax.inject.Inject;

import diogocavaiar.com.br.injectionofolddependence.App;
import diogocavaiar.com.br.injectionofolddependence.R;
import diogocavaiar.com.br.injectionofolddependence.data.DataManager;
import diogocavaiar.com.br.injectionofolddependence.data.db.model.User;
import diogocavaiar.com.br.injectionofolddependence.di.component.ActivityComponent;
import diogocavaiar.com.br.injectionofolddependence.di.component.DaggerActivityComponent;
import diogocavaiar.com.br.injectionofolddependence.di.module.ActivityModule;

public class MainActivity extends AppCompatActivity {

    @Inject
    DataManager mDataManager;

    private ActivityComponent activityComponent;

    private AppCompatTextView mTvUserInfo;
    private AppCompatTextView mTvAccessToken;

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(App.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        mTvUserInfo = (AppCompatTextView) findViewById(R.id.tv_user_info);
        mTvAccessToken = (AppCompatTextView) findViewById(R.id.tv_access_token);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createUser();
        getUser();
        mDataManager.saveAccessToken("ASDR12443JFDJF43543J543H3K543");

        final String token = mDataManager.getAccessToken();
        if(token != null){
            mTvAccessToken.setText(token);
        }
    }

    private void createUser(){
        try {
            mDataManager.createUser(new User("Diogo Miron Cavaiar", "Rua Santa Helena, 1098"));
        }catch (Exception e){e.printStackTrace();}
    }

    private void getUser(){
        try {
            User user = mDataManager.getUser(1L);
            mTvUserInfo.setText(user.toString());
        }catch (Exception e){e.printStackTrace();}
    }
}
