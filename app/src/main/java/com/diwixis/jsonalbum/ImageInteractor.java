package com.diwixis.jsonalbum;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Diwixis on 23.10.2017.
 */

public class ImageInteractor {
    private final IAlbumApi api;

    public ImageInteractor(IAlbumApi api) {
        this.api = api;
    }

    public Observable<List<String>> getImages(){
        return api.getImages();
    }
}
