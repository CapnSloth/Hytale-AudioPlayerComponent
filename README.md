# Hytale-AudioPlayerComponent
A library for playing sounds from a list in sequence or randomly with capability for looping. Currently exists as a workaround tool for the lack of audio functionality in the early versions of Hytale.

## Usage:
### Adding the componenet to the world

You can either:

a) Do existingHolder.addComponent(ref, AudioPlayerComponent.getComponentType()) to any entity you like.
It will require the entity also having a TransformComponent and a UUIDComponent.

or

b) Use the component's built in spawn function as such:

AudioPlayerComponent audioPlayer = AudioPlayerComponent.spawnNewAudioPlayerEntity(vector3dSpawnPosition, componentAccessor)
<sup>componentAccessor can anything implementing ComponentAccessor e.g. Store or CommandBuffer</sup>

*Note: Using spawnNewAudioPlayerEntity will set it's own selfUUID variable to the UUID of the entity which the returned component is attached to in case you need it later.*



### Adding and Removing sounds

The sound list can be modified using:
+ audioPlayer.addSound(soundId)
+ audioPlayer.addSounds(arrayOfSoundIds)
+ audioPlayer.removeSound(soundId)
+ audioPlayer.removeSounds(arrayOfSoundIds)

Where "soundId" is the name of the SoundEvent Asset JSON file.
**Not** the .ogg file name.

The add/remove sound methods will automatically cache the duration of the .ogg file.

*Note: currently only the first sound in the first layer of the sound asset is read and played.*



### Playing sounds

The recommended way to play a loop is to set
  + audioPlayer.autoplay = true;
    
      and/or
    
  + audioPlayer.autoplayAsRandom = true;
    
This will be handled by the AudioPlayerSystem automatically.
Sounds can then be added or removed as needed.


You can also use any of the audioPlayer's doLoop(), playSound(), or playRandomSound() methods for manual control.

It is recommended to set autoPlay to false if managing manually.



### Pausing sounds
To my knowledge Hytale lacks this functionality built-in.
However a hacky workaround I've used is as follows:

1. Using a audio editing software (e.g. Audacity), chop the sound into smaller pieces.
  *Smaller is better as it will pause with less delay, but this can become unmanageablee with longer sound effects.*

2. Create a new SoundEvent asset for each piece of the sound effect.

3. Store the names of these in an array somewhere.
  e.g.  public String[] creakingSounds = {"creakingSFX0", "creakingSFX1", "creakingSFX2", "creakingSFX3"};

4. Create a new audio player and add the sounds array to it with addSounds(array).

5. Set audioPlayer.autoplay to true when you need the sounds to play and false to pause.

6. (Optional) If there is undesired silence between the sounds when playing: adjust audioPlayer.allowedOverlap to a value in nanoseconds.
  This will cause the component to allow playing the next sound before the current one has fully finished.
  Useful for conteracting latency or blending sounds better when random mode is on.













