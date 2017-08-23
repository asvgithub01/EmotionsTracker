package emotionsTracker.asvfactory.com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nubor on 23/10/2016.
 */
public class EmotionTrackModel implements Serializable {
    private String filename = "";
    private ArrayList<EmotionTrackItemModel> emotionTrackModelList
            = new ArrayList<EmotionTrackItemModel>();

    public ArrayList<EmotionTrackItemModel> getEmotionTrackModelList() {
        return emotionTrackModelList;
    }

    public void setEmotionTrackModelList(ArrayList<EmotionTrackItemModel> emotionTrackModelList) {
        this.emotionTrackModelList = emotionTrackModelList;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


    public void addEmotionTrack(EmotionTrackItemModel item) {
        this.emotionTrackModelList.add(item);
    }
}
