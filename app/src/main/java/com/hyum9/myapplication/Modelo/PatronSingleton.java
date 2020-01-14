package com.hyum9.myapplication.Modelo;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class PatronSingleton {

    private static PatronSingleton mInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static Context mCtx;


    private PatronSingleton(Context context){
        mCtx = context;
        mRequestQueue = getRequestQueue();

        mImageLoader = new ImageLoader(mRequestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<>(20);

                    @Override
                    public Bitmap getBitmap(String url) { return cache.get(url);}

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) { }
                });
    }


    public static synchronized PatronSingleton getInstance(Context context)
    {
        if(mInstance == null) {
            mInstance = new PatronSingleton(context);
        }
        return mInstance;
    }


    public RequestQueue getRequestQueue() {
        if(mRequestQueue == null)
        {
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req){getRequestQueue().add(req);}

    public ImageLoader getImageLoader() {return mImageLoader;}
}
