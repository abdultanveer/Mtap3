package com.abdul.mtap3.di;

import com.abdul.mtap3.DaggerActivity;
import com.abdul.mtap3.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {SharedPrefModule.class})
public interface MyComponent {
    void inject(DaggerActivity activity);
}