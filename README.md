
# 📱 Android Developer Assignment – Advanced Mileage Tracker App

## 🧩 Objective
Build an Android application to track mileage accurately for users on the move. The app must allow users to **start/stop a journey**, **track distance in the background**, and **persist data even if the app is killed**. It should work reliably in real-world conditions (low signal, device reboots, battery optimizations).

## 🚀 Functional Requirements

### 1. User Flow
- Home screen with `Start Journey` and `Stop Journey` buttons.
- On starting:
  - A **foreground service** is initiated to collect real-time location updates.
  - Tracking continues in the background (with appropriate permissions).
- On stopping:
  - Tracking stops.
  - The user sees a summary screen with:
    - Total Distance (in KM/MI)
    - Total Duration
    - Start & End Time
    - Map preview of the route (polyline on Google Maps)

### 2. Location Tracking Requirements
- Use `FusedLocationProviderClient` in **high-accuracy mode**.
- Sampling interval: 5–10 seconds, distance filter: 10 meters.
- Calculate distance using Haversine formula or built-in methods.
- Filter out bad GPS points (low accuracy, jitter, teleportation).
- Show real-time distance while tracking if user is on the screen.

### 3. Robust Background Support
- Tracking must continue reliably:
  - When the app goes to the background.
  - If the screen is turned off.
  - If the app is swiped away (use `START_STICKY` service).
  - After device reboot (use `BootReceiver`).
- Show **persistent notification** while tracking with elapsed time.

### 4. Battery & Permission Handling
- Handle runtime permissions:
  - Fine Location
  - Background Location (Android 10+)
- Detect and request user to **exclude app from battery optimizations**.
- Show rationale screens and guide users to settings when permissions are denied.

## 💾 Persistence & Data Handling
- Store journeys locally in a **Room Database**:
  - Save raw coordinates, timestamps, and calculated metrics.
  - Data must persist across restarts.
- Show a **list of past journeys** (RecyclerView).
  - Tapping a journey shows a detail screen with stats + route on map.

## ✅ Bonus (Advanced)
- Handle location drift using Kalman Filter or similar.
- Sync data to Firebase/remote DB when online.
- Add unit & instrumentation tests.
- Support **pause/resume** journey during tracking.

## 🔧 Technical Requirements
- Architecture: MVVM / Clean Architecture
- Libraries:
  - Jetpack Components (ViewModel, LiveData, Room, WorkManager)
  - Google Maps SDK
  - Coroutine / Flow for async tasks
  - Dagger/Hilt (optional)
- Clean, modular, testable code with good naming and comments.

## 📤 Submission Checklist
- Upload the project to a public GitHub repository.
- Include:
  - A README with app overview, setup instructions, and assumptions.
  - Screen recording or screenshots.
  - List of known issues or trade-offs.
  - Mention any advanced features you implemented beyond scope.
