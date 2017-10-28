package com.diwixis.jsonalbum;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Diwixis on 23.10.2017.
 */

public interface IAlbumApi {
    @GET(AlbumUrls.IMAGE_LIST)
    Observable<List<String>> getImages();
}
