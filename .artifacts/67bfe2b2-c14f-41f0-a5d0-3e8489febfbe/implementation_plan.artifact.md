# Implementation Plan - Dark Theme Gallery UI with Bottom Controls

The goal is to overhaul the existing `ImageGridActivity` to closely match the vibe and layout of the provided screenshot while integrating it seamlessly into our app.

## User Review Required

> [!IMPORTANT]
> This is a significant UI overhaul. I will:
> 1.  Change the screen's theme to a **Dark Theme** (`#121212` background) with a **Neon Yellow/Green** accent color.
> 2.  Move the "Select All" action from the top menu to a new **Bottom Action Bar** alongside "Clear Selection" and "View Selected".
> 3.  Add titles and subtitles overlaid at the bottom of each image.
> 4.  Update the selection style to use a neon border and top-left checkmark instead of a dark overlay.

## Proposed Changes

### 1. Colors & Drawables (Theming)
- **Colors**: Add `dark_bg` (#121212), `dark_surface` (#1E1E1E), `neon_accent` (#D4FF00).
- **Drawables**:
  - `bg_neon_pill.xml`: For the "X/9 SELECTED" top indicator.
  - `bg_chip_dark.xml`: For the bottom filter chips ("Mixed", "Ocean", etc.).
  - `card_selected_stroke.xml`: For the neon border around selected items.
  - `gradient_bottom_shadow.xml`: For the text readability at the bottom of the images.
  - `bg_neon_button.xml`: For the "View Selected" action button.

### 2. Data Model Update
#### [MODIFY] `GridImageItem.kt`
- Add `title: String` and `subtitle: String` properties so each image can display text like "Coastal Cliff" and "frame_coastal.webp".

### 3. Layout Restructuring
#### [MODIFY] `activity_image_grid.xml`
- Remove the standard `AppBarLayout`/`Toolbar`.
- **Top Bar**: A custom `LinearLayout` containing a hamburger icon, "Gallery" title, and the neon "X/9 SELECTED" pill.
- **Grid**: Adjust the `GridView` constraints so it sits between the top bar and the bottom controls. Change standard padding/spacing.
- **Bottom Filter Bar**: A horizontal `ScrollView` or `LinearLayout` with dummy filter chips (Search, Mixed, Ocean, Road, Creative).
- **Bottom Action Bar**: A horizontal layout at the very bottom with:
  - "Select All" (Dark rounded button)
  - "Clear Selection" (Dark rounded button)
  - "View Selected" (Bright neon rounded button)

#### [MODIFY] `grid_item_layout.xml`
- Change aspect ratio to be slightly taller (e.g., 3:4 or 4:5) instead of 1:1 to match the screenshot.
- Add the `gradient_bottom_shadow` view at the bottom.
- Add `TextView`s for Title and Subtitle positioned at the bottom left.
- Move the checkmark to the top left and color it neon.
- Implement the neon stroke/border that becomes visible when `isSelected == true`.

### 4. Logic Updates
#### [MODIFY] `ImageGridActivity.kt`
- Hide the default ActionBar.
- Update the mock data to include appropriate titles and subtitles (e.g., "Blue Mountains", "frame_blue_mountains.webp").
- Remove the old `onCreateOptionsMenu`.
- Implement click listeners for the new bottom buttons ("Select All", "Clear Selection", "View Selected").
- Create a function to dynamically update the "X/X SELECTED" pill text whenever the selection changes.

#### [MODIFY] `GridImageAdapter.kt`
- Bind the new titles and subtitles.
- Bind the new neon selection border and top-left checkmark states.
- Call back to the Activity when an item's selection changes so the top counter can update.

## Verification Plan

### Automated Tests
- Run `gradlew assembleDebug` to verify no breaking changes to data models or layouts.

### Manual Verification
- Open the app and verify the dark theme and neon accents are applied.
- Verify the images have titles overlaid at the bottom.
- Click images individually and verify the neon border and top-left checkmark appear.
- Check that the top right pill accurately counts the selections (e.g., "3 / 9 SELECTED").
- Click "Select All" at the bottom and ensure all 9 items select.
- Click "Clear Selection" and ensure all items deselect.
- Verify the bottom filter chips are present and scrollable.
