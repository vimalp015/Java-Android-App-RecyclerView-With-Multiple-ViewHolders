package com.au.vimalprakash.thenewsfeedapp.modules.mainactivity

import com.au.vimalprakash.thenewsfeedapp.Events.LoadWebViewEvent
import com.au.vimalprakash.thenewsfeedapp.modules.rxutils.TestSchedulersProvider
import com.au.vimalprakash.thenewsfeedapp.utils.RxBus
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations.initMocks



class MainActivityPresenterTest {
    @Mock
    private lateinit var view: MainAcivityContract.View

    private lateinit var presenter: MainAcivityContract.Presenter

    @Before
    fun setUp() {
        initMocks(this)
        presenter = MainActivityPresenter(TestSchedulersProvider())
    }

    @Test
    fun loadWebUrlWhenLoadWebViewEventIsFired(){
        //given
        presenter.attachView(view)

        //when
        RxBus.getDefault().post(LoadWebViewEvent("example.com"))

        //then
        verify(view).loadWebUrl("example.com")
    }
}