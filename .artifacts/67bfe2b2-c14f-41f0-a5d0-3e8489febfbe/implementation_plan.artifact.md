# Implementation Plan - Adaptive UI with ListView and ImageView

The goal is to create a modern, aesthetically pleasing screen that demonstrates an "Adaptive UI" (using a Custom Adapter) with a `ListView` and `ImageView`. This is a classic Android pattern where an Adapter dynamically creates views for list items based on a data source.

## User Review Required

> [!IMPORTANT]
> **Navigation:** To demonstrate this new screen easily, I propose setting this new `AdaptiveListActivity` as the **default launcher Activity** in `AndroidManifest.xml` temporarily. This way, when you run the app, you will immediately see the new ListView UI. The previous BankMate application will remain intact in the code. Let me know if you'd prefer to add a button in the BankMate dashboard to open this instead!

## Proposed Changes

### 1. Data Model & Adapter
#### [NEW] [ListItem.kt](file:///C:/Users/DEBAYAN/AndroidStudioProjects/IntentLoginDashboard/app/src/main/java/com/example/intentlogindashboard/ListItem.kt)
- A simple data class holding an image resource ID, a title, and a subtitle for each list item.

#### [NEW] [CustomListAdapter.kt](file:///C:/Users/DEBAYAN/AndroidStudioProjects/IntentLoginDashboard/app/src/main/java/com/example/intentlogindashboard/CustomListAdapter.kt)
- A custom `ArrayAdapter` that inflates our custom layout and binds the `ListItem` data (Image and Text) to the UI components.

### 2. UI Layouts
#### [NEW] [activity_adaptive_list.xml](file:///C:/Users/DEBAYAN/AndroidStudioProjects/IntentLoginDashboard/app/src/main/res/layout/activity_adaptive_list.xml)
- The main screen layout containing a `ListView` and a modern header.

#### [NEW] [list_item_card.xml](file:///C:/Users/DEBAYAN/AndroidStudioProjects/IntentLoginDashboard/app/src/main/res/layout/list_item_card.xml)
- A beautiful, rounded `CardView` layout for individual list rows. It will feature an `ImageView` on the left and text on the right.

### 3. Activity & Configuration
#### [NEW] [AdaptiveListActivity.kt](file:///C:/Users/DEBAYAN/AndroidStudioProjects/IntentLoginDashboard/app/src/main/java/com/example/intentlogindashboard/AdaptiveListActivity.kt)
- The Activity that initializes a list of sample data (e.g., a list of tech stacks or services with corresponding icons) and binds the `CustomListAdapter` to the `ListView`.

#### [MODIFY] [AndroidManifest.xml](file:///C:/Users/DEBAYAN/AndroidStudioProjects/IntentLoginDashboard/app/src/main/AndroidManifest.xml)
- Register `AdaptiveListActivity`.
- Set it as the main launcher activity for easy demonstration.

## Verification Plan

### Automated Tests
- Build the project using `gradlew assembleDebug` to ensure all new files compile without errors.

### Manual Verification
- Run the app on an emulator or physical device.
- Verify that the app launches into the new list screen.
- Scroll through the list to ensure the adaptive recycling works perfectly.
- Ensure the images load properly and the UI matches the high-quality modern aesthetic.
