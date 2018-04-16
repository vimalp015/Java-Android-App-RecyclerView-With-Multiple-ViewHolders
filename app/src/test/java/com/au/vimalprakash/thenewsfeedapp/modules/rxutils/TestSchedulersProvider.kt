package com.au.vimalprakash.thenewsfeedapp.modules.rxutils

import com.au.vimalprakash.thenewsfeedapp.utils.SchedulersProvider

import io.reactivex.Scheduler
import io.reactivex.annotations.NonNull
import io.reactivex.schedulers.Schedulers

class TestSchedulersProvider : SchedulersProvider {
    @NonNull
    override fun mainUiThread(): Scheduler {
        return Schedulers.trampoline()
    }

    @NonNull
    override fun io(): Scheduler {
        return Schedulers.trampoline()
    }

    @NonNull
    override fun computation(): Scheduler {
        return Schedulers.trampoline()
    }

    @NonNull
    override fun immediate(): Scheduler {
        return Schedulers.trampoline()
    }
}
