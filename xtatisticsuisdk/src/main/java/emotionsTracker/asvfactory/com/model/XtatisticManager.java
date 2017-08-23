package emotionsTracker.asvfactory.com.model;

import static com.wagnerandade.coollection.Coollection.*;

import android.content.Context;
import android.view.View;

import java.util.List;

/**
 * Created by nubor on 23/10/2016.
 */
public class XtatisticManager {

    static Context mContext = null;

    public XtatisticManager(Context context) {
        this.mContext = context;
    }

    public void newEmotionTrackContainer(String fileName) {
        // EmotionTrackModel emotionTrackModel = EmotionTrackModel(fileName);
        //todo

    }

    public void addEmotionTrackItem(EmotionTrackItemModel item) {
        AppXtatics.mEmotionTrackModel.addEmotionTrack(item);
        DataUtil.saveEmotionTrack(mContext, AppXtatics.mEmotionTrackModel);
    }

    public EmotionTrackModel loadEmotionTrackContainer(String filename) {
        return null;
    }

    public List<View> getGraphicEmotionContainerByEventId(String filename) {
        return null;
    }

    public View getGraphicEmotionContainerByTime(String filename) {
        return null;
    }

    public static List<EmotionTrackItemModel> getEmotionTracksItemsFromEvent(List<EmotionTrackItemModel> lstInput,
                                                                      int EventId) {
        try {
            List<EmotionTrackItemModel> lstOutput = from(lstInput).where("getEventId", eq(EventId)).all();
            return lstOutput;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
