package cn.jogger.tinkerdemo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

import timber.log.Timber;

/**
 * Created by jogger on 2018/11/5.
 */
@DefaultLifeCycle(
        application = "cn.jogger.tinkerdemo.MyApp",
        //这里填写包名和你想要生成的Application类名，tinker会自动生成该类
        flags = ShareConstants.TINKER_ENABLE_ALL)                                //tinkerFlags above
public class SampleApplicationLike extends DefaultApplicationLike {
    public SampleApplicationLike(Application application, int tinkerFlags, boolean
            tinkerLoadVerifyFlag, long applicationStartElapsedTime, long
                                         applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime,
                applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //....原有的Application的处理逻辑
        if (BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree());
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        //you must install multiDex whatever tinker is installed!
        MultiDex.install(base);
        TinkerInstaller.install(this);
    }
}