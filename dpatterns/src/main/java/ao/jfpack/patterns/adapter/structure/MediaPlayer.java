package ao.jfpack.patterns.adapter.structure;

import ao.jfpack.patterns.adapter.structure.AudioType;

public interface MediaPlayer {
    void play(AudioType type, String filename);
}
