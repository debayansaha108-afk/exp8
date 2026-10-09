# Walkthrough - Menus and WebView Implementation

I have successfully added a new `WebPortalActivity` to your application, demonstrating how to use Options Menus and WebViews with a clean, modern UI.

## Key Additions

### 1. Options Menu (`web_menu.xml`)
- Created a new XML menu resource file containing standard browser actions.
- **Home & Refresh**: These items use `app:showAsAction="ifRoom"`, so they appear directly on the Toolbar as icons.
- **Settings & About**: These items use `app:showAsAction="never"`, meaning they are tucked neatly into the overflow menu (the three vertical dots).

### 2. Modern UI Layout (`activity_web_portal.xml`)
- Integrated a `MaterialToolbar` to act as the modern ActionBar hosting the menu.
- Added a horizontal `ProgressBar` directly beneath the toolbar. It is bound to the WebView's loading state, so it fills up as a web page loads and disappears when finished.
- Added the `WebView` container to render web content in the remaining screen space.

### 3. Application Logic (`WebPortalActivity.kt`)
- **Toolbar Setup**: Programmatically set the custom Toolbar as the Action Bar.
- **Menu Handling**: Inflated the menu and added `onOptionsItemSelected` logic. Clicking "Refresh" reloads the page, clicking "Home" resets the URL, and clicking overflow items triggers Toast messages.
- **WebView Configuration**:
  - Enabled JavaScript (`settings.javaScriptEnabled = true`) for modern web compatibility.
  - Set a `WebViewClient` to ensure links clicked inside the webpage stay inside your app, rather than opening an external browser like Chrome.
  - Set a `WebChromeClient` to capture the loading progress (from 0 to 100) and update the `ProgressBar` accordingly.
- **Back Navigation**: Overrode the device's back button behavior. If there is page history in the WebView (e.g., you clicked a link), pressing back will go to the previous web page. If there is no history, it will exit the activity as normal.

### 4. Configuration Changes
- Added the crucial `<uses-permission android:name="android.permission.INTERNET" />` to the Manifest.
- Temporarily set the new `WebPortalActivity` as the app's launcher so you can test it immediately.

---

## How to Test

1. **Run the Application**. It will launch directly into the new Web Portal screen.
2. **Observe the Loading Bar**: Notice the progress bar moving underneath the toolbar as the default URL (Android.com) loads.
3. **Interact with the Menu**:
   - Tap the **Refresh** icon in the toolbar.
   - Tap the three dots (overflow menu) and select **About** to see the Toast message.
4. **Test Web Navigation**:
   - Click any link on the loaded webpage. Notice how it stays inside your app.
   - Use your device's physical or swipe **Back button**. Notice that it navigates back in the web history instead of closing the app!
