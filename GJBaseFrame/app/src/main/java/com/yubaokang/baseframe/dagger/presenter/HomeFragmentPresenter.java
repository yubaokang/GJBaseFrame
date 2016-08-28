package com.yubaokang.baseframe.dagger.presenter;

import com.yubaokang.baseframe.dagger.contract.HomeFragmentContract;
import com.yubaokang.baseframe.dagger.scopes.ActivityScope;
import com.yubaokang.baseframe.model.response.WeiXinDataListRes;
import com.yubaokang.baseframe.views.App;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yubao on 2016/8/27.
 */
@ActivityScope
public class HomeFragmentPresenter implements HomeFragmentContract.Presenter {
    private HomeFragmentContract.View view;
    private Observable<WeiXinDataListRes> call;

    public HomeFragmentPresenter(HomeFragmentContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        call = App.getComponent().request().getWeiXin(view.loadPageNum() + "");
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WeiXinDataListRes>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(WeiXinDataListRes weiXinDataListRes) {
                        view.showDatas(weiXinDataListRes);
                    }
                });
    }

    @Override
    public void cancel() {
        call.unsubscribeOn(Schedulers.io());
    }
}
