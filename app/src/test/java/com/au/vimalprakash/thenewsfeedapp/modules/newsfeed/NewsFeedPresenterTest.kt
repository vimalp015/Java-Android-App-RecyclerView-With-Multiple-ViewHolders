package com.au.vimalprakash.thenewsfeedapp.modules.newsfeed

import com.au.vimalprakash.thenewsfeedapp.modules.rxutils.TestSchedulersProvider
import com.au.vimalprakash.thenewsfeedapp.networking.NewsFeedApi
import com.au.vimalprakash.thenewsfeedapp.networking.NewsFeedResponse
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations.initMocks

class NewsFeedPresenterTest {
    @Mock
    private lateinit var view: NewsFeedContract.View

    @Mock
    private lateinit var newsFeedApi: NewsFeedApi

    @Mock
    private lateinit var newsFeedResponse: NewsFeedResponse

    private lateinit var presenter: NewsFeedContract.Presenter

    @Before
    fun setUp() {
        initMocks(this)
        presenter = NewsFeedPresenter(newsFeedApi, TestSchedulersProvider())
    }

    @Test
    fun loadNewsFeedOnGetNewsFeed(){
        // given
        presenter.attachView(view)
        val assets = arrayListOf<NewsFeedResponse.Assets>()
        Mockito.`when`(newsFeedResponse.assets).thenReturn(assets)
        Mockito.`when`(newsFeedApi.newsFeed).thenReturn(Single.just(newsFeedResponse))

        // when
        presenter.getNewsFeed()

        // then
        verify(view).hideLoading()
        verify(view).updateNewsFeed()
        verify(view).setCouldNotLoadLayoutVisibility(false)
    }
}