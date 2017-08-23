package emotionsTracker.asvfactory.com.model;

import java.io.Serializable;

/**
 * Created by nubor on 23/10/2016.
 */
public class EmotionTrackItemModel implements Serializable{

    private int eventId = 0;
    private float isLeftEyeOpenProbability = 0.0f;
    private float isRightEyeOpenProbability = 0.0f;
    private float isSmilingProbability = 0.0f;
    private long time = 0l;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public float getIsLeftEyeOpenProbability() {
        return isLeftEyeOpenProbability;
    }

    public void setIsLeftEyeOpenProbability(float isLeftEyeOpenProbability) {
        this.isLeftEyeOpenProbability = isLeftEyeOpenProbability;
    }

    public float getIsRightEyeOpenProbability() {
        return isRightEyeOpenProbability;
    }

    public void setIsRightEyeOpenProbability(float isRightEyeOpenProbability) {
        this.isRightEyeOpenProbability = isRightEyeOpenProbability;
    }

    public float getIsSmilingProbability() {
        return isSmilingProbability;
    }

    public void setIsSmilingProbability(float isSmilingProbability) {
        this.isSmilingProbability = isSmilingProbability;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
