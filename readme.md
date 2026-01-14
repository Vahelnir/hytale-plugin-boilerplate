# Hytale Plugin Boilerplate

This project is a minimalist boilerplate to quickly create a Hytale plugin. It is mainly intended for personal use, but is public for anyone who wants to use or get inspired by it.

## Features

- Basic structure to develop a Hytale plugin
- Ready to use with Gradle
- Example commands and code organization

## Requirements

To make the project work properly:

1. Have `Assets.zip` in the `server/` folder (by copying the file or doing a symlink/hardlink)
2. Have `HytaleServer.jar` into the `server/` folder (by copying the file or doing a symlink/hardlink)

## Installation & Usage

```bash
# To build the plugin
./gradlew build

# To launch the Hytale server with the plugin
./gradlew runServer
```

## Project Structure

- `src/main/java/` : Plugin source code
- `src/main/resources/` : Resource files
- `server/` : Hytale server folder (requires Assets.zip and HytaleServer.jar)

## Notes

This boilerplate is intentionally simple. Feel free to adapt it to your needs!
