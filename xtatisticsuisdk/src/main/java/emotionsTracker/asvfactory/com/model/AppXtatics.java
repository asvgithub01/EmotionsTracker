package emotionsTracker.asvfactory.com.model;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;

/**
 * Created by nubor on 15/11/2016.
 */
public class AppXtatics extends Application {

    static final int EVENT_TRACK = 101;
    static XtatisticManager mXtatisticManager;
    static EmotionTrackModel mEmotionTrackModel = new EmotionTrackModel();

    public static XtatisticManager init(Context context, String filename) {
        mEmotionTrackModel = new EmotionTrackModel();
        mEmotionTrackModel.setFilename(filename);
        mEmotionTrackModel.setEmotionTrackModelList(new ArrayList<EmotionTrackItemModel>());

        mXtatisticManager = new XtatisticManager(context);
        mXtatisticManager.newEmotionTrackContainer(filename);

        return mXtatisticManager;
    }


    @Override
    public void onCreate() {
        super.onCreate();

    }
}
