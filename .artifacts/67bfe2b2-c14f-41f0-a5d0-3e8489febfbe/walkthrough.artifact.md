# Walkthrough - Adaptive UI with ListView & Custom Adapter

I have successfully implemented a brand new screen demonstrating an Adaptive UI using a `ListView` and `ImageView`.

## Key Components

### 1. Data Model (`ListItem.kt`)
Created a simple data class to hold the information for each row in the list:
- `imageResId`: To store the icon/image for the item.
- `title`: The primary text.
- `subtitle`: The secondary descriptive text.

### 2. Custom Adapter (`CustomListAdapter.kt`)
This is the core of the "Adaptive UI". It extends `ArrayAdapter` to dynamically inflate custom views (`list_item_card.xml`) for each piece of data in the `dataSource`. It utilizes the View Recycling pattern (`convertView`) for smooth scrolling and memory efficiency.

### 3. Beautiful UI Layouts
- **`list_item_card.xml`**: A modern `CardView` based layout for individual list rows. It features an `ImageView` with a circular background, a bold title, and a descriptive subtitle.
- **`activity_adaptive_list.xml`**: The main screen that holds a clean header and the `ListView` itself, with dividers hidden for a modern card-list appearance.

### 4. Application Logic (`AdaptiveListActivity.kt`)
This new activity acts as the controller:
- It prepares a sample list of generic services (Photography, Navigation, Communications, etc.) using built-in Android drawable icons.
- It binds this data to the `ListView` via the `CustomListAdapter`.
- It implements an `OnItemClickListener` to show a Toast message when a user taps a specific row.

---

## How to Test

1. **Run the Application**: I have updated the `AndroidManifest.xml` to make `AdaptiveListActivity` the default launcher.
2. **Observe the List**: When the app opens, you will immediately see a beautiful list of services.
3. **Scroll**: Try scrolling up and down. The `ListView` combined with the Custom Adapter ensures the UI is responsive and adaptive.
4. **Interact**: Tap on any card in the list, and a Toast will appear confirming your selection (e.g., "Clicked on: Image Gallery").

> [!NOTE]
> The previous BankMate code is completely untouched and preserved. If you wish to switch back to the BankMate dashboard as the default startup screen later, you just need to move the `<intent-filter>` back to `AccountActivity` in the `AndroidManifest.xml`.
