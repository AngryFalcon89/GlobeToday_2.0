package com.example.newsapp.presentation.onBoarding.viewModel

sealed class OnBoardingEvent {
    object SaveAppEntry: OnBoardingEvent()
}