package com.github.quadflask.react.navermap;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

import androidx.annotation.NonNull;

import static com.github.quadflask.react.navermap.ReactUtil.toLatLngList;

public class RNNaverMapPathOverlayManager extends EventEmittableViewGroupManager<RNNaverMapPathOverlay> {
    private final DisplayMetrics metrics;

    public RNNaverMapPathOverlayManager(ReactApplicationContext reactContext) {
        super(reactContext);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            metrics = new DisplayMetrics();
            ((WindowManager) reactContext.getSystemService(Context.WINDOW_SERVICE))
                    .getDefaultDisplay()
                    .getRealMetrics(metrics);
        } else {
            metrics = reactContext.getResources().getDisplayMetrics();
        }
    }

    @Override
    String[] getEventNames() {
        return new String[]{
                "onClick"
        };
    }

    @NonNull
    @Override
    public String getName() {
        return "RNNaverMapPathOverlay";
    }

    @NonNull
    @Override
    protected RNNaverMapPathOverlay createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new RNNaverMapPathOverlay(this, reactContext);
    }

    @ReactProp(name = "coordinates")
    public void setCoordinate(RNNaverMapPathOverlay view, ReadableArray coordinates) {
        view.setCoords(toLatLngList(coordinates));
    }

    @ReactProp(name = "width", defaultFloat = 1f)
    public void setStrokeWidth(RNNaverMapPathOverlay view, float widthInPoints) {
        float widthInScreenPx = metrics.density * widthInPoints;
        view.setWidth(widthInScreenPx);
    }

    @ReactProp(name = "zIndex", defaultInt = 0)
    public void setProgress(RNNaverMapPathOverlay view, int zIndex) {
        view.setZIndex(zIndex);
    }

    @ReactProp(name = "color", defaultInt = Color.RED, customType = "Color")
    public void setColor(RNNaverMapPathOverlay view, int color) {
        view.setColor(color);
    }

    @ReactProp(name = "outlineWidth", defaultFloat = 1f)
    public void setOutlineWidth(RNNaverMapPathOverlay view, float widthInPoints) {
        float widthInScreenPx = metrics.density * widthInPoints;
        view.setOutlineWidth(widthInScreenPx);
    }

    @ReactProp(name = "passedColor", defaultInt = Color.RED, customType = "Color")
    public void setPassedColor(RNNaverMapPathOverlay view, int color) {
        view.setPassedColor(color);
    }

    @ReactProp(name = "outlineColor", defaultInt = Color.RED, customType = "Color")
    public void setOutlineColor(RNNaverMapPathOverlay view, int color) {
        view.setOutlineColor(color);
    }

    @ReactProp(name = "passedOutlineColor", defaultInt = Color.RED, customType = "Color")
    public void setPassedOutlineColor(RNNaverMapPathOverlay view, int color) {
        view.setPassedOutlineColor(color);
    }

    @ReactProp(name = "pattern")
    public void setPatternInterval(RNNaverMapPathOverlay view, String image) {
        view.setPattern(image);
    }

    @ReactProp(name = "patternInterval", defaultFloat = 1f)
    public void setPatternInterval(RNNaverMapPathOverlay view, float widthInPoints) {
        int widthInScreenPx = Math.round(metrics.density * widthInPoints);
        view.setPatternInterval(widthInScreenPx);
    }

    @ReactProp(name = "progress", defaultFloat = 0f)
    public void setProgress(RNNaverMapPathOverlay view, float progress) {
        view.setProgress(progress);
    }
}
