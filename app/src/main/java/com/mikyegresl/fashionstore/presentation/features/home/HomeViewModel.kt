package com.mikyegresl.fashionstore.presentation.features.home

import androidx.lifecycle.viewModelScope
import com.mikyegresl.fashionstore.Constants
import com.mikyegresl.fashionstore.domain.landing.ILandingInteractor
import com.mikyegresl.fashionstore.domain.promotions.IPromotionInteractor
import com.mikyegresl.fashionstore.domain.promotions.Promotion
import com.mikyegresl.fashionstore.domain.utils.Resource
import com.mikyegresl.fashionstore.presentation.common.IEventBus
import com.mikyegresl.fashionstore.presentation.common.IIntent
import com.mikyegresl.fashionstore.presentation.common.StateViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.*

class HomeViewModel(
    private val landingInteractor: ILandingInteractor,
    private val promotionInteractor: IPromotionInteractor,
    private val eventBus: IEventBus
) : StateViewModel<HomeState>() {

    private var promotions: LinkedList<Promotion>? = null
    private var changePromotionJob: Job? = null

    override val _state: MutableStateFlow<HomeState> = MutableStateFlow(
        HomeState(
            landing = null,
            promotions = emptyList(),
            currentPromotion = null
        )
    )

    init {
        viewModelScope.launch {
            eventBus.events.collect(::observeIntents)
        }
    }

    private fun observeIntents(intent: IIntent) {
        when (intent) {
            HomeIntent.Initialize -> {
                loadLandingData()
                loadPromotionData()
            }
            HomeIntent.Clear -> {
                cancelPromotionJob()
            }
        }
    }

    private fun loadLandingData() {
        doBackground(
            work = {
                updateState(
                    state.value.copy(
                        isLoading = true
                    )
                )
                when (val result = landingInteractor.getLandingData()) {
                    is Resource.Success -> {
                        updateState(
                            state.value.copy(
                                isLoading = false,
                                landing = result.data,
                                errorMessage = null
                            )
                        )
                    }
                    is Resource.Error -> {
                        updateState(
                            state.value.copy(
                                isLoading = false,
                                landing = null,
                                errorMessage = result.error
                            )
                        )
                    }
                }
            },
            loaderEnabled = true,
            onError = {
                updateState(
                    state.value.copy(
                        isLoading = false,
                        errorMessage = it.message ?: Constants.UNKNOWN_ERROR,
                        landing = null
                    )
                )
            }
        )
    }

    private fun loadPromotionData() {
        doBackground(
            work = {
                updateState(
                    state.value.copy(
                        isLoading = true
                    )
                )
                when (val result = promotionInteractor.getPromotions()) {
                    is Resource.Success -> {
                        val promotionList = result.data

                        if (promotionList.isNullOrEmpty()) {
                            updateState(
                                state.value.copy(
                                    isLoading = false,
                                    promotions = emptyList(),
                                    currentPromotion = null,
                                    errorMessage = null
                                )
                            )
                        } else {
                            updateState(
                                state.value.copy(
                                    isLoading = false,
                                    promotions = promotionList,
                                    currentPromotion = promotionList.first(),
                                    errorMessage = null
                                )
                            )
                            promotions = LinkedList(promotionList)
                            nextPromotionItem()
                        }
                    }
                    is Resource.Error -> {
                        updateState(
                            state.value.copy(
                                isLoading = false,
                                promotions = emptyList(),
                                currentPromotion = null,
                                errorMessage = result.error
                            )
                        )
                    }
                }
            },
            loaderEnabled = true,
            onError = {
                updateState(
                    state.value.copy(
                        isLoading = false,
                        errorMessage = it.message ?: Constants.UNKNOWN_ERROR,
                        promotions = emptyList(),
                        currentPromotion = null
                    )
                )
            }
        )
    }

    private fun nextPromotionItem() {
        promotions?.let {
            if (it.isNotEmpty()) {
                changePromotionJob = viewModelScope.launch {
                    while (it.size > 0) {
                        delay(currentState.currentPromotion?.duration?.toLong() ?: 1000L)
                        val nextPromotion = it.pollLast()
                        it.addFirst(nextPromotion)
                        updateState(
                            state.value.copy(
                                currentPromotion = nextPromotion
                            )
                        )
                    }
                }
            }
        }
    }

    private fun cancelPromotionJob() {
        changePromotionJob?.let {
            if (it.isActive) {
                it.cancel()
            }
        }
    }

    fun initialize() {
        viewModelScope.launch {
            eventBus.send(intent = HomeIntent.Initialize)
        }
    }

    fun clearJobs() {
        viewModelScope.launch {
            eventBus.send(intent = HomeIntent.Clear)
        }
    }
}