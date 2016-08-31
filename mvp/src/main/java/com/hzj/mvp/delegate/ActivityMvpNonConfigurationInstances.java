package com.hzj.mvp.delegate;


import com.hzj.mvp.MvpPresenter;
import com.hzj.mvp.MvpView;

/**
 * This kind of class is used in Activities to save the presenter in retaining activities.  It's a
 * mosby internal class.
 *
 * @author Hannes Dorfmann
 * @since 2.0.0
 */
class ActivityMvpNonConfigurationInstances<V extends MvpView, P extends MvpPresenter<V>> {

    /**
     * The reference to the presenter
     */
    P presenter;

    /**
     * The reference to the custom non configuration.
     */
    Object nonMosbyCustomConfigurationInstance;

    /**
     * Constructor
     *
     * @param presenter                           The retaining presenter
     * @param nonMosbyCustomConfigurationInstance the other custom object
     */
    ActivityMvpNonConfigurationInstances(P presenter, Object nonMosbyCustomConfigurationInstance) {
        this.presenter = presenter;
        this.nonMosbyCustomConfigurationInstance = nonMosbyCustomConfigurationInstance;
    }
}
