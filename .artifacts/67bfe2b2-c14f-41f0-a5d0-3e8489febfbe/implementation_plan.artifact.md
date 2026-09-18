# Implementation Plan - BankMate Personal Banking App

Build a professional, MCA-practical-friendly banking application named **BankMate** within the current project.

## User Review Required

> [!IMPORTANT]
> - **Launcher Change**: `AccountActivity` will become the main entry point to streamline the demonstration.
> - **Package Preservation**: All files will strictly use `com.example.intentlogindashboard`.
> - **Modern UI**: I will use a "Glassmorphism" and "Material 3" hybrid design for a high-end banking feel while keeping the code simple.

## Proposed Changes

### 1. Project Configuration
- **Dependencies**: Add `androidx.fragment:fragment-ktx` and `androidx.cardview:cardview` to `build.gradle.kts`.
- **Manifest**:
    - Add `POST_NOTIFICATIONS` permission.
    - Set `AccountActivity` as the launcher.
    - Register `TransactionActivity`.
    - Clean up previous placeholder activities.

### 2. Resources (Aesthetics)
- **Colors**: Deep Indigo (`#1A237E`), Success Green (`#2E7D32`), Background Light (`#F5F7FA`).
- **Drawables**:
    - `card_bg_balance`: Gradient blue/purple with rounded corners.
    - `btn_gradient`: Professional blue button background.
    - `input_field_bg`: Clean, thin-bordered background for EditTexts.
- **Strings**: Centralize all labels, hints, and Toast messages.

### 3. Core Activities & Fragments
- **AccountActivity**:
    - Main Dashboard with Profile Info and Balance.
    - Fragment container for switching between Details, Transfer, and History.
    - **Lifecycle Logging**: Full implementation of all 6 methods with `Log.d`.
- **Fragments**:
    - `AccountDetailsFragment`: Card-based static info.
    - `FundTransferFragment`: Form with `RadioGroup` and validation.
    - `TransactionHistoryFragment`: List of sample transactions.
- **TransactionActivity**:
    - Confirmation screen.
    - Transaction ID generation (Timestamp + Random).
    - Notification trigger.
    - **Lifecycle Logging**: Full implementation.

### 4. Notification System
- **NotificationHelper**: Utility class to create channels and send notifications.
- Handles Android 13+ permissions gracefully.

## Verification Plan

### Automated Tests
- `gradlew assembleDebug` to ensure zero compilation errors.
- Resource ID check to prevent runtime crashes.

### Manual Verification
- **Functional Flow**: Verify navigation: Home -> Transfer -> Input -> Confirm -> Success -> Done -> Home.
- **Validation**: Test "Confirm Transfer" with empty fields to ensure error handling works.
- **Logging**: Monitor Logcat filter `BankMateLifecycle` to prove lifecycle events are captured.
- **Notifications**: Ensure a system notification appears after clicking "Confirm Transfer".
