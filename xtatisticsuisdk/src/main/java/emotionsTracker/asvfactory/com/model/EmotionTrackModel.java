package emotionsTracker.asvfactory.com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nubor on 23/10/2016.
 */
public class EmotionTrackModel implements Serializable{
    private String filename="";
    private ArrayList<EmotionTrackModel> emotionTrackModelList
            = new ArrayList<EmotionTrackModel>();
}
