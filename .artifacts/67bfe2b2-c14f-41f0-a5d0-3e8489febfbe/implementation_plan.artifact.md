# Extended Basic Views Implementation

The goal is to demonstrate more interactive components from the Android "Basic Views" library by adding a "Preferences" section to the Dashboard.

## Proposed Changes

### UI Components (Basic Views)

#### [MODIFY] [activity_dashboard.xml](file:///C:/Users/DEBAYAN/AndroidStudioProjects/IntentLoginDashboard/app/src/main/res/layout/activity_dashboard.xml)
- Wrap existing content in a `ScrollView` to handle scrolling.
- Add a new "App Preferences" card containing:
    - **Switch**: For "Push Notifications" toggle.
    - **CheckBox**: For "Accept Terms" or "Subscribe" options.
    - **RadioGroup & RadioButtons**: For selecting "App Theme" (Light, Dark, System).
    - **SeekBar**: For "Font Size" adjustment simulation.
- Ensure all components follow the existing aesthetic (rounded cards, modern colors).

### Logic Implementation

#### [MODIFY] [DashboardActivity.kt](file:///C:/Users/DEBAYAN/AndroidStudioProjects/IntentLoginDashboard/app/src/main/java/com/example/intentlogindashboard/DashboardActivity.kt)
- Initialize all new views.
- Add listeners for:
    - `Switch`: Show a Toast when toggled.
    - `CheckBox`: Update UI state based on check.
    - `RadioGroup`: Identify which option was selected.
    - `SeekBar`: Show the current value in a Toast or TextView.

### Git & Verification

#### [UPDATE] Git Push
- Commit and push the new interactive features to the `main` branch.

## Verification Plan

### Automated Tests
- `gradlew assembleDebug` to ensure no syntax errors in the new XML components.

### Manual Verification
- Deploy to emulator/device.
- Interact with each new component:
    - Toggle the Switch.
    - Check/Uncheck the CheckBox.
    - Change the Radio selection.
    - Slide the SeekBar.
- Confirm all Toast messages or UI updates appear as expected.
