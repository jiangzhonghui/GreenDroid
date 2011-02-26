/*
 * Copyright (C) 2010 Cyril Mottier (http://www.cyrilmottier.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package greendroid.app;

import greendroid.widget.GDActionBar;
import greendroid.widget.GDActionBarItem;
import android.app.Activity;
import android.app.Application;
import android.widget.FrameLayout;

/**
 * Defines all methods related to Activities embedding an {@link GDActionBar}
 * 
 * @author Cyril Mottier
 */
public interface GDActionBarActivity {

    /**
     * The key to use to set the title of the launched GDActionBarActivity
     */
    static final String GD_ACTION_BAR_TITLE = "greendroid.app.GDActionBarActivity.GD_ACTION_BAR_TITLE";

    /**
     * Clients may use this method to listen to {@link GDActionBarItem}s clicks.
     * 
     * @param item The {@link GDActionBarItem} that has been clicked
     * @param position The position of the clicked item. This number is equal or
     *            greater to zero. 0 is the leftmost item.
     * @return true if the method has handled the click on the
     *         {@link GDActionBarItem} at position <em>position</em>. Otherwise it
     *         returns false.
     */
    boolean onHandleActionBarItemClick(GDActionBarItem item, int position);

    /**
     * Returns the content view. Please note the content view is not the entire
     * view but a {@link FrameLayout} that contains everything but the {@link GDActionBar}.
     * 
     * @return The content view
     */
    FrameLayout getContentView();

    /**
     * Returns the {@link GDActionBar}. Listening to {@link GDActionBar} events
     * should be done via the
     * {@link GDActionBarActivity#onHandleActionBarItemClick(GDActionBarItem, int)}
     * method. Most of the time, this method don't need to be used directly.
     * 
     * @see {@link GDActionBarActivity#onHandleActionBarItemClick(GDActionBarItem, int)}
     * @see {@link GDActionBarActivity#addActionBarItem(GDActionBarItem)}
     * @see {@link GDActionBarActivity#addActionBarItem(greendroid.widget.GDActionBarItem.Type)}
     * @return The {@link GDActionBar} currently displayed on screen
     */
    GDActionBar getGDActionBar();

    /**
     * A simple utility method that casts the {@link Application} returned by
     * {@link #getApplication()} into a {@link GDApplication}
     * 
     * @return The current {@link GDApplication}
     */
    GDApplication getGDApplication();

    /**
     * Add a new item to the {@link GDActionBar}.
     * 
     * @param item The item to add to the {@link GDActionBar}
     */
    void addActionBarItem(GDActionBarItem item);

    /**
     * Adds a new item of type <em>type</em> to the {@link GDActionBar}.
     * 
     * @param actionBarItemType The item to add to the {@link GDActionBar}
     */
    void addActionBarItem(GDActionBarItem.Type actionBarItemType);

    /**
     * Returns the identifier of the layout that needs to be created for this
     * {@link GDActionBarActivity}
     * 
     * @return The layout identifier of the layout to create
     */
    int createLayout();

    /**
     * Called at the beginning of the {@link Activity#onContentChanged()}
     * method. This may be used to initialize all references on elements.
     */
    void onPreContentChanged();

    /**
     * Called at the end of the {@link Activity#onContentChanged()} method. This
     * may be use to initialize the content of the layout (titles, etc.)
     */
    void onPostContentChanged();
}