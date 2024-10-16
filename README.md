# WortTrainer

WortTrainer is a simple Java application that helps users practice spelling by guessing animal names based on images.

## Features

- Display an image and ask the user to input the correct word.
- Tracks correct and incorrect guesses.
- Saves and loads game progress.

## How to Run

1. Clone the repository:  
   `git clone https://github.com/yourusername/WortTrainer.git`
2. Open the project in your IDE.
3. Ensure you have the `Gson` library included.
4. Run `WortTrainerUI` to start the game.

## Classes

- **WortTrainerUI**: Main class with the GUI. Manages game flow.
- **WortTrainer**: Handles word list, random selection, and input validation.
- **Persistance**: Saves and loads game data to/from a JSON file.
- **WortEintrag**: Represents a word and its associated image URL.

## Dependencies

- `Gson` for JSON parsing.

## Author

Matthias Kurz
