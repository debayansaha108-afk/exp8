# Implementation Plan - Menus & WebView Integration

The goal is to implement a modern, good-looking Android UI that demonstrates the usage of **Options Menus** and a **WebView**.

## User Review Required

> [!IMPORTANT]
> **Internet Permission Required:** I will add the `android.permission.INTERNET` permission to your `AndroidManifest.xml` so the WebView can load external websites.
>
> **Launcher Activity:** I propose setting the new `WebPortalActivity` as the **default launcher Activity** temporarily so you can see the results immediately upon running the app. The previous screens (BankMate and AdaptiveList) will be preserved in the code.

## Proposed Changes

### 1. Permissions & Configuration
#### [MODIFY] [AndroidManifest.xml](file:///C:/Users/DEBAYAN/AndroidStudioProjects/IntentLoginDashboard/app/src/main/AndroidManifest.xml)
- Add `<uses-permission android:name="android.permission.INTERNET" />`.
- Register the new `WebPortalActivity`.
- Set `WebPortalActivity` as the main launcher activity.

### 2. Menu Resources
#### [NEW] `res/menu/web_menu.xml`
- Create an Options Menu layout containing:
  - **Home**: An icon action button to return to the default URL.
  - **Refresh**: An icon action button to reload the page.
  - **Settings**: An overflow menu item.
  - **About**: An overflow menu item.

### 3. UI Layouts
#### [NEW] `res/layout/activity_web_portal.xml`
- A modern UI using a `ConstraintLayout` or `LinearLayout`.
- **MaterialToolbar**: A clean, modern toolbar at the top to host the title and the Options Menu.
- **ProgressBar**: A horizontal loading bar just beneath the toolbar to show page loading progress.
- **WebView**: Takes up the rest of the screen to display web content.

### 4. Activity Logic
#### [NEW] `WebPortalActivity.kt`
- **Toolbar Setup**: Set the `MaterialToolbar` as the action bar using `setSupportActionBar()`.
- **Menu Inflation**: Override `onCreateOptionsMenu` to inflate the new `web_menu.xml`.
- **Menu Handling**: Override `onOptionsItemSelected` to handle actions (e.g., calling `webView.reload()` when Refresh is clicked).
- **WebView Setup**:
  - Enable JavaScript.
  - Set a `WebViewClient` to ensure links open inside the app instead of an external browser.
  - Set a `WebChromeClient` to update the ProgressBar as the page loads.
  - Load a default URL (e.g., `https://www.google.com`).
- **Back Navigation**: Override `onBackPressed` to navigate back in web history if possible, rather than immediately exiting the app.

## Verification Plan

### Automated Tests
- Run `gradlew assembleDebug` to ensure there are no XML, resource, or Kotlin compilation errors.

### Manual Verification
- Run the app on an emulator or physical device.
- Ensure the app launches directly to the new `WebPortalActivity`.
- Verify that a website loads successfully inside the `WebView`.
- Verify the Toolbar displays the menu items (Home, Refresh, and Overflow menu).
- Tap the menu items to ensure they trigger the correct actions (e.g., Refresh reloads the page).
- Verify the progress bar appears and updates while the page is loading.
