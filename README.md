# KMP Multimodule Template

A fully modular Kotlin Multiplatform (KMP) project showcasing:
- **Shared business logic** and API definitions in `common` modules
- **Multiplatform Compose UI** targeting Android, iOS, Desktop (JVM) and Web (JS/WASM)
- **Ktor backend** with PostgreSQL persistence via JetBrains Exposed
- **Modular, feature-based architecture** with layered modules (api, data, presentation, compose)
- **Navigation** via Decompose and **Dependency Injection** via Koin

<img width="780" height="564" alt="Снимок экрана 2025-08-07 в 15 49 22" src="https://github.com/user-attachments/assets/ded16a25-3e9d-4d96-9916-ce3a8835a7f9" />
<img width="718" height="685" alt="Снимок экрана 2025-08-07 в 15 50 40" src="https://github.com/user-attachments/assets/d5010e14-384f-4af6-a464-8e34655ad976" />
<img width="426" height="908" alt="Снимок экрана 2025-08-07 в 15 49 53" src="https://github.com/user-attachments/assets/e2e32546-5f66-4417-b4d4-81230a4f84a9" />
<img width="375" height="750" alt="Снимок экрана 2025-08-07 в 15 51 20" src="https://github.com/user-attachments/assets/000a4d76-4efe-4039-9f1a-e513e2cb136f" />
<img width="382" height="767" alt="Снимок экрана 2025-08-07 в 15 51 24" src="https://github.com/user-attachments/assets/df01992f-6d9e-4752-8247-991bb8fbd3f5" />

---

## Table of Contents
1. [Project Overview](#project-overview)
2. [Architecture & Modules](#architecture--modules)
3. [Tech Stack](#tech-stack)

---

## Project Overview

This repository demonstrates a complete Kotlin Multiplatform setup in 2025: one codebase, many platforms. You get:

- A **`common`** layer for business logic, models and feature wiring.
- A **Compose Multiplatform** client (`composeApp`) for Android, iOS, Desktop & Web.
- A **Ktor** server (`server`) using **PostgreSQL** and **Exposed** for data.
- **Feature modules** (e.g. `auth`, `posts`, `profile`) each split into `api`, `data`, `presentation`, and `compose` submodules as needed.

User flows, data access, UI and navigation are all implemented in Kotlin, maximizing code reuse and consistency.

---

## Architecture & Modules

### Root Modules
- **`build-logic`**  
  Custom Gradle plugins and shared build scripts (Conventions, ComposeSetup, ModuleSetup).
- **`convention`**  
  Internal convention plugin applying common settings across modules.

### Common Multiplatform Modules (`common`)
- **`common:core`**  
  Core configurations & utilities: Kotlin serialization, Coroutines, Ktor client setup, SQLDelight DB config (`AppDatabase`), and Koin DI modules.
- **`common:core-compose`**  
  Shared Compose UI toolkit: themes, components (AppToolbar, ThemedButton/TextField), desktop window settings.
- **`common:core-presentation`**  
  Presentation-layer abstractions: ViewModel and Decompose core interfaces.
- **Feature Modules** (e.g. `common:auth`, `common:posts`, `common:profile`):  
  1. **`api`**: Public interfaces and data models (repositories, DTOs).  
  2. **`data`**: Repository implementations and data sources (Ktor for remote, Settings/local storage).  
  3. **`presentation`**: UI logic components (Decompose flows, ViewModels) that depend on `api`.  
  4. **`compose`**: Compose screens/widgets for each feature, depending on `presentation` and `core-compose`.
- **`common:root`**  
  Root wiring of feature modules into a single application graph.
- **`common:umbrella`**  
  Aggregates all Koin modules and initializes `PlatformSDK` with `PlatformConfiguration`.

### Client Applications
- **`composeApp`**  
  Multiplatform Compose application targeting:
  - Android (`androidMain`)
  - iOS (`iosMain`)
  - Desktop JVM (`desktopMain`)
  - JS/WASM (`wasmJsMain`)  
  Uses Decompose for navigation and Koin for DI.
- **`iosApp`**  
  Xcode project to launch the iOS framework produced by `composeApp`.
- **`kotlin-js-store`**  
  Standalone JS/React-style web client (WASM/JS) built from Compose sources.

### Server
- **`server`**  
  Ktor-based backend exposing REST endpoints.  
  Persistence via PostgreSQL using JetBrains **Exposed** modules:
  - `exposed-core` for DSL
  - `exposed-dao` for Active-Record style
  - `exposed-jdbc` for JDBC integration

---

## Tech Stack
- **Language:** Kotlin 1.x, Kotlin Multiplatform
- **UI:** Compose Multiplatform, Decompose (navigation)
- **DI:** Koin
- **Networking:** Ktor client & server
- **Database:** SQLDelight (local), Exposed + PostgreSQL (server)
- **Build:** Gradle, custom convention plugins
