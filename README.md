# MeshCall — Offline Mesh Communication

<p align="center">
  <strong>Connect. Communicate. Stay Connected.</strong>
</p>

<p align="center">
  A peer-to-peer Android communication app designed to enable nearby communication without depending on traditional internet connectivity.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-3DDC84?logo=android&logoColor=white" alt="Android" />
  <img src="https://img.shields.io/badge/Language-Kotlin-7F52FF?logo=kotlin&logoColor=white" alt="Kotlin" />
  <img src="https://img.shields.io/badge/Communication-Wi--Fi%20Direct-6366F1" alt="Wi-Fi Direct" />
  <img src="https://img.shields.io/badge/Storage-SQLite-003B57" alt="SQLite" />
  <img src="https://img.shields.io/badge/Status-Active%20Development-orange" alt="Active Development" />
</p>

---

## 🚀 Overview

**MeshCall** is an Android application built to explore decentralized communication using nearby devices and wireless peer-to-peer networking.

Traditional messaging and calling applications usually depend on internet connectivity and centralized infrastructure. MeshCall explores an alternative approach by enabling devices to discover nearby peers and communicate directly over local wireless connections.

The project combines Wi-Fi Direct, socket-based communication, and local data storage to create a foundation for communication in situations where conventional connectivity may be unavailable.

Our vision is simple: **bridge the communication gap when the internet is not available.**

## ✨ Key Features

- **📡 Nearby Device Discovery** — Discover nearby Android devices using Wi-Fi Direct.
- **💬 Offline Text Messaging** — Exchange messages over supported peer-to-peer connections without requiring internet access.
- **🔀 Multi-Hop Message Routing** — Forward messages through intermediate devices to reach peers beyond a direct connection, where a valid route exists.
- **📞 Voice Calling** — Real-time voice communication over a supported direct connection.
- **🖼️ Photo and File Sharing** — Share supported media and files between connected peers.
- **📍 Location Sharing** — Share location information with other users.
- **💾 Local Message Storage** — Store application data locally using SQLite.
- **🗺️ Offline Map Integration** — Explore offline map functionality through Organic Maps integration.
- **🎨 Modern UI** — A clean dashboard with Home, Chats, Radar, and Calls navigation.
- **🌗 Light and Dark Themes** — Switch between light and dark appearances from Settings, with the selected preference saved locally.

> **Note:** Communication range, multi-hop delivery, calling, and file transfer depend on device compatibility, permissions, connection state, and the availability of a working route. Multi-hop voice calling is not claimed as a supported feature.

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Kotlin | Android application development |
| Android SDK | Native Android functionality |
| XML Layouts | User interface design |
| Wi-Fi Direct (Wi-Fi P2P) | Nearby device discovery and peer connections |
| TCP Sockets | Data exchange between connected devices |
| SQLite | Local data persistence |
| GPS / LocationManager | Location-related functionality |
| Android Services | Background communication tasks |
| Organic Maps | Offline map integration |

## 🏗️ How It Works

```text
        Device A
           |
     Wi-Fi Direct
           |
     Device B
      /       \
  Direct     Forward
 Connection   Message
      \       /
        Device C
```

1. **Discovery:** Devices search for nearby peers using Wi-Fi Direct.
2. **Connection:** Compatible devices establish a supported peer-to-peer connection.
3. **Communication:** The application exchanges data using socket-based communication.
4. **Routing:** When a valid route is available, text messages can be forwarded through intermediate devices.
5. **Persistence:** Relevant application data is stored locally.

MeshCall is designed around peer-to-peer communication rather than requiring a central messaging server for its local communication flow.

## 📱 Getting Started

### Prerequisites

- Android Studio
- Android SDK compatible with the project configuration
- A compatible Android device
- USB debugging enabled for physical-device testing
- Wi-Fi Direct support on the devices used for testing

### Installation

**1. Clone the repository**

```bash
git clone https://github.com/imadeelakhtar/MeshCall-Application.git
```

**2. Open the project**

Open the cloned `MeshCall-Application` folder in Android Studio and allow Gradle synchronization to finish.

**3. Build the application**

On Windows PowerShell:

```powershell
.\gradlew.bat assembleDebug
```

On macOS or Linux:

```bash
./gradlew assembleDebug
```

**4. Install and run**

Connect a compatible Android device, select it in Android Studio, and click **Run**.

The debug APK is generated at:

```text
app/build/outputs/apk/debug/app-debug.apk
```

### Testing Multi-Device Communication

For meaningful testing:

1. Install the application on at least two compatible Android devices.
2. Grant the permissions requested by the application.
3. Enable Wi-Fi and the required nearby-device settings.
4. Discover and connect the devices.
5. Test messaging and other available features.
6. For multi-hop testing, use at least three devices and verify message forwarding through an intermediate peer.

Actual results may vary depending on Android versions, manufacturer-specific Wi-Fi Direct behavior, and wireless conditions.

## 🗺️ Offline Maps

MeshCall includes integration with Organic Maps for offline map functionality.

Offline map availability depends on the map data installed on the device. Download the required regional map through the supported map application before relying on offline navigation.

## 🔒 Privacy and Connectivity

- Local communication is designed to work without relying on a conventional internet connection.
- Application data can be stored locally on the device.
- Location-related features require appropriate permissions.
- Wi-Fi Direct and socket communication have range and device-compatibility limitations.

MeshCall should not be assumed to provide end-to-end encryption or emergency-grade reliability unless those properties have been independently implemented and verified.

## 🛣️ Future Scope

- Improve multi-hop route discovery and reliability.
- Strengthen connection recovery and message delivery handling.
- Improve cross-device compatibility.
- Expand offline-first communication capabilities.
- Refine the calling and media-sharing experience.
- Improve diagnostics and connection-status visibility.
- Add comprehensive automated and physical-device tests.

## 🤝 Contributing

Contributions, ideas, and feedback are welcome.

1. Fork the repository.
2. Create a feature branch.
3. Make focused changes and test them.
4. Submit a pull request describing the changes.

Please avoid committing API keys, signing credentials, personal data, or other secrets.

## 👨‍💻 Project

**MeshCall — Offline Mesh Communication**

GitHub: [imadeelakhtar/MeshCall-Application](https://github.com/imadeelakhtar/MeshCall-Application)

Built to explore a more resilient, decentralized approach to nearby communication.

---

<p align="center">
  <strong>MeshCall — Communication beyond connectivity.</strong>
</p>
