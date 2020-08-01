package ao.jfpack.patterns.adapter.structure;

import java.util.logging.Logger;

public class Mp4Player implements AdvancedMediaPlayer {

    Logger log = Logger.getLogger(Mp4Player.class.getName());

    @Override
    public void playVlc(String fileName) {
        throw new UnsupportedOperationException("Operation not supported over file:" + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        log.info("Playing file: " + fileName);
    }
}
