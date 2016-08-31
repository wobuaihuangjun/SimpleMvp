package com.hzj.mvp.delegate;

import android.support.v4.app.FragmentActivity;

import com.hzj.mvp.MvpPresenter;
import com.hzj.mvp.MvpView;


/**
 * The MvpDelegate callback that will be called from  {@link
 * ActivityMvpDelegate}. This interface must be implemented by all
 * Activities that you want to support mosby's mvp.
 *
 * @author Hannes Dorfmann
 * @see MvpDelegateCallback
 * @since 2.0.0
 */
public interface ActivityMvpDelegateCallback<V extends MvpView, P extends MvpPresenter<V>>
        extends MvpDelegateCallback<V, P> {

    /**
     * Return any Object holding the desired state to propagate to the next activity instance. Please
     * note that mosby internals like the presenter are already saved internally and you don't have
     * to take them into account. You can retrieve this value later with {@link
     * ActivityMvpDelegate#getNonMosbyLastCustomNonConfigurationInstance()}.
     * <p/>
     * <p>
     * This mechanism works pretty the same way as {@link FragmentActivity#onRetainCustomNonConfigurationInstance()}
     * and {@link #getNonMosbyLastCustomNonConfigurationInstance()}
     * </p>
     *
     * @return Object holding state.
     */
    public Object onRetainNonMosbyCustomNonConfigurationInstance();

    /**
     * @return Return the value previously returned from {@link FragmentActivity#onRetainCustomNonConfigurationInstance()}.
     */
    public Object getLastCustomNonConfigurationInstance();

    /**
     * This method should invoke {@link
     * ActivityMvpDelegate#getNonMosbyLastCustomNonConfigurationInstance()}.
     * <p/>
     * <p>
     * This method is not really a "callback" method (will not invoked from delegate somehow).
     * However, it's part of this interface to ensure that no custom implementation will miss this
     * method since this method is the counterpart to {@link #onRetainNonMosbyCustomNonConfigurationInstance()}
     * </p>
     */
    public Object getNonMosbyLastCustomNonConfigurationInstance();
}
