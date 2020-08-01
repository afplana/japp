package ao.jfpack.patterns.adapter.structure;

import java.util.logging.Logger;

public class VlcPlayer implements AdvancedMediaPlayer {

    Logger log = Logger.getLogger(VlcPlayer.class.getName());

    @Override
    public void playVlc(String fileName) {
        log.info("Playing file: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        throw new UnsupportedOperationException("Operation not supported over file:" + fileName);
    }
}
