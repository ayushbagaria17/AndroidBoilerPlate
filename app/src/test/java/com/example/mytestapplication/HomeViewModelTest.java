package com.example.mytestapplication;


import com.example.mytestapplication.feature.ui.home.HomeInteractor;
import com.example.mytestapplication.feature.ui.home.HomeViewModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;

import io.reactivex.Single;

import static org.mockito.Mockito.when;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class HomeViewModelTest {
    @Mock private HomeInteractor interactor;
    @InjectMocks private HomeViewModel viewModel;

    @Before
    public void setup() {
       when(interactor.getData()).thenReturn(Single.just(Arrays.asList("A", "B")));
    }

    @Test
    public void checkGotTheData() {
        Assert.assertEquals("Didn't get the data", viewModel.gotTheData.get());
    }

}