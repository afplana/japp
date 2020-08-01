package ao.jfpack.patterns.adapter;

import ao.jfpack.patterns.adapter.structure.*;

public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer mediaPlayer;

    public MediaAdapter(AudioType audioType){
        switch (audioType) {
            case VLC:
                mediaPlayer = new VlcPlayer();
                break;
            case MP4:
                mediaPlayer = new Mp4Player();
                break;
        }
    }

    @Override
    public void play(AudioType audioType, String fileName) {
        switch (audioType) {
            case MP4:
                mediaPlayer.playMp4(fileName);
                break;
            case VLC:
                mediaPlayer.playVlc(fileName);
                break;
        }
    }
}
