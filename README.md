# Hytale-AudioPlayerComponent
A library for playing sounds from a list in sequence or randomly with capability for looping. Currently exists as a workaround tool for the lack of audio functionality in the early versions of Hytale.

## Usage:
### Adding the componenet to the world
You can either: /n
>a) addComponent to any entity you like.
>It will require a TransformComponent and a UUIDComponent.
or
>b) Use the component's built in spawn function as such:
>```AudioPlayerComponent variableName = AudioPlayerComponent.spawnNewAudioComponentEntity(vector3dSpawnPosition, componentAccessor)```
<sup>componentAccessor can anything implementing ComponentAccessor e.g. Store or CommandBuffer</sup>

