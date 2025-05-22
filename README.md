# Object-Oriented Game (Arkanoid-style Java Project)

## Overview

This Java project is a full object-oriented implementation of an Arkanoid-style game developed in multiple stages. It was built as a series of assignments designed to incrementally introduce object-oriented programming concepts such as encapsulation, inheritance, interfaces, listeners (observers), GUI rendering, and real-time animation using the `biuoop` library.

The game includes features like bouncing balls, interactive paddle, block collision handling, score tracking, ball and block removal using the listener pattern, and custom game mechanics.

---

## Project Structure

The project is divided into four major parts, each building on the previous one:

### Part 1: Java Fundamentals

* **Factorial.java**: Computes factorials both iteratively and recursively.
* **DescribeNumbers.java**: Accepts a list of numbers and prints the min, max, and average.
* **Sort.java**: Sorts a list of integers in ascending or descending order using bubble sort.

### Part 2: Geometry, GUI, and Animation

* **Geometry Primitives**:

  * `Point`, `Line`, `Rectangle`: Represent 2D points and geometric objects with support for intersection logic.
* **Drawing and Random Art**:

  * `AbstractArtDrawing`: Uses `biuoop` to render lines, their midpoints, and intersections.
* **Animation**:

  * `Ball`, `Velocity`: Represent moving ball objects with speed and direction.
  * `BouncingBallAnimation`, `MultipleBouncingBallsAnimation`, `MultipleFramesBouncingBallsAnimation`: Animate balls bouncing inside frames or the screen.

### Part 3: Arkanoid Game Core

* **Interfaces**:

  * `Sprite`, `Collidable`: Represent drawable game objects and collidable objects.
* **Core Components**:

  * `Ball`, `Block`, `Paddle`: Core game entities. `Paddle` reacts to keyboard input.
  * `GameEnvironment`: Manages all collidable objects.
  * `SpriteCollection`: Manages all drawable and updatable objects.
  * `Game`: Initializes and runs the main game loop.
  * `Ass3Game`: Launches the game with two balls, a paddle, and a block layout.

### Part 4: Game Mechanics and Listener Pattern

* **Events and Listeners**:

  * `HitListener`, `HitNotifier`: Interfaces for the observer pattern.
  * `BlockRemover`, `BallRemover`, `ScoreTrackingListener`: Listener classes for removing blocks, removing balls, and updating score.
* **Game Enhancements**:

  * Blocks are removed only if the ball hitting them is a different color.
  * Ball adopts the color of the block it hits.
  * Game ends when all blocks are removed or all balls fall below the screen.
* **Score System**:

  * `ScoreIndicator`: Displays the score at the top of the screen.
  * Additional 100 points are awarded for clearing all blocks.
* **Ass5Game**: Launches the full-featured game with score, multiple balls, colored block interactions, and end conditions.

---

## How to Run

using intelliJ tool for java is the best option



## Features

* Procedural Java tasks (factorial, sorting, statistics)
* Geometry modeling and GUI rendering
* Ball animations with velocity and collision detection
* Fully playable Arkanoid-style game with paddle control
* Listener-based event handling for real-time block/ball removal
* Score system with visual score display
* Organized into packages: `sprites`, `geometry`, `general`, `listeners`, `collisions`

---


## Notes

* Paddle wraps around screen horizontally.
* Collision detection uses geometric math and bounding boxes.
* Followed strict Java coding style and modular design.
project is part of a university course and is intended for educational purposes only.
