# Doug's Dog Door System

This project implements an automated dog door system that can be controlled either by a remote control or by recognizing specific dog barks.

## System Components

### DogDoor
The main component that represents the physical dog door. It can be opened and closed, and automatically closes after 5 seconds of being opened. It maintains a list of allowed barks for authentication.

### Bark
Represents a dog's bark sound. Each bark has a unique sound signature that can be used for identification.

### BarkRecognizer
A component that listens for barks and verifies them against the list of allowed barks. If a recognized bark is detected, it automatically opens the dog door.

### Remote
A remote control device that can manually open and close the dog door by pressing a button.

## Features

- Automatic door closing after 5 seconds
- Bark recognition for automatic door opening
- Manual control via remote
- Support for multiple allowed barks
- Thread-safe operation with proper logging

## Usage

1. Create a new `DogDoor` instance
2. Add allowed barks using `addAllowedBark()`
3. Create a `BarkRecognizer` instance with the door
4. Create a `Remote` instance with the door
5. Use either the remote or bark recognition to control the door

## Example

```java
DogDoor door = new DogDoor();
door.addAllowedBark(new Bark("woof"));

BarkRecognizer recognizer = new BarkRecognizer(door);
Remote remote = new Remote(door);

// Use remote to open/close door
remote.pressButton();

// Or use bark recognition
recognizer.recognize(new Bark("woof"));
```

## Thread Safety

The system is designed to be thread-safe and includes proper logging of thread operations for debugging purposes. 