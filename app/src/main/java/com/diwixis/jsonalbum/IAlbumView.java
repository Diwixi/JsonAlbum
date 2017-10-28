package com.diwixis.jsonalbum;

import com.arellomobile.mvp.MvpView;

import java.util.List;

/**
 * Created by Diwixis on 23.10.2017.
 */

public interface IAlbumView extends MvpView{
    void showImages(List<String> imageList);
}
