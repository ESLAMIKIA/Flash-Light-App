# Flash-Light-App
A minimalist Android flashlight app built with Kotlin, featuring a clean dark UI, custom flashlight graphics, and simple one-tap control.
# 🔦 Flashlight

<p align="center">
  A simple, modern, and minimalist flashlight application for Android.
  <br />
  Built with Kotlin and Android Studio.
</p>

<p align="center">
  <img src="screenshots/app-logo.png" alt="Flashlight Logo" width="160"/>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-green?style=for-the-badge&logo=android" />
  <img src="https://img.shields.io/badge/Language-Kotlin-purple?style=for-the-badge&logo=kotlin" />
  <img src="https://img.shields.io/badge/IDE-Android%20Studio-blue?style=for-the-badge&logo=androidstudio" />
</p>

---

## 📱 About

**Flashlight** is a lightweight Android application designed to turn your phone's LED flashlight on and off with a single tap.

The app focuses on simplicity, usability, and a clean visual experience, featuring a dark interface and custom flashlight graphics.

## ✨ Features

- 🔦 One-tap flashlight ON/OFF control
- 🎨 Minimalist and modern dark UI
- 💡 Custom flashlight graphics and visual effects
- 📱 Portrait screen orientation
- ⚡ Simple and lightweight design
- 🤖 Built natively for Android

## 🖼️ Screenshots

<p align="center"><img width="1080" height="2400" alt="Screenshot_20261112_184453" src="https://github.com/user-attachments/assets/78bdb442-f54f-413f-b631-7eafb4aee0f4" />
<img width="1080" height="2400" alt="Screenshot_20261112_184501" src="https://github.com/user-attachments/assets/2cf1509f-f0bf-4f1e-b196-a0d7d2c6d3f7" />

  <img src="screenshots/flashlight-off.png" alt="Flashlight Off" width="250"/>
  &nbsp;&nbsp;&nbsp;
  <img src="screenshots/flashlight-on.png" alt="Flashlight On" width="250"/>
</p>

<p align="center">
  <i>Flashlight OFF and ON states</i>
</p>

## 🛠️ Built With

- **Kotlin** – Main programming language
- **Android Studio** – Development environment
- **XML** – User interface design
- **Android Camera2 API** – Flashlight control
- **ConstraintLayout** – UI layout

## 🚀 Getting Started

### Requirements

- Android Studio
- Android SDK
- An Android device with an LED flash

### Installation

1. Clone this repository:

   ```bash
   git clone https://github.com/YOUR-USERNAME/Flashlight.git
   ```

2. Open the project in Android Studio.

3. Wait for Gradle synchronization to finish.

4. Connect an Android device or start an emulator.

5. Build and run the application.

## 📂 Project Structure

```text
Flashlight/
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/example/flash_light/
│           ├── res/
│           │   ├── drawable/
│           │   ├── layout/
│           │   └── values/
│           └── AndroidManifest.xml

└── README.md
```

## 🔐 Permissions

The application uses the camera permission to access the device's flashlight.

```xml
<uses-permission android:name="android.permission.CAMERA" />
```

## 📌 Compatibility

Flashlight functionality depends on the device hardware and Android version.

Devices without a camera flash are not supported.

## 👨‍💻 Author

**Amir Erfan Eslamikia**

Developed as an Android application project using Kotlin and Android Studio.

---

<p align="center">
  Made with ❤️ and Kotlin
</p>
