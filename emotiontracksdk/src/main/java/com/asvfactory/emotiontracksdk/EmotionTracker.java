package com.asvfactory.emotiontracksdk;

import android.os.Bundle;
import android.os.Message;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.face.Face;

import emotionsTracker.asvfactory.com.model.EmotionTrackItemModel;
import emotionsTracker.asvfactory.com.model.XtatisticManager;

/**
 * Created by nubor on 23/10/2016.
 */
public class EmotionTracker extends Tracker<Face> {
    public EmotionTracker() {
        super();
    }

    @Override
    public void onNewItem(int i, Face face) {
        super.onNewItem(i, face);
    }

    @Override
    public void onUpdate(Detector.Detections<Face> detections, Face face) {
        super.onUpdate(detections, face);
//todo analizar que dan de si detections y face

        //send track log(falta el time)
        String textMessage = "Happyness" + face.getIsSmilingProbability() + " " + face.getIsRightEyeOpenProbability() + " " + face.getIsLeftEyeOpenProbability();
        Message msg = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("trackFace", textMessage);
        msg.setData(bundle);
        msg.what = 1;


        App.mHandler.sendMessage(msg);
//region xtatics
        EmotionTrackItemModel eT = new EmotionTrackItemModel();
        eT.setEventId(App.mEventId);
        eT.setIsLeftEyeOpenProbability(face.getIsLeftEyeOpenProbability());
        eT.setIsRightEyeOpenProbability(face.getIsRightEyeOpenProbability());
        eT.setIsSmilingProbability(face.getIsSmilingProbability());
        eT.setTime(System.currentTimeMillis());
        XtatisticManager.addEmotionTrackItem(eT);
        //endregion
//manda evento de sonrisa extreme
        if (face.getIsSmilingProbability() > 0.95) {
            Message msgPhoto = new Message();
            msgPhoto.what = 2;
            App.mHandler.sendMessage(msgPhoto);
        }


    }

    @Override
    public void onMissing(Detector.Detections<Face> detections) {
        super.onMissing(detections);
    }

    @Override
    public void onDone() {
        super.onDone();
    }
}
