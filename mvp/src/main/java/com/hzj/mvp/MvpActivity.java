package com.hzj.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import com.hzj.mvp.delegate.ActivityMvpDelegate;
import com.hzj.mvp.delegate.ActivityMvpDelegateCallback;
import com.hzj.mvp.delegate.ActivityMvpDelegateImpl;


/**
 * An Activity that uses an {@link MvpPresenter} to implement a Model-View-Presenter
 * architecture.
 *
 * @author Hannes Dorfmann
 * @since 1.0.0
 */
public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter<V>>
    extends FragmentActivity implements ActivityMvpDelegateCallback<V, P>, MvpView {

  protected ActivityMvpDelegate mvpDelegate;
  protected P presenter;
  protected boolean retainInstance;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getMvpDelegate().onCreate(savedInstanceState);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    getMvpDelegate().onDestroy();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    getMvpDelegate().onSaveInstanceState(outState);
  }

  @Override
  protected void onPause() {
    super.onPause();
    getMvpDelegate().onPause();
  }

  @Override
  protected void onResume() {
    super.onResume();
    getMvpDelegate().onResume();
  }

  @Override
  protected void onStart() {
    super.onStart();
    getMvpDelegate().onStart();
  }

  @Override
  protected void onStop() {
    super.onStop();
    getMvpDelegate().onStop();
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    getMvpDelegate().onRestart();
  }

  @Override
  public void onContentChanged() {
    super.onContentChanged();
    getMvpDelegate().onContentChanged();
  }

  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    getMvpDelegate().onPostCreate(savedInstanceState);
  }

  /**
   * Instantiate a presenter instance
   *
   * @return The {@link MvpPresenter} for this view
   */
  @NonNull
  public abstract P createPresenter();

  /**
   * Get the mvp delegate. This is internally used for creating presenter, attaching and detaching
   * view from presenter.
   *
   * <p><b>Please note that only one instance of mvp delegate should be used per Activity
   * instance</b>.
   * </p>
   *
   * <p>
   * Only override this method if you really know what you are doing.
   * </p>
   *
   * @return {@link ActivityMvpDelegateImpl}
   */
  @NonNull
  protected ActivityMvpDelegate<V, P> getMvpDelegate() {
    if (mvpDelegate == null) {
      mvpDelegate = new ActivityMvpDelegateImpl(this);
    }

    return mvpDelegate;
  }

  @NonNull
  @Override
  public P getPresenter() {
    return presenter;
  }

  @Override
  public void setPresenter(@NonNull P presenter) {
    this.presenter = presenter;
  }

  @NonNull
  @Override
  public V getMvpView() {
    return (V) this;
  }

  @Override
  public boolean isRetainInstance() {
    return retainInstance;
  }

  @Override
  public boolean shouldInstanceBeRetained() {
    return retainInstance && isChangingConfigurations();
  }

  @Override
  public void setRetainInstance(boolean retainInstance) {
    this.retainInstance = retainInstance;
  }

  @Override
  public Object onRetainNonMosbyCustomNonConfigurationInstance() {
    return null;
  }

  /**
   * Internally used by Mosby. Use {@link #onRetainNonMosbyCustomNonConfigurationInstance()} and
   * {@link #getNonMosbyLastCustomNonConfigurationInstance()}
   */
  @Override
  public final Object onRetainCustomNonConfigurationInstance() {
    return getMvpDelegate().onRetainCustomNonConfigurationInstance();
  }

  @Override
  public final Object getNonMosbyLastCustomNonConfigurationInstance() {
    return getMvpDelegate().getNonMosbyLastCustomNonConfigurationInstance();
  }
}
