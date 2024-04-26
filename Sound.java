import greenfoot.*;
import java.util.HashMap;
public class Sound  
{
    private GreenfootSound[] sounds;
    private int index;
    private int volume;
    /**
     * Creates one sound.
     */
    public Sound(String filename) {
        this(filename, 1, 100);
    }
    /**
     * Creates a Sound with normal volume.
     * @param filename The filename for your sound file.
     * @param n The number of instances to create.
     */
    public Sound(String filename, int n) {
        this(filename, n, 100);
    }
    /**
     * Creates a Sound with a volume of your choice.
     * @param filename The filename of your sound file.
     * @param n The number of instances to create.
     * @param volume The volume to set the sounds to.l
     */
    public Sound(String filename, int n, int volume) {
        sounds = new GreenfootSound[n];
        for (int i = 0; i < sounds.length; i++) {
            sounds[i] = new GreenfootSound(filename);
        }
        index = 0;
        this.volume = volume;
    }
    /**
     * Plays sound 
     */
    public void play() {
        play(volume);
    }
    /**
     * Plays the Sound at the given volume.
     * @param volume The volume to play the sound at.
     */
    public void play(int volume) {
        sounds[index].setVolume(volume);
        sounds[index].play();
        getNextIndex();
    }
    /**
     * Stops all instances of the GreenfootSound.
     */
    public void stop() {
        for (GreenfootSound sound : sounds) sound.stop();
    }
    /**
     * Plays the sound in a loop. Will only play the 0th sound.
     * Only meant to be used for SuperSounds with only one instance, otherwise you're doing 
     * something weird. Don't do that.
     */
    public void playLoop() {
        sounds[0].setVolume(volume);
        sounds[0].playLoop();
    }
    /**
     * Get the next index for the next GreenfootSound to play.
     */
    private void getNextIndex() {
        index++;
        if (index >= sounds.length) { // Increment and compare with length of sounds array
            index = 0; // Would be out of bounds, reset to 0
        }
    }
    /**
     * Returns the volume
     */
    public int getVolume() {
        return volume;
    }
    /**
     *  Returns if sound is playing
     */
    public boolean isPlaying() {
        for (GreenfootSound sound: sounds) {
            if (sound.isPlaying()) return true;
        }
        return false;
    }
    /**
     * Pauses the sound
     */
    public void pause(){
        for (GreenfootSound sound : sounds) {
            sound.pause();
        }
    }
}