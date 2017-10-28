package com.diwixis.jsonalbum;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumActivity extends MvpAppCompatActivity implements IAlbumView {
    @InjectPresenter AlbumPresenter presenter;
    @BindView(R.id.image_container) RecyclerView imageContainer;
    Point size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        ButterKnife.bind(this);
        presenter.getImagePaths();
        size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
    }

    @Override
    public void showImages(List<String> imageList) {
        GridAdapter adapter = new GridAdapter();
        adapter.setData(imageList, size.x);

        imageContainer.setLayoutManager(new GridLayoutManager(this, AlbumApp.getColumnCounts()));
        imageContainer.setAdapter(adapter);
    }
}
