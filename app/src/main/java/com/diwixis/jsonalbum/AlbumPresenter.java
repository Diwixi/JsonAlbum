package com.diwixis.jsonalbum;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Diwixis on 23.10.2017.
 */

@InjectViewState
public class AlbumPresenter extends MvpPresenter<IAlbumView> {
    private ImageInteractor interactor;

    List<String> getImagePaths(){
        interactor = new ImageInteractor(AlbumApp.getApi());
        interactor.getImages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(imageList -> {
                    getViewState().showImages(imageList);
                });
        return null;
    }

}
