# 🚀 Space Explorer

A Java CLI application that fetches real-time space data from NASA's public API.

## ✨ Features
- 🌌 Astronomy Picture of the Day (APOD)
- 🎥 Supports both image and video media types
- ⚠️ Graceful API error handling
- 🔐 Secure API key management via config file

## 🛠️ Tech Stack
- Java 21
- Maven
- OkHttp (HTTP client)
- Gson (JSON parsing)
- NASA Public API

## ⚙️ Setup

### 1. Clone the repository
git clone https://github.com/thecoderSky/SpaceExplorer.git
cd SpaceExplorer

### 2. Get a free NASA API key
Sign up at https://api.nasa.gov

### 3. Create config file
Create src/main/resources/config.properties and add:
nasa.api.key=YOUR_KEY_HERE

### 4. Run the app
mvn compile exec:java

## 📦 Run without Maven
Download the latest JAR from Releases and run:
java -jar space-explorer-1.0-SNAPSHOT.jar

## 📸 Sample Output
🌌 Astronomy Picture of the Day
================================
📅 Date    : 2026-04-09
📷 Title   : Destruction of Comet C/2026 A1 (MAPS)
🔗 URL     : https://apod.nasa.gov/apod/image/2604/comet_plunge.mp4
📖 Info    : As the crew of Artemis II travelled towards the Moon...

## 🗺️ Roadmap
- [ ] Mars Rover photos
- [ ] Asteroid tracker
- [ ] Spring Boot REST API
- [ ] Deploy to Railway

## 📄 License
MIT License
# SpaceExplorer