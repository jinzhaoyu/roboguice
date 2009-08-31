package roboguice.activity;

import roboguice.inject.ActivityScope;

import com.google.inject.Inject;
import com.google.inject.Injector;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;


public abstract class GuiceActivity extends Activity {
    @Inject protected ActivityScope scope;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        getInjector().injectMembers(this);
    }


    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        getInjector().injectMembers(this);
    }



    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        getInjector().injectMembers(this);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        scope.enter(this);
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void onRestart() {
        scope.enter(this);
        super.onRestart();
    }

    @Override
    protected void onStart() {
        scope.enter(this);
        super.onStart();
    }

    @Override
    protected void onResume() {
        scope.enter(this);
        super.onResume();
    }





    @Override
    protected void onPause() {
        super.onPause();
        scope.exit(this);
    }



    public abstract Injector getInjector();

}
